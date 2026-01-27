package com.example.cajeroservice.RestController;

import com.example.cajeroservice.JPA.LoginRequest;
import com.example.cajeroservice.JPA.LoginResponse;
import com.example.cajeroservice.JPA.UsuarioJPA;
import com.example.cajeroservice.Repository.UsuarioRepository;
import com.example.cajeroservice.Util.JwtUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        try {

            Optional<UsuarioJPA> usuarioOpt = usuarioRepository.findByUsernameAndPassword(loginRequest.getUsername().trim(), loginRequest.getPassword().trim());

            if (usuarioOpt.isPresent()) {
                UsuarioJPA usuario = usuarioOpt.get();

                String token = jwtUtil.generateToken(usuario.getUsername(), usuario.getIdUsuario());

                loginResponse.setCorrect(true);
                loginResponse.setToken(token);
                loginResponse.setMensaje("Login Exitoso");
                loginResponse.setIdUsuario(usuario.getIdUsuario());
                loginResponse.setUsername(usuario.getUsername());
                loginResponse.setNombre(usuario.getNombre());
                loginResponse.setApellidoPaterno(usuario.getApellidoPaterno());
                loginResponse.setApellidoMaterno(usuario.getApellidoMaterno());
                loginResponse.setCuenta(usuario.getCuenta());
                loginResponse.setSaldo(usuario.getSaldo());
                loginResponse.setIdRol(usuario.getRol() != null ? usuario.getRol().getIdRol() : null);

                return ResponseEntity.ok(loginResponse);

            } else {
                loginResponse.setCorrect(false);
                loginResponse.setMensaje("Usuario o Contraseña Incorrecta");

                return ResponseEntity.status(401).body(loginResponse);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            loginResponse.setCorrect(false);
            loginResponse.setMensaje("Error: " + ex.getLocalizedMessage());
            return ResponseEntity.status(500).body(loginResponse);
        }

    }

}
