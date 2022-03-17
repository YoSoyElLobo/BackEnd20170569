package com.back.tesis.service.impl;

import com.back.tesis.model.Deporte;
import com.back.tesis.repository.DeporteRepository;
import com.back.tesis.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService {
    
    @Autowired
    private DeporteRepository deporteRepository;


    @Override
    public List<Deporte> findAll() {
        return deporteRepository.findByEstadoTrue();
    }

    @Override
    public Deporte create(Deporte deporte) {
        return save(deporte);
    }

    @Override
    public Deporte update(Deporte deporte) {
        return save(deporte);
    }

    @Override
    public Deporte save(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    @Override
    public void delete(Deporte deporte) {
        deporte.setEstado(false);
        save(deporte);
    }

    @Override
    public List<Deporte> saveAll(List<Deporte> deportes) {
        return deporteRepository.saveAll(deportes);
    }

    @Override
    public List<Deporte> findByNombre(String nombre) {
        return deporteRepository.findByNombreAndEstadoTrue(nombre);
    }

    @Override
    public Deporte findById(Long idEnfermedad) {
        return deporteRepository.findByIdDeporteAndEstadoTrue(idEnfermedad).orElse(null);
    }
}
