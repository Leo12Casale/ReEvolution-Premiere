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
@Table(name = "a_limites_cliente_asociado")
public class LimitesClienteAsociadoEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_limite", nullable = false)
    private Integer idLimite;
    @Basic
    @Column(name = "sueldo", nullable = false, precision = 0)
    private Double sueldo;
    @Basic
    @Column(name = "limite_credito", nullable = false, precision = 0)
    private Double limiteCredito;
    @Basic
    @Column(name = "limite_compra", nullable = false, precision = 0)
    private Double limiteCompra;
    @Basic
    @Column(name = "codigo_usuario", nullable = false,insertable=false, updatable=false)
    private Integer codigoUsuario;
    @Basic
    @Column(name = "fecha_actualizacion", nullable = false)
    private Date fechaActualizacion;
    @ManyToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario", nullable = false)
    private ClienteAsociadoEntidad clienteAsociadoByCodigoUsuario;
}
