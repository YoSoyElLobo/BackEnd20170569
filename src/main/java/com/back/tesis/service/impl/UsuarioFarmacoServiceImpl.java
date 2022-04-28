package com.back.tesis.service.impl;

import com.back.tesis.model.Farmaco;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioFarmaco;
import com.back.tesis.model.UsuarioFarmaco;
import com.back.tesis.repository.UsuarioFarmacoRepository;
import com.back.tesis.service.UsuarioFarmacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioFarmacoServiceImpl implements UsuarioFarmacoService {

    @Autowired
    private UsuarioFarmacoRepository usuarioFarmacoRepository;

    @Override
    public UsuarioFarmaco create(UsuarioFarmaco usuarioFarmaco) {
        return save(usuarioFarmaco);
    }

    @Override
    public UsuarioFarmaco save(UsuarioFarmaco usuarioFarmaco) {
        return usuarioFarmacoRepository.save(usuarioFarmaco);
    }

    @Override
    public void delete(Long idUsuarioFarmaco) {
        usuarioFarmacoRepository.deleteById(idUsuarioFarmaco);
    }

    @Override
    public UsuarioFarmaco findById(Long idUsuarioFarmaco) {
        return usuarioFarmacoRepository.findById(idUsuarioFarmaco).orElse(null);
    }

    @Override
    public List<UsuarioFarmaco> findByUsuarioAndFarmaco(Usuario usuario, Farmaco farmaco) {
        return usuarioFarmacoRepository.findByUsuarioAndFarmaco(usuario, farmaco);
    }

    @Override
    public List<UsuarioFarmaco> findByUsuarioAndFarmaco(UsuarioFarmaco usuarioFarmaco) {
        return findByUsuarioAndFarmaco(usuarioFarmaco.getUsuario(), usuarioFarmaco.getFarmaco());
    }
    
}
