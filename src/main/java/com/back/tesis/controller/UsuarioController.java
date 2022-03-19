package com.back.tesis.controller;

import com.back.tesis.model.Usuario;
import com.back.tesis.response.RestResponse;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Usuario>> response = new HashMap<>();
        response.put("usuarios", usuarioService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los usuarios");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Usuario usuario){
        RestResponse restResponse = new RestResponse();

        Map<String, Usuario> response = new HashMap<>();
        if (usuarioService.findByCorreoElectronico(usuario.getCorreoElectronico()) != null){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Esta usuario ya está registrado.");
        }
        else{
            response.put("usuario", usuarioService.create(usuario));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el usuario.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Usuario usuario){
        RestResponse restResponse = new RestResponse();
        Usuario usuarioAntiguo;

        Map<String, Usuario> response = new HashMap<>();
        if (usuarioService.findById(usuario.getIdUsuario())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta usuario no existe en el sistema.");
        }
        else {
            usuarioAntiguo = usuarioService.findByCorreoElectronico(usuario.getCorreoElectronico());
            if (usuarioAntiguo.getIdUsuario() != usuario.getIdUsuario()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Esta usuario ya está registrado.");
            }
            else{
                response.put("usuario", usuarioService.update(usuario));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el usuario.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuario){
        RestResponse restResponse = new RestResponse();
        Usuario usuario = usuarioService.findById(idUsuario);
        if (usuario==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta usuario no existe en el sistema.");
        }
        else{
            usuarioService.delete(usuario);
            restResponse.setMessage("Usuario eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
