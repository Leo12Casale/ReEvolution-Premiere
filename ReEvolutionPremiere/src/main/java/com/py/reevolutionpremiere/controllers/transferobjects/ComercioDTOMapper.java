package com.py.reevolutionpremiere.controllers.transferobjects;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.py.reevolutionpremiere.entities.ComercioEntidad;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Clase que mapea de ComercioEntidad a ComercioDTO
 */
@Service
public class ComercioDTOMapper implements Function<ComercioEntidad, ComercioDTO> {

    /**
     * Método que convierte la entidad en un registro DTO.
     * @param comercioEntidad a convertir.
     * @return registro DTO con el formato del JSON a retornar.
     */

    @Override
    public ComercioDTO apply(ComercioEntidad comercioEntidad) {
        return new ComercioDTO(
                comercioEntidad.getCodigoComercio(),
                comercioEntidad.getRazonSocial(),
                comercioEntidad.getNombreFantasia(),
                comercioEntidad.getCuit(),
                comercioEntidad.getIngresosBrutos(),
                comercioEntidad.getCondicionIva(),
                comercioEntidad.getDiaCobro(),
                comercioEntidad.getDomicilioEntidad() == null ? null :
                        new DomicilioDTO(
                                comercioEntidad.getDomicilioEntidad().getProvincia(),
                                comercioEntidad.getDomicilioEntidad().getLocalidad(),
                                comercioEntidad.getDomicilioEntidad().getCalle(),
                                comercioEntidad.getDomicilioEntidad().getNumeroCalle(),
                                comercioEntidad.getDomicilioEntidad().getCodigoPostal(),
                                comercioEntidad.getDomicilioEntidad().getPisoDepto(),
                                comercioEntidad.getDomicilioEntidad().getNumeroDepto(),
                                comercioEntidad.getDomicilioEntidad().getObservaciones()
                        ),
                comercioEntidad.getComisionesPorCuota(),
                comercioEntidad.getCategoriaComercioByIdCategoria().getNombreCategoria(),
                comercioEntidad.getComercioRepresentanteByIdRepresentante() == null ? null :
                         new ComercioDTO.ComercioRepresentanteDTO(
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getNombre(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getApellido(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getEmail(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getTelefono()
                         )
        );
    }
}