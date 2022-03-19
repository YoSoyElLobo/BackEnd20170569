package com.back.tesis.service.impl;

import com.back.tesis.model.Material;
import com.back.tesis.repository.MaterialRepository;
import com.back.tesis.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material findById(Long idMaterial) {
        return materialRepository.findById(idMaterial).orElse(null);
    }
}
