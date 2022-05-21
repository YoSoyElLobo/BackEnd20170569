package com.back.tesis.repository;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEstudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioEstudioRepository extends JpaRepository<UsuarioEstudio, Long> {
    Optional<UsuarioEstudio> findByUsuarioAndEstudio(Usuario Usuario, Estudio estudio);
}
