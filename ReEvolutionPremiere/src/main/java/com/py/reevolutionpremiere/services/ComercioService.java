package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.*;
import com.py.reevolutionpremiere.entities.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ComercioCategoriaRepository comercioCategoriaRepository;
    private final ComercioRepresentanteRepository comercioRepresentanteRepository;
    private final FacturaComercioRepository facturaComercioRepository;
    private final DomicilioRepository domicilioRepository;
    private final ComercioDTOMapper comercioDTOMapper;


    @Autowired
    public ComercioService(ComercioRepository comercioRepository,
                           ComercioCategoriaRepository comercioCategoriaRepository,
                           ComercioRepresentanteRepository comercioRepresentanteRepository,
                           FacturaComercioRepository facturaComercioRepository,
                           DomicilioRepository domicilioRepository,
                           ComercioDTOMapper comercioDTOMapper)
    {
        this.comercioRepository = comercioRepository;
        this.comercioCategoriaRepository = comercioCategoriaRepository;
        this.comercioRepresentanteRepository = comercioRepresentanteRepository;
        this.facturaComercioRepository = facturaComercioRepository;
        this.domicilioRepository = domicilioRepository;
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
                .map(comercioDTOMapper)
                .toList();
    }

    public void newComercio(ComercioDTO comercioDTO) {
        //Traer la entidad Categoria
        Optional<ComercioCategoriaEntidad> categoriaEntidad = Optional.ofNullable(comercioCategoriaRepository.findByNombreCategoria(comercioDTO.categoria()));
        //Crear la entidad representante
        ComercioRepresentanteEntidad representanteEntidad = null;
        if(comercioDTO.representante() != null){
            representanteEntidad = new ComercioRepresentanteEntidad(
                    null,
                    comercioDTO.representante().nombre(),
                    comercioDTO.representante().apellido(),
                    comercioDTO.representante().email(),
                    comercioDTO.representante().telefono(),
                    null
            );
        }
        //Crear la entidad domicilio
        DomicilioEntidad domicilioEntidad = null;
        if(comercioDTO.domicilio() != null) {
            domicilioEntidad = new DomicilioEntidad(
                    null,
                    comercioDTO.domicilio().provincia(),
                    comercioDTO.domicilio().localidad(),
                    comercioDTO.domicilio().calle(),
                    comercioDTO.domicilio().numeroCalle(),
                    comercioDTO.domicilio().codigoPostal(),
                    comercioDTO.domicilio().pisoDepto(),
                    comercioDTO.domicilio().numeroDepto(),
                    comercioDTO.domicilio().observaciones(),
                    null
            );
        }
        //Crear la entidad comercio finalmente
        ComercioEntidad comercioEntidad = new ComercioEntidad(
                comercioDTO.codigoComercio(),
                comercioDTO.razonSocial(),
                comercioDTO.nombreFantasia(),
                comercioDTO.cuit(),
                comercioDTO.ingresosBrutos(),
                comercioDTO.condicionIva(),
                0.0,
                0.0,
                comercioDTO.diaCobro(),
                comercioDTO.comisiones(),
                null,
                null,
                null,
                categoriaEntidad.get(),
                representanteEntidad,
                null,
                null,
                domicilioEntidad
        );
        comercioRepresentanteRepository.save(representanteEntidad);
        domicilioRepository.save(domicilioEntidad);
        comercioRepository.save(comercioEntidad);
    }

    public void modificarComercio(ComercioDTO comercioDTO){
        newComercio(comercioDTO);
    }

    public void eliminarComercio(Integer codigoComercio){
        ComercioEntidad comercioEntidad = comercioRepository.findById(codigoComercio).orElse(null);
        //Si no tiene consumos
        if (comercioEntidad != null && comercioEntidad.getImporteConsumos() == 0) {
            //Si no tiene facturas
            List<FacturaComercioEntidad> facturaComercioEntidad = (List<FacturaComercioEntidad>) facturaComercioRepository.findAllByIdComercio(codigoComercio);
            if (comercioEntidad.getFacturaComerciosByCodigoComercio() != null)
                comercioRepository.delete(comercioEntidad);
        }
    }
}