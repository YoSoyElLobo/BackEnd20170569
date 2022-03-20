package com.back.tesis.repository;

import com.back.tesis.model.Alimento;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioAlimentoRepository extends JpaRepository<UsuarioAlimento, Long> {

    List<UsuarioAlimento> findByUsuario(Usuario usuario);
    List<UsuarioAlimento> findByUsuarioAndAlimento(Usuario usuario, Alimento alimento);
}
