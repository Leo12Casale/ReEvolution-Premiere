package com.reevolutionpremiere.ReEvolutionPremiere.repository;

import javax.persistence.*;

@Entity
@Table(name="a_comercio")
public class Comercio {
    @Id
    @Column(name = "codigo_comercio")
    private int codigoComercio;
    @Basic
    @Column(name = "razon_sociañ")
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
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    public Comercio() {
    }

    public int getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(int codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(String condicionIVA) {
        this.condicionIVA = condicionIVA;
    }

    public Float getImporteConsumos() {
        return importeConsumos;
    }

    public void setImporteConsumos(Float importeConsumos) {
        this.importeConsumos = importeConsumos;
    }

    public Float getImporteComisiones() {
        return importeComisiones;
    }

    public void setImporteComisiones(Float importeComisiones) {
        this.importeComisiones = importeComisiones;
    }

    public int getDiaCobro() {
        return diaCobro;
    }

    public void setDiaCobro(int diaCobro) {
        this.diaCobro = diaCobro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
