package com.back.tesis.service.impl;

import com.back.tesis.model.Pais;
import com.back.tesis.repository.PaisRepository;
import com.back.tesis.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;


    @Override
    public List<Pais> findAll() {
        return paisRepository.findByEstadoTrue();
    }

    @Override
    public Pais create(Pais pais) {
        return save(pais);
    }

    @Override
    public Pais update(Pais pais) {
        return save(pais);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void delete(Pais pais) {
        pais.setEstado(false);
        save(pais);
    }

    @Override
    public List<Pais> saveAll(List<Pais> paises) {
        return paisRepository.saveAll(paises);
    }

    @Override
    public List<Pais> findByNombre(String nombre) {
        return paisRepository.findByNombreAndEstadoTrue(nombre);
    }

    @Override
    public Pais findById(Long idPais) {
        return paisRepository.findByIdPaisAndEstadoTrue(idPais).orElse(null);
    }
    
}
