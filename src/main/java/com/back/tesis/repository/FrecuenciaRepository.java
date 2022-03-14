package com.back.tesis.repository;

import com.back.tesis.model.Frecuencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrecuenciaRepository extends JpaRepository<Frecuencia, Long> {
}
