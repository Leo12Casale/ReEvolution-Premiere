package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.services.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de peticiones HTTP relacionados a los Comercios
 */
@RestController
@RequestMapping(path = "/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    /**
     * Retorna todos los datos visibles de un comercio en particular.
     * @param codigoComercio a consultar.
     * @return JSON con datos del comercio.
     */
    @GetMapping("/{codigoComercio}")
    public ComercioDTO getComercioById(@PathVariable Integer codigoComercio) {
        if (comercioService.getComercioById(codigoComercio).isPresent())
            return comercioService.getComercioById(codigoComercio).get();
        return null;
    }

    /**
     * Retorna todos los datos visibles de todos los comercios.
     * @return Array de JSONs con datos de todos los comercios.
     */
    @GetMapping()
    public List<ComercioDTO> getAllComercios() {
        //TODO: paginar
        return comercioService.getComercios();
    }

    /**
     * Crea una entidad de comercio, validando que estén todos los datos necesarios.
     * @param comercioDTO nuevo.
     */
    @PostMapping()
    public void newComercio(@RequestBody ComercioDTO comercioDTO) {
        //TODO: hacer validaciones
        comercioService.newComercio(comercioDTO);
    }

    /**
     * Modifica los datos de un comercio, haciendo las validaciones correspondientes.
     * @param codigoComercio a modificar.
     * @param comercioDTO datos modificados del comercio.
     * @return
     */
    @PatchMapping("/{codigoComercio}")
    public ResponseEntity<String> updateComercio(@PathVariable Integer codigoComercio, @RequestBody ComercioDTO comercioDTO) {
        if (comercioService.modificarComercio(codigoComercio, comercioDTO))
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    /**
     * Borra la entidad comercio, con las validaciones correspondientes.
     * @param codigoComercio a borrar.
     */
    @DeleteMapping("/{codigoComercio}")
    public void deleteComercio(@PathVariable Integer codigoComercio) {
        comercioService.eliminarComercio(codigoComercio);
    }
}