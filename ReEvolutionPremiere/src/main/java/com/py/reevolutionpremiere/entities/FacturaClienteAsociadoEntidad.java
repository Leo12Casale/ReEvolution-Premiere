package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_factura_cliente_asociado")
public class FacturaClienteAsociadoEntidad {
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
    @Column(name = "saldo_anterior", nullable = false, precision = 0)
    private Double saldoAnterior;
    @Basic
    @Column(name = "saldo_mes_anterior", nullable = false, precision = 0)
    private Double saldoMesAnterior;
    @Basic
    @Column(name = "pagos_mes_anterior", nullable = false, precision = 0)
    private Double pagosMesAnterior;
    @Basic
    @Column(name = "compras_del_mes", nullable = false, precision = 0)
    private Double comprasDelMes;
    @Basic
    @Column(name = "recargos_por_mora", nullable = false, precision = 0)
    private Double recargosPorMora;
    @Basic
    @Column(name = "sellado", nullable = false, precision = 0)
    private Double sellado;
    @Basic
    @Column(name = "gastos_administrativos", nullable = false, precision = 0)
    private Double gastosAdministrativos;
    @Basic
    @Column(name = "contingencia_seguro", nullable = false, precision = 0)
    private Double contingenciaSeguro;
    @Basic
    @Column(name = "iva", nullable = false, precision = 0)
    private Double iva;
    @Basic
    @Column(name = "importe_total", nullable = false, precision = 0)
    private Double importeTotal;
    @Basic
    @Column(name = "codigo_cliente_asociado", nullable = false, insertable=false, updatable=false)
    private Integer codigoClienteAsociado;
    @OneToMany(mappedBy = "facturaClienteAsociadoByNumeroFacturaClienteAsociado")
    private Collection<CuotaEntidad> cuotasByNumeroFactura;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente_asociado", referencedColumnName = "codigo_usuario", nullable = false)
    private ClienteAsociadoEntidad clienteAsociadoByCodigoClienteAsociado;
}
