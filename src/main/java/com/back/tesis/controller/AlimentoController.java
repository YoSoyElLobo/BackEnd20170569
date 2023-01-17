package com.back.tesis.controller;

import com.back.tesis.model.Alimento;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alimento")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("/list")
    public ResponseEntity<RestResponse> list(){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Alimento>> response = new HashMap<>();
        response.put("alimentos", alimentoService.findAll());

        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se listan todos los alimentos");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse> create(@RequestBody Alimento alimento){
        RestResponse restResponse = new RestResponse();

        Map<String, Alimento> response = new HashMap<>();
        if (alimentoService.findByNombreEspanol(alimento.getNombreEspanol()).size()>0){
            restResponse.setStatus(HttpStatus.BAD_REQUEST);
            restResponse.setMessage("Este alimento ya está registrado.");
        }
        else{
            response.put("alimento", alimentoService.create(alimento));
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setPayload(response);
            restResponse.setMessage("Se creó el alimento.");
        }


        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse> update(@RequestBody Alimento alimento){
        RestResponse restResponse = new RestResponse();
        List<Alimento> alimentos;

        Map<String, Alimento> response = new HashMap<>();
        if (alimentoService.findById(alimento.getIdAlimento())==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este alimento no existe en el sistema.");
        }
        else {
            alimentos = alimentoService.findByNombreEspanol(alimento.getNombreEspanol());
            if (alimentos.size()>0 && alimentos.get(0).getIdAlimento() != alimento.getIdAlimento()){
                restResponse.setStatus(HttpStatus.BAD_REQUEST);
                restResponse.setMessage("Este alimento ya está registrado.");
            }
            else{
                response.put("alimento", alimentoService.update(alimento));
                restResponse.setStatus(HttpStatus.OK);
                restResponse.setPayload(response);
                restResponse.setMessage("Se actualizó el alimento.");
            }
        }

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long idAlimento){
        RestResponse restResponse = new RestResponse();
        Alimento alimento = alimentoService.findById(idAlimento);
        if (alimento==null) {
            restResponse.setStatus(HttpStatus.NOT_FOUND);
            restResponse.setMessage("Este alimento no existe en el sistema.");
        }
        else{
            alimentoService.delete(alimento);
            restResponse.setMessage("Alimento eliminado.");
            restResponse.setStatus(HttpStatus.OK);
        }
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

    @PostMapping("/createAll")
    public ResponseEntity<RestResponse> createAll(@RequestBody List<Alimento> alimentos){
        RestResponse restResponse = new RestResponse();

        Map<String, List<Alimento>> response = new HashMap<>();
        response.put("alimentos", alimentoService.saveAll(alimentos));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(response);
        restResponse.setMessage("Se crearon los alimentos.");

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
    //
}
