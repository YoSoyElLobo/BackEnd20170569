package com.back.tesis.service;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEstudio;

import java.util.List;

public interface UsuarioEstudioService {
    UsuarioEstudio create(UsuarioEstudio usuarioEstudio);
    UsuarioEstudio update(UsuarioEstudio usuarioEstudio);
    UsuarioEstudio save(UsuarioEstudio usuarioEstudio);
    void delete(UsuarioEstudio usuarioEstudio);
    List<UsuarioEstudio> saveAll(List<UsuarioEstudio> listUsuarioEstudio);
    UsuarioEstudio findById(Long idUsuarioEstudio);
    UsuarioEstudio findByUsuarioAndEstudio(Usuario usuario, Estudio estudio);
    UsuarioEstudio aprobar(UsuarioEstudio usuarioEstudio);
    void rechazar(UsuarioEstudio usuarioEstudio);
}
