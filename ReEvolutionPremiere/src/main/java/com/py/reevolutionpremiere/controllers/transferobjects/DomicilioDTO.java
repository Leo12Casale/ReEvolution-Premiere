package com.py.reevolutionpremiere.controllers.transferobjects;

import jakarta.validation.constraints.NotBlank;

public record DomicilioDTO(
        @NotBlank
        String provincia,
        @NotBlank
        String localidad,
        @NotBlank
        String calle,
        String numeroCalle,
        @NotBlank
        String codigoPostal,
        String pisoDepto,
        String numeroDepto,
        String observaciones
) {
}
