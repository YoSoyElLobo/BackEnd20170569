package com.back.tesis.service;

import com.back.tesis.model.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> findAll();
    Pais create(Pais pais);
    Pais update(Pais pais);
    Pais save(Pais pais);
    void delete(Pais pais);
    List<Pais> saveAll(List<Pais> paises);
    List<Pais> findByNombre(String nombre);
    Pais findById(Long idPais);
}
