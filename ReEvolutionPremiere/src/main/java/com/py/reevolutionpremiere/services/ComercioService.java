package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.ComercioCategoriaEntidad;
import com.py.reevolutionpremiere.entities.ComercioDueñoEntidad;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
import com.py.reevolutionpremiere.entities.repositories.ComercioCategoriaRepository;
import com.py.reevolutionpremiere.entities.repositories.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ComercioCategoriaRepository comercioCategoriaRepository;
    private final ComercioDTOMapper comercioDTOMapper;


    @Autowired
    public ComercioService(ComercioRepository comercioRepository,
                           ComercioCategoriaRepository comercioCategoriaRepository,
                           ComercioDTOMapper comercioDTOMapper)
    {
        this.comercioRepository = comercioRepository;
        this.comercioCategoriaRepository = comercioCategoriaRepository;
        this.comercioDTOMapper = comercioDTOMapper;
    }

    public Optional<ComercioDTO> getComercioById(Integer codigoComercio) {
        return Optional.of(comercioRepository.findById(codigoComercio)
                .map(comercioDTOMapper)
                .orElseThrow());
    }

    public List<ComercioDTO> getComercios() {
        return comercioRepository.findAll()
                .stream()
                .map(comercioDTOMapper)
                .toList();
    }

    public void newComercio(ComercioDTO comercioDTO) {
        //Traer la entidad Categoria
        Optional<ComercioCategoriaEntidad> categoriaEntidad = Optional.ofNullable(comercioCategoriaRepository.findByNombreCategoria(comercioDTO.categoria().nombre()));
        //Crear la entidad Dueño
        ComercioDueñoEntidad dueñoEntidad = new ComercioDueñoEntidad();

        //Crear la entidad representante
        ComercioEntidad comercio;
        //comercioRepository.save(comercio);
    }
}