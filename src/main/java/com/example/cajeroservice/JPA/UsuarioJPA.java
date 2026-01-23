package com.example.cajeroservice.JPA;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "Usuario.retiro",
        procedureName = "RetiroUsuario",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdUsuario", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdCajero", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pMonto", type = Integer.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "Usuario.login",
        procedureName = "LoginUsuario",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pUsername", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pPassword", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pIdUsuario", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pIdRol", type = Integer.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "Usuario.consultarSaldo",
        procedureName = "ConsultarSaldo",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdUsuario", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pSaldo", type = Integer.class)
        }
    )
})
public class UsuarioJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;  
    
    @Column(name = "nombre")
    private String nombre;  
    
    @Column(name = "apellidopaterno")
    private String apellidoPaterno;  
    
    @Column(name = "apellidomaterno")
    private String apellidoMaterno;  
    
    @Column(name = "cuenta")
    private int cuenta;  
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private RolJPA rol;  
    
    @Column(name = "username")
    private String username; 
    
    @Column(name = "password")
    private String password;  
    
    @Column(name = "saldo")
    private int saldo;  


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public RolJPA getRol() {
        return rol;
    }

    public void setRol(RolJPA rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}