package com.back.tesis.repository;

import com.back.tesis.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {
    List<Enfermedad> findByNombre(String nombre);
    List<Enfermedad> findByEstadoTrue();
}
