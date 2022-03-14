package com.back.tesis.service;

import com.back.tesis.model.Frecuencia;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FrecuenciaService {
    List<Frecuencia> getAll();
    Frecuencia findById(Long idFrecuencia);

}
