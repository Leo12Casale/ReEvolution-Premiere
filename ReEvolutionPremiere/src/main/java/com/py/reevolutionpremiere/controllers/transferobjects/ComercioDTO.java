package com.py.reevolutionpremiere.controllers.transferobjects;


import java.util.Map;

public record ComercioDTO(
        Integer codigoComercio,
        String razonSocial,
        String nombreFantasia,
        String cuit,
        String condicionIva,
        Double importeConsumos,
        Double importeComisiones,
        Integer diaCobro,
        String telefono,
        String direccion,
        String localidad,
        String email,
        String provincia,
        Integer codigoPostal,
        String observaciones,
        Map<Integer, Double> comisiones,
        String categoria,
        ComercioDueñoDTO dueño,
        ComercioRepresentanteDTO representante
) {

}