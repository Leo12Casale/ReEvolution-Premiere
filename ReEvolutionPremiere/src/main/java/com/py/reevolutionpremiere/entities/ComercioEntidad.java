package com.py.reevolutionpremiere.entities;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_comercio")
public class ComercioEntidad {

    @Id
    @Column(name = "codigo_comercio", nullable = false)
    private Integer codigoComercio;
    @Basic
    @Column(name = "razon_social", nullable = false, length = 60)
    private String razonSocial;
    @Basic
    @Column(name = "nombre_fantasia", nullable = false, length = 60)
    private String nombreFantasia;
    @Basic
    @Column(name = "cuit", nullable = false, length = 13)
    private String cuit;
    @Basic
    @Column(name = "condicion_iva", nullable = false, length = 30)
    private String condicionIva;
    @Basic
    @Column(name = "importe_consumos", nullable = false, precision = 0)
    private Double importeConsumos;
    @Basic
    @Column(name = "importe_comisiones", nullable = false, precision = 0)
    private Double importeComisiones;
    @Basic
    @Column(name = "dia_cobro", nullable = false)
    private Integer diaCobro;
    @Basic
    @Column(name = "telefono", nullable = false, length = 25)
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
    @Column(name = "observaciones", nullable = false, length = 100)
    private String observaciones;
    @Basic
    @Column(name = "borrado", nullable = false)
    private Boolean borrado;

    @Type(JsonType.class)
    @Column(name = "comisiones_por_cuota", columnDefinition = "json")
    private Map<Integer, Double> comisionesPorCuota = new HashMap<>();
    @Basic
    @Column(name = "id_categoria", nullable = false, insertable = false, updatable = false)
    private Integer idCategoria;
    @Basic
    @Column(name = "id_dueño", nullable = false, insertable = false, updatable = false)
    private Integer idDueño;
    @Basic
    @Column(name = "id_representante", nullable = true, insertable = false, updatable = false)
    private Integer idRepresentante;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false,updatable = false)
    private ComercioCategoriaEntidad categoriaComercioByIdCategoria;
    @ManyToOne
    @JoinColumn(name = "id_dueño", referencedColumnName = "ID", nullable = false, updatable = false)
    private ComercioDueñoEntidad comercioDueñoByIdDueño;
    @ManyToOne
    @JoinColumn(name = "id_representante", referencedColumnName = "ID", updatable = false)
    private ComercioRepresentanteEntidad comercioRepresentanteByIdRepresentante;
    @OneToMany(mappedBy = "comercioByCodigoComercio")
    private Collection<CuponEntidad> cuponsByCodigoComercio;
    @OneToMany(mappedBy = "comercioByIdComercio")
    private Collection<FacturaComercioEntidad> facturaComerciosByCodigoComercio;
}