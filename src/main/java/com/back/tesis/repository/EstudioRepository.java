package com.back.tesis.repository;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EstudioRepository extends JpaRepository<Estudio, Long> {
    List<Estudio> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Estudio> findByNombreInglesAndEstadoTrue(String nombre);
    List<Estudio> findByEstadoTrue();
    Optional<Estudio> findByIdEstudioAndEstadoTrue(Long idEstudio);
    List<Estudio> findByInvestigador(Usuario usuario);

    @Query(nativeQuery = true,
            value = "SELECT * FROM estudio e " +
                    "INNER JOIN usuarioestudio ue ON e.idEstudio = ue.idEstudio " +
                    "WHERE ue.idUsuario = ?1")
    List<Estudio> findByParticipante(Long idUsuario);
}
