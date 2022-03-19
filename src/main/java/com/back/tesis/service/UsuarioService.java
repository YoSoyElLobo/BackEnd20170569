package com.back.tesis.service;

import com.back.tesis.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
    List<Usuario> saveAll(List<Usuario> usuarios);
    Usuario findByCorreoElectronico(String nombre);
    Usuario findById(Long idUsuario);
}
