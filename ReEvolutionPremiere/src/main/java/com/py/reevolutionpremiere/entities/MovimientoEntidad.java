package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_movimiento")
public class MovimientoEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_movimiento", nullable = false)
    private Integer idMovimiento;
    @Basic
    @Column(name = "concepto", nullable = true, length = 30)
    private String concepto;
    @Basic
    @Column(name = "modo_pago", nullable = false, length = 15)
    private String modoPago;
    @Basic
    @Column(name = "monto", nullable = false, precision = 0)
    private Double monto;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "observaciones", nullable = true, length = 75)
    private String observaciones;
    @Basic
    @Column(name = "anulado", nullable = false)
    private Boolean anulado;
    @Basic
    @Column(name = "codigo_usuario", nullable = true,insertable=false, updatable=false)
    private Integer codigoUsuario;
    @Basic
    @Column(name = "numero_factura_comercio", nullable = true,insertable=false, updatable=false)
    private Integer numeroFacturaComercio;
    @ManyToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    private ClienteAsociadoEntidad clienteAsociadoByCodigoUsuario;
    @ManyToOne
    @JoinColumn(name = "numero_factura_comercio", referencedColumnName = "numero_factura")
    private FacturaComercioEntidad hFacturaComercioByNumeroFacturaComercio;

}
