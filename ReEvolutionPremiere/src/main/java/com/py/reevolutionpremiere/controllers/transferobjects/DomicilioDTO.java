package com.py.reevolutionpremiere.controllers.transferobjects;

public record DomicilioDTO(
        String provincia,
        String localidad,
        String calle,
        String numeroCalle,
        String codigoPostal,
        String pisoDepto,
        String numeroDepto,
        String observaciones
) {
}
