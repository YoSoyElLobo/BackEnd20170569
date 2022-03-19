package com.back.tesis.controller;

import com.back.tesis.model.Bioma;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.BiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bioma")
public class BiomaController {
    
    @Autowired
    private BiomaService biomaService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Bioma>> response = new HashMap<>();
        response.put("biomas", biomaService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los biomas");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
