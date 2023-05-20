package com.reevolutionpremiere.ReEvolutionPremiere.repository;

import javax.persistence.*;

@Entity
@Table(name="a_categoria_comercio")
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_categoria")
    private int ID;
    @Basic
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public Categoria(int ID, String nombreCategoria) {
        this.ID = ID;
        this.nombreCategoria = nombreCategoria;
    }
}
