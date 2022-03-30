package com.back.tesis.service;

import com.back.tesis.model.Enfermedad;

import java.util.List;

public interface EnfermedadService {
    List<Enfermedad> findAll();
    Enfermedad create(Enfermedad enfermedad);
    Enfermedad update(Enfermedad enfermedad);
    Enfermedad save(Enfermedad enfermedad);
    void delete(Enfermedad enfermedad);
    List<Enfermedad> saveAll(List<Enfermedad> enfermedades);
    List<Enfermedad> findByNombre(String nombre);
    Enfermedad findById(Long idEnfermedad);

}
