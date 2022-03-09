package com.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

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
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_deporte")
    private Deporte deporte;

    private ZonedDateTime fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_frecuencia")
    private Frecuencia frecuencia;
}
