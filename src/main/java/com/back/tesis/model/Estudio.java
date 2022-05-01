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

    @Lob
    private String descripcionEspanol;

    @Lob
    private String descripcionIngles;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaFin;

    private String resultados;

    private String latitud;

    private String longitud;

    @ManyToOne
    @JoinColumn(name = "id_bioma")
    private Bioma bioma;

    private String fuente;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    private String ncbiSampleClassification;

    private String metodoSecuenciacion;


    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEstudio> listUsuarioEstudio;

    private Boolean enCurso = true;

    private Boolean estado = true;



}
