package com.py.reevolutionpremiere.controllers.transferobjects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DomicilioDTO(

        @NotNull(message = "Provincia nula.")
        @NotBlank(message = "Provincia vacía.")
        String provincia,

        @NotNull(message = "Localidad nula.")
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
