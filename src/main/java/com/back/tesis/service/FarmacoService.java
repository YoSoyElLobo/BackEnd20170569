package com.back.tesis.service;

import com.back.tesis.model.Farmaco;

import java.util.List;

public interface FarmacoService {
    List<Farmaco> findAll();
    Farmaco create(Farmaco farmaco);
    Farmaco update(Farmaco farmaco);
    Farmaco save(Farmaco farmaco);
    void delete(Farmaco farmaco);
    List<Farmaco> saveAll(List<Farmaco> farmacos);
    List<Farmaco> findByNombre(String nombre);
    Farmaco findById(Long idFarmaco);
}
