package com.back.tesis.service;

import com.back.tesis.model.Deporte;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioDeporte;
import com.back.tesis.model.UsuarioDeporte;

import java.util.List;

public interface UsuarioDeporteService {
    UsuarioDeporte create(UsuarioDeporte usuarioDeporte);
    UsuarioDeporte save(UsuarioDeporte usuarioDeporte);
    void delete(Long idUsuarioDeporte);
    UsuarioDeporte findById(Long idUsuarioDeporte);
    List<UsuarioDeporte> findByUsuarioAndDeporte(Usuario usuario, Deporte deporte);
    List<UsuarioDeporte> findByUsuarioAndDeporte(UsuarioDeporte usuarioDeporte);
}
