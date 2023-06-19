package com.py.reevolutionpremiere.entities;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_comercio")
public class ComercioEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "ingresos_brutos", nullable = false, length = 45)
    private String ingresosBrutos;
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
    @Type(JsonType.class)
    @Column(name = "comisiones_por_cuota", columnDefinition = "json")
    private Map<Integer, Double> comisionesPorCuota = new HashMap<>();
    @Basic
    @Column(name = "id_categoria", nullable = false, insertable = false, updatable = false)
    private Integer idCategoria;
    @Basic
    @Column(name = "id_representante", nullable = true, insertable = false, updatable = false)
    private Integer idRepresentante;
    @Basic
    @Column(name = "id_domicilio", nullable = true, insertable = false, updatable = false)
    private Integer idDomicilio;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false,updatable = false)
    private ComercioCategoriaEntidad categoriaComercioByIdCategoria;
    @ManyToOne
    @JoinColumn(name = "id_representante", referencedColumnName = "ID", updatable = false)
    private ComercioRepresentanteEntidad comercioRepresentanteByIdRepresentante;
    @OneToMany(mappedBy = "comercioByCodigoComercio")
    private Collection<CuponEntidad> cuponsByCodigoComercio;
    @OneToMany(mappedBy = "comercioByIdComercio")
    private Collection<FacturaComercioEntidad> facturaComerciosByCodigoComercio;
    @OneToOne
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private DomicilioEntidad domicilioEntidad;
}