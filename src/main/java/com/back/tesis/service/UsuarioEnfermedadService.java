package com.back.tesis.service;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEnfermedad;
import com.back.tesis.model.UsuarioEnfermedad;

import java.util.List;

public interface UsuarioEnfermedadService {
    UsuarioEnfermedad create(UsuarioEnfermedad usuarioEnfermedad);
    UsuarioEnfermedad save(UsuarioEnfermedad usuarioEnfermedad);
    void delete(Long idUsuarioEnfermedad);
    UsuarioEnfermedad findById(Long idUsuarioEnfermedad);
    List<UsuarioEnfermedad> findByUsuarioAndEnfermedad(Usuario usuario, Enfermedad enfermedad);
    List<UsuarioEnfermedad> findByUsuarioAndEnfermedad(UsuarioEnfermedad usuarioEnfermedad);
}
