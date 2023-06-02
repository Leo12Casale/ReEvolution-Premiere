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
@Table(name = "h_cupon")
public class CuponEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Basic
    @Column(name = "codigo_cliente_asociado", nullable = false, insertable=false, updatable=false)
    private Integer codigoClienteAsociado;
    @Basic
    @Column(name = "dni_adicional", nullable = true, insertable=false, updatable=false)
    private Integer dniAdicional;
    @Basic
    @Column(name = "codigo_comercio", nullable = false, insertable=false, updatable=false)
    private Integer codigoComercio;
    @Basic
    @Column(name = "fecha_cupon", nullable = false)
    private Date fechaCupon;
    @Basic
    @Column(name = "fecha_carga", nullable = true)
    private Date fechaCarga;
    @Basic
    @Column(name = "importe_total", nullable = false, precision = 0)
    private Double importeTotal;
    @Basic
    @Column(name = "cant_cuotas", nullable = false)
    private Integer cantCuotas;
    @Basic
    @Column(name = "num_cuota_vigente", nullable = false)
    private Integer numCuotaVigente;
    @Basic
    @Column(name = "cancelado", nullable = false)
    private Boolean cancelado;
    @Basic
    @Column(name = "anulado", nullable = false)
    private Boolean anulado;
    @OneToMany(mappedBy = "cuponByIdCupon")
    private Collection<CuotaEntidad> cuotasByNumero;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente_asociado", referencedColumnName = "codigo_usuario", nullable = false)
    private ClienteAsociadoEntidad clienteAsociadoByCodigoClienteAsociado;
    @ManyToOne
    @JoinColumn(name = "dni_adicional", referencedColumnName = "dni")
    private ClienteAsociadoAdicionalEntidad adicionalByDniAdicional;
    @ManyToOne
    @JoinColumn(name = "codigo_comercio", referencedColumnName = "codigo_comercio", nullable = false)
    private ComercioEntidad comercioByCodigoComercio;

}
