package com.back.tesis.controller;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enfermedad")
public class EnfermedadController {

    @Autowired
    private EnfermedadService enfermedadService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Enfermedad>> response = new HashMap<>();
        response.put("enfermedades", enfermedadService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todas las enfermedades");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Enfermedad enfermedad){
        RestResponse restResponse = new RestResponse();

        Map<String, Enfermedad> response = new HashMap<>();
        if (enfermedadService.findByNombreEspanol(enfermedad.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Esta enfermedad ya está registrada.");
        }
        else{
            response.put("enfermedad", enfermedadService.create(enfermedad));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó la enfermedad.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Enfermedad enfermedad){
        RestResponse restResponse = new RestResponse();
        List<Enfermedad> enfermedades;

        Map<String, Enfermedad> response = new HashMap<>();
        if (enfermedadService.findById(enfermedad.getIdEnfermedad())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta enfermedad no existe en el sistema.");
        }
        else {
            enfermedades = enfermedadService.findByNombreEspanol(enfermedad.getNombreEspanol());
            if (enfermedades.size()>0 && enfermedades.get(0).getIdEnfermedad() != enfermedad.getIdEnfermedad()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Esta enfermedad ya está registrada.");
            }
            else{
                response.put("enfermedad", enfermedadService.update(enfermedad));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó la enfermedad.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idEnfermedad){
        RestResponse restResponse = new RestResponse();
        Enfermedad enfermedad = enfermedadService.findById(idEnfermedad);
        if (enfermedad==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta enfermedad no existe en el sistema.");
        }
        else{
            enfermedadService.delete(enfermedad);
            restResponse.setMessage("Enfermedad eliminada.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<Enfermedad> enfermedades){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Enfermedad>> response = new HashMap<>();
        response.put("enfermedades", enfermedadService.saveAll(enfermedades));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon las enfermedades.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
    //

}
