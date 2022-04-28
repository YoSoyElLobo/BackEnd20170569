package com.back.tesis.repository;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEnfermedad;
import com.back.tesis.model.UsuarioEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioEnfermedadRepository extends JpaRepository<UsuarioEnfermedad, Long> {
    List<UsuarioEnfermedad> findByUsuarioAndEnfermedad(Usuario usuario, Enfermedad enfermedad);
}
