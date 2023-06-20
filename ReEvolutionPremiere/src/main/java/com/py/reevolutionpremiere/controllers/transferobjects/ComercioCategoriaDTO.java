package com.py.reevolutionpremiere.controllers.transferobjects;

import jakarta.validation.constraints.NotBlank;

public record ComercioCategoriaDTO(
        @NotBlank(message = "Nombre de categoría vacío.")
        String nombre
) {
}
