package com.example.cajeroservice.Repository;

import com.example.cajeroservice.JPA.CajeroJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<CajeroJPA, Integer> {

    @Procedure(name = "Cajero.rellenar")
    void rellenarCajero(
            @Param("pIdUsuario") Integer idUsuario,
            @Param("pIdCajero") Integer idCajero,
            @Param("pIdDenominacion") Integer idDenominacion,
            @Param("pCantidad") Integer cantidad
    );

    @Procedure(name = "Cajero.consultarSaldo")
    Integer consultarSaldoCajero(
            @Param("pIdUsuario") Integer idUsuario,
            @Param("pIdCajero") Integer idCajero
    );
}
