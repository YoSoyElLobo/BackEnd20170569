package com.back.tesis.service;

import com.back.tesis.model.Alimento;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioAlimento;

import java.util.List;

public interface UsuarioAlimentoService {
    /*List<UsuarioAlimento> findAll();

    UsuarioAlimento update(UsuarioAlimento usuarioAlimento);

    ;
    List<UsuarioAlimento> saveAll(List<UsuarioAlimento> usuarioAlimentos);
    UsuarioAlimento findByNombre(String nombre);
    */
    UsuarioAlimento create(UsuarioAlimento usuarioAlimento);
    UsuarioAlimento save(UsuarioAlimento usuarioAlimento);
    void delete(Long idUsuarioAlimento);
    UsuarioAlimento findById(Long idUsuarioAlimento);
    List<UsuarioAlimento> findByUsuario(Usuario usuario);
    List<UsuarioAlimento> findByUsuarioAndAlimento(Usuario usuario, Alimento alimento);
    List<UsuarioAlimento> findByUsuarioAndAlimento(UsuarioAlimento usuarioAlimento);
}
