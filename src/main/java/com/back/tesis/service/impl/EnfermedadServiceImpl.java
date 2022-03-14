package com.back.tesis.service.impl;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.repository.EnfermedadRepository;
import com.back.tesis.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;


    @Override
    public List<Enfermedad> findAll() {
        return enfermedadRepository.findAll();
    }

    @Override
    public Enfermedad create(Enfermedad enfermedad) {
        return save(enfermedad);
    }

    @Override
    public Enfermedad update(Enfermedad enfermedad) {
        return save(enfermedad);
    }

    @Override
    public Enfermedad save(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    @Override
    public void delete(Long idEnfermedad) {
        enfermedadRepository.deleteById(idEnfermedad);
    }

    @Override
    public List<Enfermedad> saveAll(List<Enfermedad> enfermedades) {
        return enfermedadRepository.saveAll(enfermedades);
    }

    @Override
    public List<Enfermedad> findByNombre(String nombre) {
        return enfermedadRepository.findByNombre(nombre);
    }

    @Override
    public Enfermedad findById(Long idEnfermedad) {
        return enfermedadRepository.findById(idEnfermedad).orElse(null);
    }


}
