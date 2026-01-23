package com.example.cajeroservice.Service;

import com.example.cajeroservice.JPA.Result;
import com.example.cajeroservice.JPA.UsuarioJPA;
import com.example.cajeroservice.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Result login(String username, String password) {
        Result result = new Result();
        try {
            Optional<UsuarioJPA> usuario = usuarioRepository.findByUsernameAndPassword(username, password);

            if (usuario.isPresent()) {
                result.correct = true;
                result.object = usuario.get();
                result.errorMessage = "Login exitoso";
            } else {
                result.correct = false;
                result.errorMessage = "Usuario o contraseña incorrectos";
                result.status = 401;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = "Error: " + ex.getMessage();
            result.ex = ex;
            result.status = 500;
        }

        return result;
    }

    @Transactional
    public Result retiroUsuario(int idUsuario, int idCajero, int monto) {
        Result result = new Result();
        try {
            usuarioRepository.retiroUsuario(idUsuario, idCajero, monto);

            result.correct = true;
            result.errorMessage = "Retiro realizado exitosamente";

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getMessage();
            result.ex = ex;
            result.status = 500;
        }

        return result;
    }

    public Result consultarSaldo(int idUsuario) {
        Result result = new Result();
        try {
            Integer saldo = usuarioRepository.consultarSaldo(idUsuario);

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

    public Optional<UsuarioJPA> findById(int id) {
        return usuarioRepository.findById(id);
    }
}
