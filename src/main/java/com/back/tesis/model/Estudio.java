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

    private String nombreEspanol;

    private String nombreIngles;

    private String descripcionEspanol;

    private String descripcionIngles;

    private ZonedDateTime fechaInicio;

    private ZonedDateTime fechaFin;

    private String resultados;

    private Boolean estado;

    private Boolean enCurso;

    private String bioma;

    private String fuente;

    private String material;

    private String NCBISampleClassification;

    //private sequencingMethod or instrumentModel


    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEstudio> listUsuarioEstudio;



}
