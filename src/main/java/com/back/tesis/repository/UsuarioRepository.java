package com.back.tesis.repository;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoElectronicoAndEstadoTrue(String correoElectronico);
    List<Usuario> findByEstadoTrue();
    List<Usuario> findByEstadoTrueAndEnEsperaTrue();
    Optional<Usuario> findByIdUsuarioAndEstadoTrue(Long idUsuario);
    List<Usuario> findByRol_IdRolAndEstadoTrue(Long idRol);
    List<Usuario> findByRol_IdRolAndEstadoTrueAndAprobadoTrue(Long idRol);
    @Query(nativeQuery = true,
            value = "SELECT * FROM usuario u " +
                    "WHERE u.estado = 1 " +
                    "AND u.aprobado = 1 " +
                    "AND u.id_rol = 3 " +
                    "AND u.id_usuario NOT IN " +
                    "(SELECT ue.id_usuario " +
                    "FROM usuario_estudio ue " +
                    "WHERE ue.id_estudio = ?1);")
    List<Usuario> findPosiblesParticipantesByEstudio(Long idEstudio);
}
