package com.back.tesis.repository;

import com.back.tesis.model.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeporteRepository extends JpaRepository<Deporte, Long> {
    List<Deporte> findByNombreAndEstadoTrue(String nombre);
    List<Deporte> findByEstadoTrue();
    Optional<Deporte> findByIdDeporteAndEstadoTrue(Long idDeporte);
}
