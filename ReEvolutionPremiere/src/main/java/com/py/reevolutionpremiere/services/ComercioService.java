package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.entities.ComercioCategoriaEntidad;
import com.py.reevolutionpremiere.entities.ComercioDueñoEntidad;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
import com.py.reevolutionpremiere.entities.ComercioRepository;
import com.py.reevolutionpremiere.transferobjects.ComercioDTO;
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

    public List<ComercioDTO> getComercios(){
        return null;// comercioRepository.findAll();
    }

    public void setComercios(ComercioDTO comercio) {
        
        //comercioRepository.save(comercio);
    }

    public ComercioDTO encontarComercio(Integer codigoComercio){
        ComercioEntidad comercioEntidad = comercioRepository.findById(codigoComercio).orElseThrow();
        ComercioDTO comercioDTO = new ComercioDTO(
                comercioEntidad.getCodigoComercio(),
                comercioEntidad.getRazonSocial(),
                comercioEntidad.getNombreFantasia(),
                comercioEntidad.getCuit(),
                comercioEntidad.getCondicionIva(),
                comercioEntidad.getImporteConsumos(),
                comercioEntidad.getImporteComisiones(),
                comercioEntidad.getDiaCobro(),
                comercioEntidad.getTelefono(),
                comercioEntidad.getEmail(),
                comercioEntidad.getDireccion(),
                comercioEntidad.getLocalidad(),
                comercioEntidad.getProvincia(),
                comercioEntidad.getObservaciones(),
                comercioEntidad.getComisionesPorCuota().toString(),
                comercioEntidad.getCategoriaComercioByIdCategoria().getNombreCategoria(),
                comercioEntidad.getComercioDueñoByIdDueño().getNombre(),
                comercioEntidad.getComercioDueñoByIdDueño().getApellido(),
                comercioEntidad.getComercioDueñoByIdDueño().getTelefono(),
                comercioEntidad.getComercioDueñoByIdDueño().getEmail()
                //comercioEntidad.getComercioRepresentanteByIdRepresentante()
        );
        return comercioDTO;
    }
}
