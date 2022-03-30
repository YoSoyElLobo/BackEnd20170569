package com.back.tesis.service.impl;

import com.back.tesis.model.Alimento;
import com.back.tesis.repository.AlimentoRepository;
import com.back.tesis.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Override
    public List<Alimento> findAll() {
        return alimentoRepository.findByEstadoTrue();
    }

    @Override
    public Alimento create(Alimento alimento) {
        return save(alimento);
    }

    @Override
    public Alimento update(Alimento alimento) {
        return save(alimento);
    }

    @Override
    public Alimento save(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    @Override
    public void delete(Alimento alimento) {
        alimento.setEstado(false);
        save(alimento);
    }

    @Override
    public List<Alimento> saveAll(List<Alimento> alimentos) {
        return alimentoRepository.saveAll(alimentos);
    }

    @Override
    public List<Alimento> findByNombreEspanol(String nombre) {
        return alimentoRepository.findByNombreEspanolAndEstadoTrue(nombre);
    }

    @Override
    public Alimento findById(Long idEnfermedad) {
        return alimentoRepository.findByIdAlimentoAndEstadoTrue(idEnfermedad).orElse(null);
    }
    
}
