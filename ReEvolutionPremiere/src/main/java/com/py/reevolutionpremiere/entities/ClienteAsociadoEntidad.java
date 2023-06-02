package com.py.reevolutionpremiere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "a_cliente_asociado")
public class ClienteAsociadoEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo_usuario", nullable = false)
    private Integer codigoUsuario;
    @Basic
    @Column(name = "dni", nullable = false)
    private Integer dni;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "direccion", nullable = false, length = 45)
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
    @Column(name = "observaciones", nullable = false, length = 45)
    private String observaciones;
    @Basic
    @Column(name = "dni_garante", nullable = true, insertable=false, updatable=false)
    private Integer dniGarante;
    @Basic
    @Column(name = "borrado", nullable = false)
    private Boolean borrado;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoClienteAsociadoTitular")
    private Collection<ClienteAsociadoAdicionalEntidad> adicionalsByCodigoUsuario;
    @ManyToOne
    @JoinColumn(name = "dni_garante", referencedColumnName = "dni")
    private ClienteAsociadoGaranteEntidad garanteByDniGarante;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoUsuario")
    private Collection<LimitesClienteAsociadoEntidad> limitesClienteAsociadosByCodigoUsuario;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoUsuario")
    private Collection<ClienteAsociadoCierreMensualEntidad> cierreMensualClienteAsociadosByCodigoUsuario;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoClienteAsociado")
    private Collection<CuponEntidad> cuponsByCodigoUsuario;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoClienteAsociado")
    private Collection<FacturaClienteAsociadoEntidad> facturaClienteAsociadosByCodigoUsuario;
    @OneToMany(mappedBy = "clienteAsociadoByCodigoUsuario")
    private Collection<MovimientoEntidad> movimientosByCodigoUsuario;
}
