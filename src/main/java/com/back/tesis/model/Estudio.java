package com.back.tesis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaFin;

    private String resultados;

    private Double latitud;

    private Double longitud;

    private String bioma;

    private String fuente;

    private String material;

    private String NCBISampleClassification;

    private String metodoSecuenciacion;


    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEstudio> listUsuarioEstudio;

    private Boolean enCurso;

    private Boolean estado;



}
