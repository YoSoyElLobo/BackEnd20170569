package com.back.tesis.service.impl;

import com.back.tesis.model.Deporte;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioDeporte;
import com.back.tesis.repository.UsuarioDeporteRepository;
import com.back.tesis.service.UsuarioDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDeporteServiceImpl implements UsuarioDeporteService {

    @Autowired
    private UsuarioDeporteRepository usuarioDeporteRepository;

    @Override
    public UsuarioDeporte create(UsuarioDeporte usuarioDeporte) {
        return save(usuarioDeporte);
    }

    @Override
    public UsuarioDeporte save(UsuarioDeporte usuarioDeporte) {
        return usuarioDeporteRepository.save(usuarioDeporte);
    }

    @Override
    public void delete(Long idUsuarioDeporte) {
        usuarioDeporteRepository.deleteById(idUsuarioDeporte);
    }

    @Override
    public UsuarioDeporte findById(Long idUsuarioDeporte) {
        return usuarioDeporteRepository.findById(idUsuarioDeporte).orElse(null);
    }

    @Override
    public List<UsuarioDeporte> findByUsuarioAndDeporte(Usuario usuario, Deporte deporte) {
        return usuarioDeporteRepository.findByUsuarioAndDeporte(usuario, deporte);
    }

    @Override
    public List<UsuarioDeporte> findByUsuarioAndDeporte(UsuarioDeporte usuarioDeporte) {
        return findByUsuarioAndDeporte(usuarioDeporte.getUsuario(), usuarioDeporte.getDeporte());
    }
}
