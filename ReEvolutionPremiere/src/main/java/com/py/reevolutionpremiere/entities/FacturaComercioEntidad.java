package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_factura_comercio")
public class FacturaComercioEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_factura", nullable = false)
    private Integer numeroFactura;
    @Basic
    @Column(name = "tipo_factura", nullable = false, length = 1)
    private String tipoFactura;
    @Basic
    @Column(name = "codigo_tipo_factura", nullable = false, length = 3)
    private String codigoTipoFactura;
    @Basic
    @Column(name = "cae", nullable = false, length = 14)
    private String cae;
    @Basic
    @Column(name = "vencimiento_cae", nullable = false)
    private Date vencimientoCae;
    @Basic
    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;
    @Basic
    @Column(name = "fecha_vencimiento_factura", nullable = false)
    private Date fechaVencimientoFactura;
    @Basic
    @Column(name = "fecha_periodo_desde", nullable = false)
    private Date fechaPeriodoDesde;
    @Basic
    @Column(name = "fecha_periodo_hasta", nullable = false)
    private Date fechaPeriodoHasta;
    @Basic
    @Column(name = "total_cupones", nullable = false, precision = 0)
    private Double totalCupones;
    @Basic
    @Column(name = "total_comisiones", nullable = false, precision = 0)
    private Double totalComisiones;
    @Basic
    @Column(name = "iva", nullable = false, precision = 0)
    private Double iva;
    @Basic
    @Column(name = "importe_a_liquidar", nullable = false, precision = 0)
    private Double importeALiquidar;
    @Basic
    @Column(name = "pagada", nullable = true)
    private Boolean pagada;
    @Basic
    @Column(name = "id_comercio", nullable = false, insertable=false, updatable=false)
    private Integer idComercio;
    @OneToMany(mappedBy = "facturaComercioByNumeroFacturaComercio")
    private Collection<CuotaEntidad> cuotasByNumeroFactura;
    @ManyToOne
    @JoinColumn(name = "id_comercio", referencedColumnName = "codigo_comercio", nullable = false)
    private ComercioEntidad comercioByIdComercio;
    @OneToMany(mappedBy = "hFacturaComercioByNumeroFacturaComercio")
    private Collection<MovimientoEntidad> movimientosByNumeroFactura;
}
