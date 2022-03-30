package com.back.tesis.controller;

import com.back.tesis.model.Pais;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pais")
public class PaisController {
    
    @Autowired
    private PaisService paisService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Pais>> response = new HashMap<>();
        response.put("paises", paisService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los paises");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Pais pais){
        RestResponse restResponse = new RestResponse();

        Map<String, Pais> response = new HashMap<>();
        if (paisService.findByNombreEspanol(pais.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Esta pais ya está registrado.");
        }
        else{
            response.put("pais", paisService.create(pais));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el pais.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Pais pais){
        RestResponse restResponse = new RestResponse();
        List<Pais> paises;

        Map<String, Pais> response = new HashMap<>();
        if (paisService.findById(pais.getIdPais())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta pais no existe en el sistema.");
        }
        else {
            paises = paisService.findByNombreEspanol(pais.getNombreEspanol());
            if (paises.size()>0 && paises.get(0).getIdPais() != pais.getIdPais()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Esta pais ya está registrado.");
            }
            else{
                response.put("pais", paisService.update(pais));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el pais.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idPais){
        RestResponse restResponse = new RestResponse();
        Pais pais = paisService.findById(idPais);
        if (pais==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta pais no existe en el sistema.");
        }
        else{
            paisService.delete(pais);
            restResponse.setMessage("Pais eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<Pais> paises){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Pais>> response = new HashMap<>();
        response.put("paises", paisService.saveAll(paises));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon los paises.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
