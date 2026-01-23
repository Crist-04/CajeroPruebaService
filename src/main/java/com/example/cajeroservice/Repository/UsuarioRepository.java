package com.example.cajeroservice.Repository;

import com.example.cajeroservice.JPA.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Integer> {

    Optional<UsuarioJPA> findByUsernameAndPassword(String username, String password);

    @Procedure(name = "Usuario.retiro")
    void retiroUsuario(
            @Param("pIdUsuario") Integer idUsuario,
            @Param("pIdCajero") Integer idCajero,
            @Param("pMonto") Integer monto
    );

    @Procedure(name = "Usuario.consultarSaldo")
    Integer consultarSaldo(@Param("pIdUsuario") Integer idUsuario);
}
