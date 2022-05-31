package com.back.tesis.service;

import com.back.tesis.dto.UsuarioDatosGeneralesDTO;
import com.back.tesis.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    List<Usuario> findByIdRol(Long idRol);
    List<Usuario> findByIdRolAceptado(Long idRol);
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
    List<Usuario> saveAll(List<Usuario> usuarios);
    Usuario findByCorreoElectronico(String nombre);
    Usuario findById(Long idUsuario);

    List<Usuario> findEnEspera();
    Usuario aprobarConsentimiento(Usuario usuario);
    Usuario rechazarConsentimiento(Usuario usuario, Usuario usuarioAntiguo);
    Usuario updateDatosGenerales (Usuario usuario, UsuarioDatosGeneralesDTO usuarioDTO);
    Usuario retiro(Usuario usuario);
    Usuario registrarConsentimiento(Usuario usuario);
    List<Usuario> findPosiblesParticipantesByEstudio(Long idEstudio);

}
