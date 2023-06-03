package com.py.reevolutionpremiere.controllers.transferobjects;


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
        String categoria,
        String nombreDueño,
        String apellidoDueño,
        String telefonoDueño,
        String emailDueño
        //private ComercioRepresentanteEntidad representante;
) {

}