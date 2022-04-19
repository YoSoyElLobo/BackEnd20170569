package com.back.tesis.controller;

import com.back.tesis.model.Estudio;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudioController {
    
    @Autowired
    private EstudioService estudioService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Estudio>> response = new HashMap<>();
        response.put("estudios", estudioService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los estudios");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Estudio estudio){
        RestResponse restResponse = new RestResponse();

        Map<String, Estudio> response = new HashMap<>();
        if (estudioService.findByNombreEspanol(estudio.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Este estudio ya está registrado.");
        }
        else{
            response.put("estudio", estudioService.create(estudio));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el estudio.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Estudio estudio){
        RestResponse restResponse = new RestResponse();
        List<Estudio> estudios;

        Map<String, Estudio> response = new HashMap<>();
        if (estudioService.findById(estudio.getIdEstudio())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este estudio no existe en el sistema.");
        }
        else {
            estudios = estudioService.findByNombreEspanol(estudio.getNombreEspanol());
            if (estudios.size()>0 && estudios.get(0).getIdEstudio() != estudio.getIdEstudio()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este estudio ya está registrado.");
            }
            else{
                response.put("estudio", estudioService.update(estudio));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el estudio.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idEstudio){
        RestResponse restResponse = new RestResponse();
        Estudio estudio = estudioService.findById(idEstudio);
        if (estudio==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este estudio no existe en el sistema.");
        }
        else{
            estudioService.delete(estudio);
            restResponse.setMessage("Estudio eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }


}