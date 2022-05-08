package com.back.tesis.service.impl;

import com.cloudinary.Cloudinary;

import com.back.tesis.service.CloudinaryService;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryServiceImpl(){
        valuesMap.put("cloud_name", "pucp-dp2");
        valuesMap.put("api_key","984456948362596");
        valuesMap.put("api_secret","dETSd1VAPL8liFH0K0oijc0Xy1Q");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws IOException {

        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("resource_type", "auto", "use_filename", "true"));
        file.delete();

        return result;
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        String str = multipartFile.getOriginalFilename();
        StringBuilder nuevoName = new StringBuilder("");
        char aux;
        /*caracteres no validos para el filename  \/:*?"<>| */
        for (char c : str.toCharArray()) {
            aux = c;
            if (!(aux >= ' ' && aux <= '!') && !(aux >= '#' && aux <= ')')
                    && !(aux >= '+' && aux <= '.') && !(aux >= '0' && aux <= '9')
                    && !(aux == ';') && !(aux == '=') && !(aux >= '@' && aux <= '[')
                    && !(aux >= ']' && aux <= '{') && !(aux >= '}' && aux <= '~')) {
                System.out.println("Caracter invalido detectado: "+ aux);
                aux='_';
            }
            nuevoName.append(aux);
        }

        System.out.println("El nuevo filename es: " + nuevoName);
        File file = new File(String.valueOf(nuevoName));

        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();

        return file;
    }
}
