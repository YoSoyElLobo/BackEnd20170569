package com.back.tesis.service;

import com.back.tesis.model.Farmaco;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioFarmaco;

import java.util.List;

public interface UsuarioFarmacoService {
    UsuarioFarmaco create(UsuarioFarmaco usuarioFarmaco);
    UsuarioFarmaco save(UsuarioFarmaco usuarioFarmaco);
    void delete(Long idUsuarioFarmaco);
    UsuarioFarmaco findById(Long idUsuarioFarmaco);
    List<UsuarioFarmaco> findByUsuarioAndFarmaco(Usuario usuario, Farmaco farmaco);
    List<UsuarioFarmaco> findByUsuarioAndFarmaco(UsuarioFarmaco usuarioFarmaco);
}
