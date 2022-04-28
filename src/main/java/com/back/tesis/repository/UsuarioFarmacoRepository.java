package com.back.tesis.repository;

import com.back.tesis.model.Farmaco;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioFarmaco;
import com.back.tesis.model.UsuarioFarmaco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioFarmacoRepository extends JpaRepository<UsuarioFarmaco, Long> {
    List<UsuarioFarmaco> findByUsuarioAndFarmaco(Usuario usuario, Farmaco alimento);
}
