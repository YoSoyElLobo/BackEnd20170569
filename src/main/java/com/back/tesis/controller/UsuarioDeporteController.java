package com.back.tesis.controller;

import com.back.tesis.model.Deporte;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioDeporte;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.DeporteService;
import com.back.tesis.service.UsuarioDeporteService;
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
@RequestMapping("/usuariodeporte")
public class UsuarioDeporteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DeporteService deporteService;

    @Autowired
    private UsuarioDeporteService usuarioDeporteService;
    

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody UsuarioDeporte usuarioDeporte){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioDeporte> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioDeporte.getUsuario().getIdUsuario());
        Deporte deporte = deporteService.findById(usuarioDeporte.getDeporte().getIdDeporte());

        if( usuario == null || deporte == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este deporte no está registrado en el sistema");
            }
        }
        else{
            List<UsuarioDeporte> usuarioDeportes = usuarioDeporteService.findByUsuarioAndDeporte(usuarioDeporte);
            if(usuarioDeportes.size()>0){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este deporte ya está registrado para el usuario.");
            }
            else {
                response.put("usuarioDeporte", usuarioDeporteService.create(usuarioDeporte));
                restResponse.setPayload(response);
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setMessage("Este deporte se creó para el usuario");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody UsuarioDeporte usuarioDeporte){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioDeporte> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioDeporte.getUsuario().getIdUsuario());
        Deporte deporte = deporteService.findById(usuarioDeporte.getDeporte().getIdDeporte());

        if( usuario == null || deporte == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este deporte no está registrado en el sistema");
            }
        }
        else{

            response.put("usuarioDeporte", usuarioDeporteService.create(usuarioDeporte));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este deporte se creó para el usuario");

        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuarioDeporte) {
        RestResponse restResponse = new RestResponse();
        UsuarioDeporte usuarioDeporte = usuarioDeporteService.findById(idUsuarioDeporte);
        if (usuarioDeporte == null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta deporte no está registrado para este usuario.");
        } else {
            usuarioDeporteService.delete(idUsuarioDeporte);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este deporte ha sido eliminado para este usuario.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
    
}
