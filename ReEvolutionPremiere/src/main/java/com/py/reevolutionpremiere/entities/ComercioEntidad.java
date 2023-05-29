package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_comercio")
public class ComercioEntidad {
    @Id
    @Column(name = "codigo_comercio")
    private int codigoComercio;
    @Basic
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic
    @Column(name = "nombre_fantasia")
    private String nombreFantasia;
    @Basic
    @Column(name = "cuit")
    private String CUIT;
    @Basic
    @Column(name = "condicion_iva")
    private String condicionIVA;
    @Basic
    @Column(name = "importe_consumos")
    private Float importeConsumos;
    @Basic
    @Column(name = "importe_comisiones")
    private Float importeComisiones;
    @Basic
    @Column(name = "dia_cobro")
    private int diaCobro;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "nombre_duenio")
    private String nombreDuenio;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "localidad")
    private String localidad;
    @Basic
    @Column(name = "provincia")
    private String provincia;
    @Basic
    @Column(name = "codigo_postal")
    private int codigoPostal;
    @Basic
    @Column(name = "observaciones")
    private String observaciones;

    //private JSONObject comisionesPorCuota;
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="id_categoria", referencedColumnName = "id_categoria")
//    private Categoria categoria;
}