package com.py.reevolutionpremiere;

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

    public List<ComercioEntidad> getComercios(){
        return comercioRepository.findAll();
    }
}
