package com.back.tesis.controller;

import com.back.tesis.model.Frecuencia;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.FrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/frecuencia")
public class FrecuenciaController {

    @Autowired
    FrecuenciaService frecuenciaService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Frecuencia>> response = new HashMap<>();
        response.put("frecuencias", frecuenciaService.getAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todas las frecuencias");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
