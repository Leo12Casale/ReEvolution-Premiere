package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
import com.py.reevolutionpremiere.entities.repositories.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ComercioDTOMapper comercioDTOMapper;


    @Autowired
    public ComercioService(ComercioRepository comercioRepository, ComercioDTOMapper comercioDTOMapper) {
        this.comercioRepository = comercioRepository;
        this.comercioDTOMapper = comercioDTOMapper;
    }

    public List<ComercioDTO> getComercios() {
        return comercioRepository.findAll()
                .stream()
                .map(comercioDTOMapper)
                .toList();
    }

    public void newComercio(ComercioDTO comercio) {

        //comercioRepository.save(comercio);
    }

    public Optional<ComercioDTO> getComercioById(Integer codigoComercio) {
        return Optional.of(comercioRepository.findById(codigoComercio)
                .map(comercioDTOMapper)
                .orElseThrow());
    }
}
