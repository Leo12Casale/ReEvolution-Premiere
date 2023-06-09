package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.*;
import com.py.reevolutionpremiere.entities.repositories.ComercioCategoriaRepository;
import com.py.reevolutionpremiere.entities.repositories.ComercioDueñoRepository;
import com.py.reevolutionpremiere.entities.repositories.ComercioRepository;
import com.py.reevolutionpremiere.entities.repositories.ComercioRepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ComercioCategoriaRepository comercioCategoriaRepository;
    private final ComercioDueñoRepository comercioDueñoRepository;
    private final ComercioRepresentanteRepository comercioRepresentanteRepository;
    private final ComercioDTOMapper comercioDTOMapper;


    @Autowired
    public ComercioService(ComercioRepository comercioRepository,
                           ComercioCategoriaRepository comercioCategoriaRepository,
                           ComercioDueñoRepository comercioDueñoRepository,
                           ComercioRepresentanteRepository comercioRepresentanteRepository,
                           ComercioDTOMapper comercioDTOMapper)
    {
        this.comercioRepository = comercioRepository;
        this.comercioCategoriaRepository = comercioCategoriaRepository;
        this.comercioDueñoRepository = comercioDueñoRepository;
        this.comercioRepresentanteRepository = comercioRepresentanteRepository;
        this.comercioDTOMapper = comercioDTOMapper;
    }

    public Optional<ComercioDTO> getComercioById(Integer codigoComercio) {
        return Optional.of(comercioRepository.findById(codigoComercio)
                .map(comercioDTOMapper)
                .orElseThrow());
    }

    public List<ComercioDTO> getComercios() {
        List<ComercioEntidad> comercioEntidad = comercioRepository.findAll();
        return comercioEntidad.stream()
                .filter(comercio -> !comercio.getBorrado())
                .map(comercioDTOMapper)
                .toList();
    }

    public void newComercio(ComercioDTO comercioDTO) {
        //Traer la entidad Categoria
        Optional<ComercioCategoriaEntidad> categoriaEntidad = Optional.ofNullable(comercioCategoriaRepository.findByNombreCategoria(comercioDTO.categoria()));

        //Crear la entidad Dueño
        ComercioDueñoEntidad dueñoEntidad = new ComercioDueñoEntidad(
                null,
                comercioDTO.dueño().nombre(),
                comercioDTO.dueño().apellido(),
                comercioDTO.dueño().email(),
                comercioDTO.dueño().telefono(),
                null
        );
        comercioDueñoRepository.save(dueñoEntidad);

        //Crear la entidad representante
        ComercioRepresentanteEntidad representanteEntidad = null;
        if(comercioDTO.representante() != null){
            representanteEntidad = new ComercioRepresentanteEntidad(
                    null,
                    comercioDTO.representante().nombre(),
                    comercioDTO.representante().apellido(),
                    comercioDTO.representante().email(),
                    comercioDTO.representante().telefono(),
                    comercioDTO.representante().puesto(),
                    null
            );
            comercioRepresentanteRepository.save(representanteEntidad);
        }
        ComercioEntidad comercioEntidad = new ComercioEntidad(
                comercioDTO.codigoComercio(),
                comercioDTO.razonSocial(),
                comercioDTO.nombreFantasia(),
                comercioDTO.cuit(),
                comercioDTO.condicionIva(),
                comercioDTO.importeConsumos(),
                comercioDTO.importeComisiones(),
                comercioDTO.diaCobro(),
                comercioDTO.telefono(),
                comercioDTO.email(),
                comercioDTO.direccion(),
                comercioDTO.localidad(),
                comercioDTO.provincia(),
                comercioDTO.codigoPostal(),
                comercioDTO.observaciones(),
                false,
                comercioDTO.comisiones(),
                null,
                null,
                null,
                categoriaEntidad.get(),
                dueñoEntidad,
                representanteEntidad,
                null,
                null
        );
        comercioRepository.save(comercioEntidad);
    }

    public void modificarComercio(ComercioDTO comercioDTO){
        newComercio(comercioDTO);
    }

    public void eliminarComercio(Integer codigoComercio){
        ComercioEntidad comercioEntidad = comercioRepository.findById(codigoComercio).orElse(null);
        if (comercioEntidad != null && comercioEntidad.getImporteConsumos() == 0){
            int existenpagada = comercioRepository.deleteIfNoUnpaidFacturas(codigoComercio);
            if (existenpagada == 0){
            comercioEntidad.setBorrado(true);
            comercioRepository.save(comercioEntidad);}
        }

    }
}