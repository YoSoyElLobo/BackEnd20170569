package com.back.tesis.service;

import com.back.tesis.model.Rol;

import java.util.List;

public interface RolService {
    List<Rol> findAll();
    Rol findById(Long idRol);
}
