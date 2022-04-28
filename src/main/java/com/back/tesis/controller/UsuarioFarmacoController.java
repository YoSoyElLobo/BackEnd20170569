package com.back.tesis.controller;

import com.back.tesis.model.Farmaco;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioFarmaco;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.FarmacoService;
import com.back.tesis.service.UsuarioFarmacoService;
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
@RequestMapping("/usuariofarmaco")
public class UsuarioFarmacoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FarmacoService farmacoService;

    @Autowired
    private UsuarioFarmacoService usuarioFarmacoService;


    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody UsuarioFarmaco usuarioFarmaco){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioFarmaco> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioFarmaco.getUsuario().getIdUsuario());
        Farmaco farmaco = farmacoService.findById(usuarioFarmaco.getFarmaco().getIdFarmaco());

        if( usuario == null || farmaco == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este farmaco no está registrado en el sistema");
            }
        }
        else{
            List<UsuarioFarmaco> usuarioFarmacos = usuarioFarmacoService.findByUsuarioAndFarmaco(usuarioFarmaco);
            if(usuarioFarmacos.size()>0){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este farmaco ya está registrado para el usuario.");
            }
            else {
                response.put("usuarioFarmaco", usuarioFarmacoService.create(usuarioFarmaco));
                restResponse.setPayload(response);
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setMessage("Este farmaco se creó para el usuario");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody UsuarioFarmaco usuarioFarmaco){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioFarmaco> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioFarmaco.getUsuario().getIdUsuario());
        Farmaco farmaco = farmacoService.findById(usuarioFarmaco.getFarmaco().getIdFarmaco());

        if( usuario == null || farmaco == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este farmaco no está registrado en el sistema");
            }
        }
        else{
            response.put("usuarioFarmaco", usuarioFarmacoService.create(usuarioFarmaco));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este farmaco se creó para el usuario");
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuarioFarmaco) {
        RestResponse restResponse = new RestResponse();
        UsuarioFarmaco usuarioFarmaco = usuarioFarmacoService.findById(idUsuarioFarmaco);
        if (usuarioFarmaco == null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta farmaco no está registrado para este usuario.");
        } else {
            usuarioFarmacoService.delete(idUsuarioFarmaco);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este farmaco ha sido eliminado para este usuario.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

}
