package com.back.tesis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UsuarioFarmaco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioFarmaco;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_enfermedad")
    private Farmaco farmaco;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_frecuencia")
    private Frecuencia frecuencia;

    private Integer dosis;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaModificacion;

}
