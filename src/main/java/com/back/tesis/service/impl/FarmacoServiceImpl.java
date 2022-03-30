package com.back.tesis.service.impl;

import com.back.tesis.model.Farmaco;
import com.back.tesis.repository.FarmacoRepository;
import com.back.tesis.service.FarmacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmacoServiceImpl implements FarmacoService {

    @Autowired
    private FarmacoRepository farmacoRepository;

    @Override
    public List<Farmaco> findAll() {
        return farmacoRepository.findByEstadoTrue();
    }

    @Override
    public Farmaco create(Farmaco farmaco) {
        return save(farmaco);
    }

    @Override
    public Farmaco update(Farmaco farmaco) {
        return save(farmaco);
    }

    @Override
    public Farmaco save(Farmaco farmaco) {
        return farmacoRepository.save(farmaco);
    }

    @Override
    public void delete(Farmaco farmaco) {
        farmaco.setEstado(false);
        save(farmaco);
    }

    @Override
    public List<Farmaco> saveAll(List<Farmaco> farmacos) {
        return farmacoRepository.saveAll(farmacos);
    }

    @Override
    public List<Farmaco> findByNombre(String nombre) {
        return farmacoRepository.findByNombreAndEstadoTrue(nombre);
    }

    @Override
    public Farmaco findById(Long idEnfermedad) {
        return farmacoRepository.findByIdFarmacoAndEstadoTrue(idEnfermedad).orElse(null);
    }
}
