package com.back.tesis.service;

import com.back.tesis.model.Bioma;

import java.util.List;

public interface BiomaService {
    List<Bioma> findAll();
    Bioma findById(Long idBioma);
}
