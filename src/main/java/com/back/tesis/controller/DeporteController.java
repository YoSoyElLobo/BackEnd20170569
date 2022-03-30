package com.back.tesis.controller;

import com.back.tesis.model.Deporte;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Deporte>> response = new HashMap<>();
        response.put("deportes", deporteService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos las deportes");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Deporte deporte){
        RestResponse restResponse = new RestResponse();

        Map<String, Deporte> response = new HashMap<>();
        if (deporteService.findByNombreEspanol(deporte.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Esta deporte ya está registrado.");
        }
        else{
            response.put("deporte", deporteService.create(deporte));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el deporte.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Deporte deporte){
        RestResponse restResponse = new RestResponse();
        List<Deporte> deportes;

        Map<String, Deporte> response = new HashMap<>();
        if (deporteService.findById(deporte.getIdDeporte())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta deporte no existe en el sistema.");
        }
        else {
            deportes = deporteService.findByNombreEspanol(deporte.getNombreEspanol());
            if (deportes.size()>0 && deportes.get(0).getIdDeporte() != deporte.getIdDeporte()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Esta deporte ya está registrado.");
            }
            else{
                response.put("deporte", deporteService.update(deporte));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el deporte.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idDeporte){
        RestResponse restResponse = new RestResponse();
        Deporte deporte = deporteService.findById(idDeporte);
        if (deporte==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta deporte no existe en el sistema.");
        }
        else{
            deporteService.delete(deporte);
            restResponse.setMessage("Deporte eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<Deporte> deportes){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Deporte>> response = new HashMap<>();
        response.put("deportes", deporteService.saveAll(deportes));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon los deportes.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
