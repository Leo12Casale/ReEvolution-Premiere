package com.py.reevolutionpremiere;

import com.py.reevolutionpremiere.ComercioEntidad;
import com.py.reevolutionpremiere.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
