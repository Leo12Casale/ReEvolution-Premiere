package com.reevolutionpremiere.ReEvolutionPremiere.service;

import com.reevolutionpremiere.ReEvolutionPremiere.repository.Comercio;
import com.reevolutionpremiere.ReEvolutionPremiere.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {

    private final ComercioRepository comercioRepository;

    @Autowired
    public ComercioService(ComercioRepository comercioRepository){
        this.comercioRepository = comercioRepository;
    }

    public List<Comercio> getComercios() {
        return comercioRepository.findAll();
    }
}
