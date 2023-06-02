package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.services.ComercioService;
import com.py.reevolutionpremiere.transferobjects.ComercioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping()
    public List<ComercioDTO> getAllUsers() {
        return comercioService.getComercios();
    }

    @GetMapping("/{codigoComercio}")
    public ComercioDTO encontrarbyId(@PathVariable Integer codigoComercio) {
        ComercioDTO comercioDTO = comercioService.encontarComercio(codigoComercio);
        return comercioDTO;
    }

    @PostMapping()
    public void nuevoComercio(@RequestBody ComercioDTO comercioDTO) {
        comercioService.setComercios(comercioDTO);
    }
}