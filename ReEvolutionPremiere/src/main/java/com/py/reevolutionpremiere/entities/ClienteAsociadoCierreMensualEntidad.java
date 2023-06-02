package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "h_cierre_mensual_cliente_asociado")
public class ClienteAsociadoCierreMensualEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cierre", nullable = false)
    private Integer idCierre;
    @Basic
    @Column(name = "fecha_cierre", nullable = true)
    private Date fechaCierre;
    @Basic
    @Column(name = "mes_cierre", nullable = false)
    private Integer mesCierre;
    @Basic
    @Column(name = "consumo", nullable = false, precision = 0)
    private Double consumo;
    @Basic
    @Column(name = "recargos_mora", nullable = false, precision = 0)
    private Double recargosMora;
    @Basic
    @Column(name = "saldo_mes_anterior", nullable = false, precision = 0)
    private Double saldoMesAnterior;
    @Basic
    @Column(name = "pago_mes_anterior", nullable = false, precision = 0)
    private Double pagoMesAnterior;
    @Basic
    @Column(name = "codigo_usuario", nullable = false, insertable=false, updatable=false)
    private Integer codigoUsuario;
    @ManyToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario", nullable = false)
    private ClienteAsociadoEntidad clienteAsociadoByCodigoUsuario;
}
