package com.back.tesis.controller;

import com.back.tesis.model.Farmaco;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.FarmacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/farmaco")
public class FarmacoController {

    @Autowired
    private FarmacoService farmacoService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Farmaco>> response = new HashMap<>();
        response.put("farmacos", farmacoService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los farmacos");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Farmaco farmaco){
        RestResponse restResponse = new RestResponse();

        Map<String, Farmaco> response = new HashMap<>();
        if (farmacoService.findByNombreEspanol(farmaco.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Esta farmaco ya está registrado.");
        }
        else{
            response.put("farmaco", farmacoService.create(farmaco));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el farmaco.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Farmaco farmaco){
        RestResponse restResponse = new RestResponse();
        List<Farmaco> farmacos;

        Map<String, Farmaco> response = new HashMap<>();
        if (farmacoService.findById(farmaco.getIdFarmaco())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta farmaco no existe en el sistema.");
        }
        else {
            farmacos = farmacoService.findByNombreEspanol(farmaco.getNombreEspanol());
            if (farmacos.size()>0 && farmacos.get(0).getIdFarmaco() != farmaco.getIdFarmaco()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Esta farmaco ya está registrado.");
            }
            else{
                response.put("farmaco", farmacoService.update(farmaco));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el farmaco.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idFarmaco){
        RestResponse restResponse = new RestResponse();
        Farmaco farmaco = farmacoService.findById(idFarmaco);
        if (farmaco==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta farmaco no existe en el sistema.");
        }
        else{
            farmacoService.delete(farmaco);
            restResponse.setMessage("Farmaco eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<Farmaco> farmacos){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Farmaco>> response = new HashMap<>();
        response.put("farmacos", farmacoService.saveAll(farmacos));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon los farmacos.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
    
}
