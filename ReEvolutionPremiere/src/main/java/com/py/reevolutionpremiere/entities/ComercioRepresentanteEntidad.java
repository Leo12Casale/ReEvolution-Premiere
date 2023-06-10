package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_comercio_representante")
public class ComercioRepresentanteEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;
    @OneToMany(mappedBy = "comercioRepresentanteByIdRepresentante")
    private Collection<ComercioEntidad> comerciosById;
}
