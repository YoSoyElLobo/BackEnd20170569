package com.back.tesis.repository;

import com.back.tesis.model.Pais;
import com.back.tesis.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    List<Pais> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Pais> findByEstadoTrue();
    Optional<Pais> findByIdPaisAndEstadoTrue(Long idPais);
}
