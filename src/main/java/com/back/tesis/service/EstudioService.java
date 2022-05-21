package com.back.tesis.service;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;

import java.util.List;

public interface EstudioService {
    List<Estudio> findAll();
    List<Estudio> findByInvestigador(Usuario usuario);
    Estudio create(Estudio estudio);
    Estudio update(Estudio estudio);
    Estudio save(Estudio estudio);
    void delete(Estudio estudio);
    List<Estudio> saveAll(List<Estudio> estudios);
    List<Estudio> findByNombreEspanol(String nombre);
    List<Estudio> findByParticipante(Usuario usuario);
    Estudio findById(Long idEstudio);

}
