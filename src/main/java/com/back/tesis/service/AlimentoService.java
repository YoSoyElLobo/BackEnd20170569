package com.back.tesis.service;

import com.back.tesis.model.Alimento;

import java.util.List;

public interface AlimentoService {
    List<Alimento> findAll();
    Alimento create(Alimento alimento);
    Alimento update(Alimento alimento);
    Alimento save(Alimento alimento);
    void delete(Alimento alimento);
    List<Alimento> saveAll(List<Alimento> alimentos);
    List<Alimento> findByNombre(String nombre);
    Alimento findById(Long idAlimento);
}
