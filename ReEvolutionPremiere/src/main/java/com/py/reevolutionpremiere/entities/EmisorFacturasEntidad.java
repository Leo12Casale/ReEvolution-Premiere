package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_emisor_facturas")
public class EmisorFacturasEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cuit", nullable = false, length = 13)
    private String cuit;
    @Basic
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "telefono", nullable = false, length = 60)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "direccion", nullable = false, length = 60)
    private String direccion;
    @Basic
    @Column(name = "localidad", nullable = false, length = 45)
    private String localidad;
    @Basic
    @Column(name = "provincia", nullable = false, length = 45)
    private String provincia;
    @Basic
    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;
    @Basic
    @Column(name = "condicion_iva", nullable = false, length = 45)
    private String condicionIva;
    @Basic
    @Column(name = "inicio_actividades", nullable = false)
    private Date inicioActividades;
    @Basic
    @Column(name = "ingresos_brutos", nullable = false, length = 45)
    private String ingresosBrutos;
    @Basic
    @Column(name = "fecha_actualizacion_datos", nullable = false)
    private Date fechaActualizacionDatos;


}
