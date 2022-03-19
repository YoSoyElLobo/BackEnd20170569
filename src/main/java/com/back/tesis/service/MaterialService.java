package com.back.tesis.service;

import com.back.tesis.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAll();
    Material findById(Long idMaterial);
}