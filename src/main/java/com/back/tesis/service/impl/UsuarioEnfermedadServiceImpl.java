package com.back.tesis.service.impl;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEnfermedad;
import com.back.tesis.repository.UsuarioEnfermedadRepository;
import com.back.tesis.service.UsuarioEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioEnfermedadServiceImpl implements UsuarioEnfermedadService {

    @Autowired
    private UsuarioEnfermedadRepository usuarioEnfermedadRepository;

    @Override
    public UsuarioEnfermedad create(UsuarioEnfermedad usuarioEnfermedad) {
        return save(usuarioEnfermedad);
    }

    @Override
    public UsuarioEnfermedad save(UsuarioEnfermedad usuarioEnfermedad) {
        return usuarioEnfermedadRepository.save(usuarioEnfermedad);
    }

    @Override
    public void delete(Long idUsuarioEnfermedad) {
        usuarioEnfermedadRepository.deleteById(idUsuarioEnfermedad);
    }

    @Override
    public UsuarioEnfermedad findById(Long idUsuarioEnfermedad) {
        return usuarioEnfermedadRepository.findById(idUsuarioEnfermedad).orElse(null);
    }

    @Override
    public List<UsuarioEnfermedad> findByUsuarioAndEnfermedad(Usuario usuario, Enfermedad enfermedad) {
        return usuarioEnfermedadRepository.findByUsuarioAndEnfermedad(usuario, enfermedad);
    }

    @Override
    public List<UsuarioEnfermedad> findByUsuarioAndEnfermedad(UsuarioEnfermedad usuarioEnfermedad) {
        return findByUsuarioAndEnfermedad(usuarioEnfermedad.getUsuario(), usuarioEnfermedad.getEnfermedad());
    }
}
