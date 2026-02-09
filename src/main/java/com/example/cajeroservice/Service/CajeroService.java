package com.example.cajeroservice.Service;

import com.example.cajeroservice.JPA.CajeroJPA;
import com.example.cajeroservice.JPA.Result;
import com.example.cajeroservice.Repository.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CajeroService {

    @Autowired
    private CajeroRepository cajeroRepository;

    public List<CajeroJPA> getAll() {
        return cajeroRepository.findAll();
    }

    @Transactional
    public Result rellenarCajero(int idUsuario, int idCajero, int idDenominacion, int cantidad) {
        Result result = new Result();
        try {
            if (cantidad <= 0) {
                result.correct = false;
                result.errorMessage = "La cantidad debe ser mayor a 0";
                result.status = 400;
                return result;
            }

            if (cantidad % 5 != 0) {
                result.correct = false;
                result.errorMessage = "La cantidad debe ser un múltiplo de 5";
                result.status = 400;
                return result;
            }

            cajeroRepository.rellenarCajero(idUsuario, idCajero, idDenominacion, cantidad);

            result.correct = true;
            result.errorMessage = "Cajero rellenado exitosamente con " + cantidad + " unidades";

        } catch (Exception ex) {
            result.correct = false;

            String errorMessage = ex.getMessage();

            if (errorMessage.contains("ORA-20001")) {
                result.errorMessage = "Solo el Admin puede rellenar";
            } else if (errorMessage.contains("ORA-20002")) {
                result.errorMessage = "La cantidad debe ser mayor a 0";
            } else if (errorMessage.contains("ORA-20003")) {
                result.errorMessage = "La cantidad debe ser un múltiplo de 5";
            } else {
                result.errorMessage = "Error al rellenar el cajero: " + errorMessage;
            }

            result.ex = ex;
            result.status = 500;
        }

        return result;
    }

    public Result consultarSaldoCajero(int idUsuario, int idCajero) {
        Result result = new Result();
        try {
            Integer saldo = cajeroRepository.consultarSaldoCajero(idUsuario, idCajero);

            result.correct = true;
            result.data = saldo;
            result.errorMessage = "Saldo consultado exitosamente";

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getMessage();
            result.ex = ex;
            result.status = 500;
        }

        return result;
    }
}
