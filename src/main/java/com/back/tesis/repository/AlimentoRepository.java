package com.back.tesis.repository;

import com.back.tesis.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Alimento> findByNombreInglesAndEstadoTrue(String nombre);
    List<Alimento> findByEstadoTrue();
    Optional<Alimento> findByIdAlimentoAndEstadoTrue(Long idAlimento);
}
