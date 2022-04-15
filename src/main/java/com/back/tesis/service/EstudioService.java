package com.back.tesis.service;

import com.back.tesis.model.Estudio;

import java.util.List;

public interface EstudioService {
    List<Estudio> findAll();
    Estudio create(Estudio estudio);
    Estudio update(Estudio estudio);
    Estudio save(Estudio estudio);
    void delete(Estudio estudio);
    List<Estudio> saveAll(List<Estudio> estudios);
    List<Estudio> findByNombreEspanol(String nombre);
    Estudio findById(Long idEstudio);
}
