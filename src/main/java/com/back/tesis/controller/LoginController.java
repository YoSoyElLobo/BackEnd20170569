package com.back.tesis.controller;

import com.back.tesis.model.Usuario;
import com.back.tesis.response.RestResponse;
import com.back.tesis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/auth")
    public ResponseEntity<RestResponse> login(@RequestBody Map<String, String> accessToken) throws GeneralSecurityException, IOException {
        RestResponse restResponse = new RestResponse();
        Usuario usuario;
        String idTokenString = accessToken.get("accessToken");


        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList("84124350312-d823s2eohatp9b5bmsd7dnha06sh70l2.apps.googleusercontent.com"))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

// (Receive idTokenString by HTTPS POST)

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);


            // Get profile information from payload
            String email = payload.getEmail();
            usuario = usuarioService.findByCorreoElectronico(email);


            /*boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");*/
            restResponse.setPayload(usuario);
            restResponse.setStatus(HttpStatus.OK);
            restResponse.setMessage("Se encontró al usuario");
            return ResponseEntity
                    .status(restResponse.getStatus())
                    .body(restResponse);
        }
        restResponse.setStatus(HttpStatus.NOT_FOUND);
        restResponse.setMessage("No se encontró al usuario");
        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }
}


