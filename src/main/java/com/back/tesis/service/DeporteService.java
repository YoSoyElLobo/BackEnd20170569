package com.back.tesis.service;

import com.back.tesis.model.Deporte;

import java.util.List;

public interface DeporteService {
    List<Deporte> findAll();
    Deporte create(Deporte deporte);
    Deporte update(Deporte deporte);
    Deporte save(Deporte deporte);
    void delete(Deporte deporte);
    List<Deporte> saveAll(List<Deporte> deportes);
    List<Deporte> findByNombre(String nombre);
    Deporte findById(Long idDeporte);
}
