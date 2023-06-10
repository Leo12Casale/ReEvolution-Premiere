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
@Table(name = "a_adicional")
public class ClienteAsociadoAdicionalEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dni", nullable = false)
    private Integer dni;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "id_domicilio", nullable = true, insertable = false, updatable = false)
    private Integer idDomicilio;
    @Basic
    @Column(name = "codigo_cliente_asociado_titular", nullable = false, insertable=false, updatable=false)
    private Integer codigoClienteAsociadoTitular;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente_asociado_titular", referencedColumnName = "codigo_usuario", nullable = false)
    private ClienteAsociadoEntidad clienteAsociadoByCodigoClienteAsociadoTitular;
    @OneToMany(mappedBy = "adicionalByDniAdicional")
    private Collection<CuponEntidad> cuponsByDni;
    @OneToOne
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private DomicilioEntidad domicilioEntidad;
}
