package com.back.tesis.service.impl;

import com.back.tesis.dto.UsuarioDatosGeneralesDTO;
import com.back.tesis.model.Peso;
import com.back.tesis.model.Talla;
import com.back.tesis.model.Usuario;
import com.back.tesis.repository.PesoRepository;
import com.back.tesis.repository.TallaRepository;
import com.back.tesis.repository.UsuarioRepository;
import com.back.tesis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private TallaRepository tallaRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findByEstadoTrue();
    }

    @Override
    public List<Usuario> findByIdRol(Long idRol) {
        return usuarioRepository.findByRol_IdRolAndEstadoTrue(idRol);
    }

    @Override
    public List<Usuario> findByIdRolAceptado(Long idRol) {
        return usuarioRepository.findByRol_IdRolAndEstadoTrueAndAprobadoTrue(idRol);
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

    @Override
    public List<Usuario> findEnEspera() {
        return usuarioRepository.findByEstadoTrueAndEnEsperaTrue();
    }

    @Override
    public Usuario aprobarConsentimiento(Usuario usuario) {
        usuario.setEnEspera(false);
        usuario.setAprobado(true);
        return save(usuario);
    }

    @Override
    public Usuario rechazarConsentimiento(Usuario usuario, Usuario usuarioAntiguo) {
        usuarioAntiguo.setEnEspera(false);
        usuarioAntiguo.setAprobado(false);
        usuarioAntiguo.setMotivoRechazo(usuario.getMotivoRechazo());
        return save(usuarioAntiguo);
    }

    @Override
    public Usuario updateDatosGenerales(Usuario usuario, UsuarioDatosGeneralesDTO usuarioDTO) {
        Peso peso = new Peso(usuario, usuarioDTO.getPeso());
        Talla talla = new Talla(usuario, usuarioDTO.getTalla());
        pesoRepository.save(peso);
        tallaRepository.save(talla);
        usuario.copyUsuario(usuarioDTO);
        return save(usuario);
    }

    @Override
    public Usuario retiro(Usuario usuario) {
        usuario.setRetirado(true);
        usuario.setEstado(false);
        return save(usuario);
    }

    @Override
    public Usuario registrarConsentimiento(Usuario usuario) {
        usuario.setEnEspera(true);
        return save(usuario);
    }


}
