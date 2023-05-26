package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.entities.ComercioEntidad;
import com.py.reevolutionpremiere.services.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService){
        this.comercioService = comercioService;
    }

    @GetMapping()
    public @ResponseBody List<ComercioEntidad> getAllUsers(){
        return comercioService.getComercios();
    }

    @GetMapping("/{codigoComercio}")
    public @ResponseBody ComercioEntidad encontrarbyId(ComercioEntidad comercio){
        return comercioService.encontarComercio(comercio);
    }

    @PostMapping()
    public @ResponseBody void nuevoComercio(ComercioEntidad comercio) {
        comercioService.setComercios(comercio);

    }
}