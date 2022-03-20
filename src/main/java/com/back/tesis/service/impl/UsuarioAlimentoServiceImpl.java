package com.back.tesis.service.impl;

import com.back.tesis.model.Alimento;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioAlimento;
import com.back.tesis.repository.UsuarioAlimentoRepository;
import com.back.tesis.service.UsuarioAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioAlimentoServiceImpl implements UsuarioAlimentoService {

    @Autowired
    private UsuarioAlimentoRepository usuarioAlimentoRepository;

    @Override
    public UsuarioAlimento create(UsuarioAlimento usuarioAlimento) {
        return save(usuarioAlimento);
    }

    @Override
    public UsuarioAlimento save(UsuarioAlimento usuarioAlimento) {
        return usuarioAlimentoRepository.save(usuarioAlimento);
    }

    @Override
    public void delete(Long idUsuarioAlimento) {
        usuarioAlimentoRepository.deleteById(idUsuarioAlimento);
    }

    @Override
    public UsuarioAlimento findById(Long idUsuarioAlimento) {
        return usuarioAlimentoRepository.findById(idUsuarioAlimento).orElse(null);
    }

    @Override
    public List<UsuarioAlimento> findByUsuario(Usuario usuario) {
        return usuarioAlimentoRepository.findByUsuario(usuario);
    }

    @Override
    public List<UsuarioAlimento> findByUsuarioAndAlimento(Usuario usuario, Alimento alimento) {
        return usuarioAlimentoRepository.findByUsuarioAndAlimento(usuario, alimento);
    }

    @Override
    public List<UsuarioAlimento> findByUsuarioAndAlimento(UsuarioAlimento usuarioAlimento) {
        return findByUsuarioAndAlimento(usuarioAlimento.getUsuario(), usuarioAlimento.getAlimento());
    }
}
