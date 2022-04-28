package com.back.tesis.repository;

import com.back.tesis.model.Deporte;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioDeporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioDeporteRepository extends JpaRepository<UsuarioDeporte, Long> {
    List<UsuarioDeporte> findByUsuarioAndDeporte(Usuario usuario, Deporte alimento);
}
