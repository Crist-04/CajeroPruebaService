package com.example.cajeroservice.RestController;

import com.example.cajeroservice.JPA.Result;
import com.example.cajeroservice.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
public ResponseEntity<Result> login(@RequestParam String username, @RequestParam String password) {
    System.out.println("=== API LOGIN RECIBIDO ===");
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);
    
    username = username.trim();
    password = password.trim();
    
    Result result = usuarioService.login(username, password);
    
    System.out.println("Login result: " + result.correct);
    
    if (result.correct) {
        return ResponseEntity.ok(result);
    } else {
        return ResponseEntity.status(result.status).body(result);
    }
}

    @PostMapping("/retiro")
    public ResponseEntity<Result> retiroUsuario(
            @RequestParam int idUsuario,
            @RequestParam int idCajero,
            @RequestParam int monto) {

        Result result = usuarioService.retiroUsuario(idUsuario, idCajero, monto);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/saldo/{idUsuario}")
    public ResponseEntity<Result> consultarSaldo(@PathVariable int idUsuario) {
        Result result = usuarioService.consultarSaldo(idUsuario);

        if (result.correct) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
