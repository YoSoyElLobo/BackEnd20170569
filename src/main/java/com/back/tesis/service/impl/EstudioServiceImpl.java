package com.back.tesis.service.impl;

import com.back.tesis.model.Estudio;
import com.back.tesis.model.Usuario;
import com.back.tesis.repository.EstudioRepository;
import com.back.tesis.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioServiceImpl implements EstudioService {
    
    @Autowired
    private EstudioRepository estudioRepository;

    @Override
    public List<Estudio> findAll() {
        return estudioRepository.findByEstadoTrue();
    }

    @Override
    public List<Estudio> findByUsuario(Usuario usuario) {
        return estudioRepository.findByInvestigador(usuario);
    }

    @Override
    public Estudio create(Estudio estudio) {
        return save(estudio);
    }

    @Override
    public Estudio update(Estudio estudio) {
        return save(estudio);
    }

    @Override
    public Estudio save(Estudio estudio) {
        return estudioRepository.save(estudio);
    }

    @Override
    public void delete(Estudio estudio) {
        estudio.setEstado(false);
        save(estudio);
    }

    @Override
    public List<Estudio> saveAll(List<Estudio> estudios) {
        return estudioRepository.saveAll(estudios);
    }

    @Override
    public List<Estudio> findByNombreEspanol(String nombre) {
        return estudioRepository.findByNombreEspanolAndEstadoTrue(nombre);
    }

    @Override
    public Estudio findById(Long idEnfermedad) {
        return estudioRepository.findByIdEstudioAndEstadoTrue(idEnfermedad).orElse(null);
    }
}
