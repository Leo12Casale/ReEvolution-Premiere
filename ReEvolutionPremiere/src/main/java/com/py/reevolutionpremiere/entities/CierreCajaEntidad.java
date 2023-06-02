package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_cierrecaja")
public class CierreCajaEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fecha_cierre", nullable = false)
    private Date fechaCierre;
    @Basic
    @Column(name = "importe_efectivo", nullable = false)
    private Double importeEfectivo;
    @Basic
    @Column(name = "importe_tarjeta", nullable = false)
    private Double importeTarjeta;
}