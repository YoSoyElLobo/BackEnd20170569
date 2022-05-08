package com.back.tesis.controller;

import com.back.tesis.response.RestResponse;
import com.back.tesis.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cloudinary")
public class CloudinaryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<RestResponse> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        RestResponse restResponse = new RestResponse();

        Map result = new HashMap<>();
        result.put("archivo",cloudinaryService.upload(multipartFile));
        restResponse.setStatus(HttpStatus.OK);
        restResponse.setPayload(result);
        restResponse.setMessage("Se subio correctamente el archivo " + multipartFile.getOriginalFilename());

        return ResponseEntity
                .status(restResponse.getStatus())
                .body(restResponse);
    }

}
