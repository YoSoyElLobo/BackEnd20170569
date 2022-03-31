package com.back.tesis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioEstudio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estudio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Estudio estudio;
}
