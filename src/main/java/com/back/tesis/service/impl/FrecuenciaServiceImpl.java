package com.back.tesis.service.impl;


import com.back.tesis.model.Frecuencia;
import com.back.tesis.repository.FrecuenciaRepository;
import com.back.tesis.service.FrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrecuenciaServiceImpl implements FrecuenciaService {

    @Autowired
    FrecuenciaRepository frecuenciaRepository;

    @Override
    public List<Frecuencia> getAll() {
        return frecuenciaRepository.findAll();
    }

    @Override
    public Frecuencia findById(Long idFrecuencia) {
        return frecuenciaRepository.findById(idFrecuencia).orElse(null);
    }
}
