package com.example.cajeroservice.JPA;

import jakarta.persistence.*;

@Entity
@Table(name = "detallecajero")
public class DetalleCajeroJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallecajero")
    private int idDetalleCajero;

    @ManyToOne
    @JoinColumn(name = "idcajero")
    private CajeroJPA cajero;

    @ManyToOne
    @JoinColumn(name = "iddenominacion")
    private DenominacionJPA denominacion;

    @Column(name = "cantidad")
    private int cantidad;

    public int getIdDetalleCajero() {
        return idDetalleCajero;
    }

    public void setIdDetalleCajero(int idDetalleCajero) {
        this.idDetalleCajero = idDetalleCajero;
    }

    public CajeroJPA getCajero() {
        return cajero;
    }

    public void setCajero(CajeroJPA cajero) {
        this.cajero = cajero;
    }

    public DenominacionJPA getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(DenominacionJPA denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
