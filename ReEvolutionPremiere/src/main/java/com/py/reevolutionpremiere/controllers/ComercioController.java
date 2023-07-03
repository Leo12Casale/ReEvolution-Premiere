package com.py.reevolutionpremiere.controllers;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
//import com.py.reevolutionpremiere.exception.ApiExceptionHandler;
import com.py.reevolutionpremiere.exception.ApiRequestException;
import com.py.reevolutionpremiere.exception.ResourceNotFoundException;
import com.py.reevolutionpremiere.services.ComercioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controlador de peticiones HTTP relacionados a los Comercios
 */
@RestController
@Validated
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
    public ResponseEntity<ComercioDTO> newComercio(@Valid @RequestBody ComercioDTO comercioDTO) {
        ComercioDTO obj = comercioService.newComercio(comercioDTO);
        return new ResponseEntity<>(obj,HttpStatus.OK);

    }
    /**
     * Modifica los datos de un comercio, haciendo las validaciones correspondientes.
     * @param codigoComercio a modificar.
     * @param comercioDTO datos modificados del comercio.
     * @return
     */
    @PatchMapping("/{codigoComercio}")
    public ResponseEntity<String> updateComercio(@PathVariable Integer codigoComercio,@Valid @RequestBody ComercioDTO comercioDTO) {
        if (comercioService.modificarComercio(codigoComercio, comercioDTO))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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