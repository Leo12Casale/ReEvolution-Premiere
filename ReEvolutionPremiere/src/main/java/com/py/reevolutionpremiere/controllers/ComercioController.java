package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.services.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;}

    @GetMapping()
    public List<ComercioDTO> getAllComercios() {
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
    public ResponseEntity<String> updateComercio(@PathVariable Integer codigoComercio, @RequestBody ComercioDTO comercioDTO){
        if(comercioService.modificarComercio(codigoComercio, comercioDTO))
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    @DeleteMapping ("/{codigoComercio}")
    public void deleteComercio(@PathVariable Integer codigoComercio){
        comercioService.eliminarComercio(codigoComercio);
    }
}