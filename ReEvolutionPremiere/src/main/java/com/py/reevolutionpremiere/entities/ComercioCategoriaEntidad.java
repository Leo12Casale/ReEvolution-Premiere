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
@Table(name = "a_categoria_comercio")
public class ComercioCategoriaEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;
    @Basic
    @Column(name = "nombre_categoria", nullable = false, length = 45)
    private String nombreCategoria;
    @OneToMany(mappedBy = "categoriaComercioByIdCategoria")
    private Collection<ComercioEntidad> comerciosByIdCategoria;
}
