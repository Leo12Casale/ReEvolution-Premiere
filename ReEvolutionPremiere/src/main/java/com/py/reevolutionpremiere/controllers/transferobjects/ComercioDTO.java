package com.py.reevolutionpremiere.controllers.transferobjects;


import com.py.reevolutionpremiere.entities.ComercioDueñoEntidad;

public record ComercioDTO(
        Integer codigoComercio,
        String razonSocial,
        String nombreFantasia,
        String cuit,
        String condicionIVA,
        Double importeConsumos,
        Double importeComisiones,
        Integer diaCobro,
        String telefono,
        String direccion,
        String localidad,
        String email,
        String provincia,
        String observaciones,
        String comisiones,
        ComercioCategoriaDTO categoria,
        ComercioDueñoDTO dueño,
        ComercioRepresentanteDTO representante
) {

}