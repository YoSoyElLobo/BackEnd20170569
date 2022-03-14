package com.back.tesis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario investigador;

    private String description;

    private ZonedDateTime fechaInicio;

    private ZonedDateTime fechaFin;

    private String resultados;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEstudio> listUsuarioEstudio;

}
