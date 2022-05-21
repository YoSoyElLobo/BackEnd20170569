package com.back.tesis.controller;

import com.back.tesis.model.*;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.EstudioService;
import com.back.tesis.service.UsuarioEstudioService;
import com.back.tesis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarioestudio")
public class UsuarioEstudioController {

    @Autowired
    private UsuarioEstudioService usuarioEstudioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstudioService estudioService;

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody UsuarioEstudio usuarioEstudio) {
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioEstudio> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioEstudio.getUsuario().getIdUsuario());
        Estudio estudio = estudioService.findById(usuarioEstudio.getEstudio().getIdEstudio());

        if( usuario == null || estudio == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este estudio no está registrado en el sistema");
            }
        }
        else{
            response.put("usuarioEstudio", usuarioEstudioService.create(usuarioEstudio));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este usuario se registró en el estudio");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody UsuarioEstudio usuarioEstudio) {
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioEstudio> response = new HashMap<>();

        UsuarioEstudio usuarioEstudioAntiguo = usuarioEstudioService.findById(usuarioEstudio.getIdUsuarioEstudio());
        if( usuarioEstudioAntiguo == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este usuario no está registrado en el estudio.");
        }
        else{
            usuarioEstudioAntiguo.copyUsuarioEstudio(usuarioEstudio);
            response.put("usuarioEstudio", usuarioEstudioService.update(usuarioEstudioAntiguo));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este usuario no está registrado en el estudio.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuarioEstudio) {
        RestResponse restResponse = new RestResponse();

        UsuarioEstudio usuarioEstudio = usuarioEstudioService.findById(idUsuarioEstudio);
        if( usuarioEstudio == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este usuario no está registrado en el estudio.");
        }
        else{
            usuarioEstudioService.delete(usuarioEstudio);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este usuario fue eliminado.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<UsuarioEstudio> listUsuarioEstudio){
        RestResponse restResponse = new RestResponse();
        Map<String, List<UsuarioEstudio>> response = new HashMap<>();
        List<UsuarioEstudio> listUsuarioEstudioAnt = new ArrayList<UsuarioEstudio>();
        Integer size = listUsuarioEstudio.size();

        for(Integer i=0; i<size; i++){
            UsuarioEstudio usuarioEstudio = listUsuarioEstudio.get(i);
            listUsuarioEstudioAnt.add(usuarioEstudioService.findByUsuarioAndEstudio(usuarioEstudio.getUsuario(), usuarioEstudio.getEstudio()));
            listUsuarioEstudioAnt.get(i).copyUsuarioEstudio(usuarioEstudio);
        }

        response.put("listUsuarioEstudio", usuarioEstudioService.saveAll(listUsuarioEstudioAnt));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon los usuarios.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
