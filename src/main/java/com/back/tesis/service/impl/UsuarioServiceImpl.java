package com.back.tesis.service.impl;

import com.back.tesis.model.Usuario;
import com.back.tesis.repository.UsuarioRepository;
import com.back.tesis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findByEstadoTrue();
    }

    @Override
    public Usuario create(Usuario usuario) {
        return save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return save(usuario);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuario.setEstado(false);
        save(usuario);
    }

    @Override
    public List<Usuario> saveAll(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    @Override
    public Usuario findByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronicoAndEstadoTrue(correoElectronico).orElse(null);
    }

    @Override
    public Usuario findById(Long idEnfermedad) {
        return usuarioRepository.findByIdUsuarioAndEstadoTrue(idEnfermedad).orElse(null);
    }
}