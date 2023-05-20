package com.reevolutionpremiere.ReEvolutionPremiere.controller;

import com.reevolutionpremiere.ReEvolutionPremiere.repository.Comercio;
import com.reevolutionpremiere.ReEvolutionPremiere.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {

    @Autowired
    private ComercioRepository comercioRepository;

    @GetMapping(path = "")
    public @ResponseBody Iterable<Comercio> getAllUsers(){
        return comercioRepository.findAll();
    }
}
