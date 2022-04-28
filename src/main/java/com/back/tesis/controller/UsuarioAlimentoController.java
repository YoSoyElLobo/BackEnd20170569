package com.back.tesis.controller;

import com.back.tesis.model.Alimento;
import com.back.tesis.model.Usuario;
import com.back.tesis.model.UsuarioAlimento;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.AlimentoService;
import com.back.tesis.service.UsuarioAlimentoService;
import com.back.tesis.service.UsuarioService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarioalimento")
public class UsuarioAlimentoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlimentoService alimentoService;

    @Autowired
    private UsuarioAlimentoService usuarioAlimentoService;

    @GetMapping("/listByUsuario")
    public ResponseEntity<RestResponse> listByUsuario(@RequestParam Long idUsuario){
        RestResponse restResponse = new RestResponse();
        Map<String, List<UsuarioAlimento>> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(idUsuario);

        if(usuario == null){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este usuario no está registrado en el sistema");
        }
        else{
            response.put("usuarioalimentos", usuarioAlimentoService.findByUsuario(usuario));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Se devuelven los alimentos del usuario");
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);

    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody UsuarioAlimento usuarioAlimento){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioAlimento> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioAlimento.getUsuario().getIdUsuario());
        Alimento alimento = alimentoService.findById(usuarioAlimento.getAlimento().getIdAlimento());

        if( usuario == null || alimento == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este alimento no está registrado en el sistema");
            }
        }
        else{
            List<UsuarioAlimento> usuarioAlimentos = usuarioAlimentoService.findByUsuarioAndAlimento(usuarioAlimento);
            if(usuarioAlimentos.size()>0){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este alimento ya está registrado para el usuario.");
            }
            else {
                response.put("usuarioAlimento", usuarioAlimentoService.create(usuarioAlimento));
                restResponse.setPayload(response);
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setMessage("Este alimento se creó para el usuario");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody UsuarioAlimento usuarioAlimento){
        RestResponse restResponse = new RestResponse();
        Map<String, UsuarioAlimento> response = new HashMap<>();

        Usuario usuario = usuarioService.findById(usuarioAlimento.getUsuario().getIdUsuario());
        Alimento alimento = alimentoService.findById(usuarioAlimento.getAlimento().getIdAlimento());

        if( usuario == null || alimento == null ){
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            if ( usuario == null ) {
                restResponse.setMessage("Este usuario no está registrado en el sistema");
            }
            else {
                restResponse.setMessage("Este alimento no está registrado en el sistema");
            }
        }
        else{
            response.put("usuarioAlimento", usuarioAlimentoService.save(usuarioAlimento));
            restResponse.setPayload(response);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este alimento se creó para el usuario");

        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idUsuarioAlimento) {
        RestResponse restResponse = new RestResponse();
        UsuarioAlimento usuarioAlimento = usuarioAlimentoService.findById(idUsuarioAlimento);
        if (usuarioAlimento == null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Esta alimento no está registrado para este usuario.");
        } else {
            usuarioAlimentoService.delete(idUsuarioAlimento);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Este alimento ha sido eliminado para este usuario.");
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}
