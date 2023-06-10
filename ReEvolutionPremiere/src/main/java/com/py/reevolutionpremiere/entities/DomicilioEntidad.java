package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_domicilio")
public class DomicilioEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "provincia", nullable = false, length = 60)
    private String provincia;
    @Basic
    @Column(name = "localidad", nullable = false, length = 60)
    private String localidad;
    @Basic
    @Column(name = "calle", nullable = false, length = 60)
    private String calle;
    @Basic
    @Column(name = "numero_calle", nullable = false, length = 10)
    private String numeroCalle;
    @Basic
    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;
    @Basic
    @Column(name = "piso_departamento", nullable = false, length = 10)
    private String pisoDepto;
    @Basic
    @Column(name = "numero_departamento", nullable = false, length = 10)
    private String numeroDepto;
    @Basic
    @Column(name = "observaciones_direccion", nullable = false, length = 200)
    private String observaciones;
    @OneToOne(mappedBy = "domicilioEntidad")
    private ComercioEntidad comercioEntidad;
}
