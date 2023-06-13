package com.py.reevolutionpremiere.controllers.transferobjects;


import java.util.Map;

public record ComercioDTO(
        Integer codigoComercio,
        String razonSocial,
        String nombreFantasia,
        String cuit,
        String ingresosBrutos,
        String condicionIva,
        Integer diaCobro,
        DomicilioDTO domicilio,
        Map<Integer, Double> comisiones,
        String categoria,
        ComercioRepresentanteDTO representante
) {
    public record ComercioRepresentanteDTO(
            String nombre,
            String apellido,
            String email,
            String telefono
    ) {
    }
}