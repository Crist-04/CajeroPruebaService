package com.example.cajeroservice.RestController;

import com.example.cajeroservice.JPA.CajeroJPA;
import com.example.cajeroservice.JPA.Result;
import com.example.cajeroservice.Service.CajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cajero")
@CrossOrigin(origins = "*")
public class CajeroRestController {

    @Autowired
    private CajeroService cajeroService;

    @GetMapping("/all")
    public ResponseEntity<List<CajeroJPA>> getAll() {
        List<CajeroJPA> cajeros = cajeroService.getAll();
        return ResponseEntity.ok(cajeros);
    }

    @PostMapping("/rellenar")
    public ResponseEntity<Result> rellenar(
            @RequestParam int idUsuario,
            @RequestParam int idCajero,
            @RequestParam int idDenominacion,
            @RequestParam int cantidad) {

        Result result = cajeroService.rellenarCajero(idUsuario, idCajero, idDenominacion, cantidad);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/saldo")
    public ResponseEntity<Result> consultarSaldo(
            @RequestParam int idUsuario,
            @RequestParam int idCajero) {

        Result result = cajeroService.consultarSaldoCajero(idUsuario, idCajero);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
