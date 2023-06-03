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
                new ComercioCategoriaDTO(
                        comercioEntidad.getCategoriaComercioByIdCategoria().getNombreCategoria()
                ),
                comercioEntidad.getComercioDueñoByIdDueño() == null ? null :
                    new ComercioDueñoDTO(
                            comercioEntidad.getComercioDueñoByIdDueño().getNombre(),
                            comercioEntidad.getComercioDueñoByIdDueño().getApellido(),
                            comercioEntidad.getComercioDueñoByIdDueño().getEmail(),
                            comercioEntidad.getComercioDueñoByIdDueño().getTelefono()
                ),
                comercioEntidad.getComercioRepresentanteByIdRepresentante() == null ? null :
                         new ComercioRepresentanteDTO(
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getNombre(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getApellido(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getEmail(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getTelefono(),
                                 comercioEntidad.getComercioRepresentanteByIdRepresentante().getPuesto()
                         )
        );
    }
}