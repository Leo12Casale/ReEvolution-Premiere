package com.py.reevolutionpremiere.controllers.transferobjects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record DomicilioDTO(

        @NotBlank(message = "Provincia vacía.")
        String provincia,

        @NotBlank(message = "Localidad vacía.")
        String localidad,

        @NotBlank(message = "Calle vacía.")
        String calle,

        String numeroCalle,

        @NotBlank(message = "Código postal vacío.")
        String codigoPostal,

        @Min(value = 0, message = "Piso menor a 0.")
        String pisoDepto,

        String numeroDepto,

        String observaciones
) {
}
