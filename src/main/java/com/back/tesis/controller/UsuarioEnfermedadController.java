package com.back.tesis.controller;

import com.back.tesis.model.Enfermedad;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioEnfermedad;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.EnfermedadService;
import com.back.tesis.service.UsuarioEnfermedadService;
import com.back.tesis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarioenfermedad")
public class UsuarioEnfermedadController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnfermedadService enfermedadService;

    @Autowired
    private UsuarioEnfermedadService usuarioEnfermedadService;


    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody UsuarioEnfermedad usuarioEnfermedad){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioEnfermedad> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioEnfermedad.getUsuario().getIdUsuario());
        Enfermedad enfermedad = enfermedadService.findById(usuarioEnfermedad.getEnfermedad().getIdEnfermedad());

        if( usuario == null || enfermedad == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este enfermedad no está registrado en el sistema");
            }
        }
        else{
            List<UsuarioEnfermedad> usuarioEnfermedads = usuarioEnfermedadService.findByUsuarioAndEnfermedad(usuarioEnfermedad);
            if(usuarioEnfermedads.size()>0){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este enfermedad ya está registrado para el usuario.");
            }
            else {
                response.put("usuarioEnfermedad", usuarioEnfermedadService.create(usuarioEnfermedad));
                restResponse.setPayload(response);
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setMessage("Este enfermedad se creó para el usuario");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/create")
    public ResponseEntity<RestResponse> update(@RequestBody UsuarioEnfermedad usuarioEnfermedad){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioEnfermedad> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioEnfermedad.getUsuario().getIdUsuario());
        Enfermedad enfermedad = enfermedadService.findById(usuarioEnfermedad.getEnfermedad().getIdEnfermedad());

        if( usuario == null || enfermedad == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este enfermedad no está registrado en el sistema");
            }
        }
        else{

            response.put("usuarioEnfermedad", usuarioEnfermedadService.create(usuarioEnfermedad));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este enfermedad se creó para el usuario");

        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuarioEnfermedad) {
        RestResponse restResponse = new RestResponse();
        UsuarioEnfermedad usuarioEnfermedad = usuarioEnfermedadService.findById(idUsuarioEnfermedad);
        if (usuarioEnfermedad == null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta enfermedad no está registrado para este usuario.");
        } else {
            usuarioEnfermedadService.delete(idUsuarioEnfermedad);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este enfermedad ha sido eliminado para este usuario.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

}