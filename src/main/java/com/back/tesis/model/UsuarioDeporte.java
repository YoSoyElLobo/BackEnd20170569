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
public class UsuarioDeporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioEnfermedad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_deporte")
    private Deporte deporte;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_frecuencia")
    private Frecuencia frecuencia;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaModificacion;
}
