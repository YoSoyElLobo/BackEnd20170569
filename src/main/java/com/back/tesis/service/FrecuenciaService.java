package com.back.tesis.service;

import com.back.tesis.model.Frecuencia;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FrecuenciaService {
    List<Frecuencia> findAll();
    Frecuencia findById(Long idFrecuencia);

}
