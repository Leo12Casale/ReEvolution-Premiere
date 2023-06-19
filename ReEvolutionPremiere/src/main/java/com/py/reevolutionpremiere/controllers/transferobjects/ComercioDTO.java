package com.py.reevolutionpremiere.controllers.transferobjects;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record ComercioDTO(
        Integer codigoComercio,
        @NotBlank
        String razonSocial,
        @NotBlank
        String nombreFantasia,
        @NotBlank
        String cuit,
        String ingresosBrutos,
        @NotBlank
        String condicionIva,
        @NotNull
        Integer diaCobro,
        DomicilioDTO domicilio,
        @NotEmpty
        Map<Integer, Double> comisiones,
        @NotBlank
        String categoria,
        ComercioRepresentanteDTO representante
) {
    public record ComercioRepresentanteDTO(
            @NotBlank
            String nombre,
            @NotBlank
            String apellido,
            @NotBlank
            String email,
            @NotBlank
            String telefono
    ) {
    }
}