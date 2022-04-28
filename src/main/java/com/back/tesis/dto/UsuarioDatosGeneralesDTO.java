package com.back.tesis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDatosGeneralesDTO {

    private Long idUsuario;

    private String correoElectronico;

    private Character sexo;

    private String telefono;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaNacimiento;

    private Integer peso;

    private Integer talla;

}
