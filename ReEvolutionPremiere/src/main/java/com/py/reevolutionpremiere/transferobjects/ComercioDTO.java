package com.py.reevolutionpremiere.transferobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComercioDTO {

    private Integer codigoComercio;
    private String razonSocial;
    private String nombreFantasia;
    private String cuit;
    private String condicionIVA;
    private Double importeConsumos;
    private Double importeComisiones;
    private int diaCobro;
    private String telefono;
    private String email;
    private String direccion;
    private String localidad;
    private String provincia;
    private String observaciones;
    private String comisiones;
    private String categoria;
    private String nombreDueño;
    private String apellidoDueño;
    private String telefonoDueño;
    private String emailDueño;
    //private ComercioRepresentanteEntidad representante;
}
