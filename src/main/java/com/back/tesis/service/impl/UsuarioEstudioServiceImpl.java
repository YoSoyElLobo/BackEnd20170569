package com.back.tesis.service.impl;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEstudio;
import com.back.tesis.repository.UsuarioEstudioRepository;
import com.back.tesis.service.UsuarioEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioEstudioServiceImpl implements UsuarioEstudioService {

    @Autowired
    private UsuarioEstudioRepository usuarioEstudioRepository;

    @Override
    public UsuarioEstudio create(UsuarioEstudio usuarioEstudio) {
        return save(usuarioEstudio);
    }

    @Override
    public UsuarioEstudio update(UsuarioEstudio usuarioEstudio) {
        return save(usuarioEstudio);
    }

    @Override
    public UsuarioEstudio save(UsuarioEstudio usuarioEstudio) {
        return usuarioEstudioRepository.save(usuarioEstudio);
    }

    @Override
    public void delete(UsuarioEstudio usuarioEstudio) {
         usuarioEstudioRepository.delete(usuarioEstudio);
    }

    @Override
    public List<UsuarioEstudio> saveAll(List<UsuarioEstudio> listUsuarioEstudio) {
        return usuarioEstudioRepository.saveAll(listUsuarioEstudio);
    }

    @Override
    public UsuarioEstudio findById(Long idUsuarioEstudio) {
        return usuarioEstudioRepository.findById(idUsuarioEstudio).orElse(null);
    }

    @Override
    public UsuarioEstudio findByUsuarioAndEstudio(Usuario usuario, Estudio estudio) {
        return usuarioEstudioRepository.findByUsuarioAndEstudio(usuario, estudio).orElse(null);
    }

}
