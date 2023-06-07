package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
import com.py.reevolutionpremiere.services.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;}

    @GetMapping()
    public List<ComercioDTO> getAllUsers() {
        return comercioService.getComercios();
    }

    @GetMapping("/{codigoComercio}")
    public ComercioDTO getComercioById(@PathVariable Integer codigoComercio) {
        if(comercioService.getComercioById(codigoComercio).isPresent())
            return comercioService.getComercioById(codigoComercio).get();
        return null;
    }

    @PostMapping()
    public void newComercio(@RequestBody ComercioDTO comercioDTO) {
        comercioService.newComercio(comercioDTO);
    }
    @PatchMapping("/{codigoComercio}")
    public void updateComercio(@PathVariable Integer codigoComercio, @RequestBody ComercioDTO comercioDTO){
        comercioService.getComercioById(codigoComercio);
        comercioService.modificarComercio(comercioDTO);

    }
    @DeleteMapping ("/{codigoComercio}")
    public void deleteComercio(@PathVariable Integer codigoComercio){
        comercioService.eliminarComercio(codigoComercio);
    }
}