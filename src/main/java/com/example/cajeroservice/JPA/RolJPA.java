package com.example.cajeroservice.JPA;

import jakarta.persistence.*;

@Entity
@Table(name = "ROL")
public class RolJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idRol;
    
    @Column(name = "nombrerol")
    private String nombreRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}