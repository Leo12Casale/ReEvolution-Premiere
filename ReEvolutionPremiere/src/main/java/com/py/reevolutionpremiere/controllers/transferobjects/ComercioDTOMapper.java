package com.py.reevolutionpremiere.controllers.transferobjects;

import com.py.reevolutionpremiere.entities.ComercioEntidad;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ComercioDTOMapper implements Function<ComercioEntidad, ComercioDTO> {

    @Override
    public ComercioDTO apply(ComercioEntidad comercioEntidad) {
        return new ComercioDTO(
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
        );
    }
}
