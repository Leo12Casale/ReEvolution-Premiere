package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_cuota")
public class CuotaEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cuota", nullable = false)
    private Integer idCuota;
    @Basic
    @Column(name = "numero_cuota", nullable = false)
    private Integer numeroCuota;
    @Basic
    @Column(name = "importe", nullable = false, precision = 0)
    private Double importe;
    @Basic
    @Column(name = "es_de_comercio", nullable = false)
    private Boolean esDeComercio;
    @Basic
    @Column(name = "numero_factura_cliente_asociado", nullable = true, insertable=false, updatable=false)
    private Integer numeroFacturaClienteAsociado;
    @Basic
    @Column(name = "numero_factura_comercio", nullable = true, insertable=false, updatable=false)
    private Integer numeroFacturaComercio;
    @Basic
    @Column(name = "id_cupon", nullable = false, insertable=false, updatable=false)
    private Integer idCupon;
    @Basic
    @Column(name = "borrada", nullable = false)
    private Boolean borrada;
    @ManyToOne
    @JoinColumn(name = "numero_factura_cliente_asociado", referencedColumnName = "numero_factura")
    private FacturaClienteAsociadoEntidad facturaClienteAsociadoByNumeroFacturaClienteAsociado;
    @ManyToOne
    @JoinColumn(name = "numero_factura_comercio", referencedColumnName = "numero_factura")
    private FacturaComercioEntidad facturaComercioByNumeroFacturaComercio;
    @ManyToOne
    @JoinColumn(name = "id_cupon", referencedColumnName = "numero", nullable = false)
    private CuponEntidad cuponByIdCupon;

}
