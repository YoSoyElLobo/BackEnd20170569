package com.back.tesis.repository;

import com.back.tesis.model.Farmaco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmacoRepository extends JpaRepository<Farmaco, Long> {
    List<Farmaco> findByNombreEspanolAndEstadoTrue(String nombre);
    List<Farmaco> findByEstadoTrue();
    Optional<Farmaco> findByIdFarmacoAndEstadoTrue(Long idFarmaco);
}
