package com.back.tesis.repository;

import com.back.tesis.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {
    List<Enfermedad> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Enfermedad> findByEstadoTrue();
    Optional<Enfermedad> findByIdEnfermedadAndEstadoTrue(Long idEnfermedad);
}
