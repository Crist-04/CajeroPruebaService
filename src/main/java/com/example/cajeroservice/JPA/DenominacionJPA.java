package com.example.cajeroservice.JPA;

import jakarta.persistence.*;

@Entity
@Table(name = "DENOMINACION")
public class DenominacionJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddenominacion")
    private int idDenominacion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private int valor;

    public int getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(int idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
