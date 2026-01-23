package com.example.cajeroservice.JPA;

import jakarta.persistence.*;

@Entity
@Table(name = "CAJERO")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "Cajero.rellenar",
            procedureName = "RellenarCajero",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdUsuario", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdCajero", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdDenominacion", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pCantidad", type = Integer.class)
            }
    ),
    @NamedStoredProcedureQuery(
            name = "Cajero.consultarSaldo",
            procedureName = "ConsultarSaldoCajero",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdUsuario", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdCajero", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pSaldo", type = Integer.class)
            }
    )
})
public class CajeroJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcajero")
    private int idCajero;

    @Column(name = "nombrecajero")
    private String nombreCajero;

    @Column(name = "saldo")
    private int saldo;

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
