package com.back.tesis.repository;

import com.back.tesis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoElectronicoAndEstadoTrue(String correoElectronico);
    List<Usuario> findByEstadoTrue();
    List<Usuario> findByEstadoTrueAndEnEsperaTrue();
    Optional<Usuario> findByIdUsuarioAndEstadoTrue(Long idUsuario);
    List<Usuario> findByRol_IdRolAndEstadoTrue(Long idRol);
    List<Usuario> findByRol_IdRolAndEstadoTrueAndAprobadoTrue(Long idRol);
}
