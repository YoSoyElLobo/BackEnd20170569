package com.back.tesis.service.impl;

import com.back.tesis.model.Rol;
import com.back.tesis.repository.RolRepository;
import com.back.tesis.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long idRol) {
        return rolRepository.findById(idRol).orElse(null);
    }
}
