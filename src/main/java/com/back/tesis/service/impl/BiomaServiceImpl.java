package com.back.tesis.service.impl;

import com.back.tesis.model.Bioma;
import com.back.tesis.repository.BiomaRepository;
import com.back.tesis.service.BiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiomaServiceImpl implements BiomaService {

    @Autowired
    private BiomaRepository biomaRepository;

    @Override
    public List<Bioma> findAll() {
        return biomaRepository.findAll();
    }

    @Override
    public Bioma findById(Long idBioma) {
        return biomaRepository.findById(idBioma).orElse(null);
    }
}
