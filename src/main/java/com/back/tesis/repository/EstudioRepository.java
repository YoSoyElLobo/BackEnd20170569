package com.back.tesis.repository;

import com.back.tesis.model.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstudioRepository extends JpaRepository<Estudio, Long> {
    List<Estudio> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Estudio> findByNombreInglesAndEstadoTrue(String nombre);
    List<Estudio> findByEstadoTrue();
    Optional<Estudio> findByIdEstudioAndEstadoTrue(Long idEstudio);
}
