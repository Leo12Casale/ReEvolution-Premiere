package com.py.reevolutionpremiere.controllers.transferobjects;


import jakarta.validation.constraints.*;

import java.util.Map;

public record ComercioDTO(
        Integer codigoComercio,

        @NotNull(message = "Razón social nula.")
        @NotBlank(message = "Razón social vacía.")
        String razonSocial,

        @NotNull(message = "Nombre de fantasía nulo.")
        @NotBlank(message = "Nombre de fantasía vacío.")
        String nombreFantasia,

        @NotBlank(message = "CUIT vacío.")
        @NotNull(message = "CUIT nulo.")
        String cuit,

        String ingresosBrutos,

        @NotBlank(message = "Condición de IVA vacía.")
        @NotNull(message = "Condición de IVA nula.")
        String condicionIva,

        @NotNull(message = "Día de cobro nulo.")
        @Min(value = 1, message = "Día de cobro menor a 1.")
        @Max(value = 31, message = "Día de cobro mayor a 31.")
        Integer diaCobro,

        @NotNull(message = "Domicilio nulo.")
        DomicilioDTO domicilio,
        @NotEmpty(message = "Lista de comisiones vacía.")
        Map<Integer, Double> comisiones,

        @NotNull(message = "Categoría nula.")
        @NotBlank(message = "Categoría vacía.")
        String categoria,
        ComercioRepresentanteDTO representante
) {
    public record ComercioRepresentanteDTO(
            @NotNull(message = "Nombre de representante nulo.")
            @NotBlank(message = "Nombre de representante vacío.")
            String nombre,
            @NotNull(message = "Apellido de representante nulo.")
            @NotBlank(message = "Apellido de representante vacío.")
            String apellido,
            @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "E-mail inválido.")
            String email,
            @NotNull(message = "Teléfono de representante nulo.")
            @NotBlank(message = "Teléfono de representante vacío.")
            String telefono
    ) {
    }
}