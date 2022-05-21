package com.back.tesis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private String codigoMuestra;

    private Boolean aceptado = false;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaMuestreo;

    public void copyUsuarioEstudio(UsuarioEstudio usuarioEstudio){
        /*if(usuarioEstudio.getUsuario()!=null) setUsuario(usuarioEstudio.getUsuario());
        if(usuarioEstudio.getEstudio()!=null) setEstudio(usuarioEstudio.getEstudio());*/
        if(usuarioEstudio.getCodigoMuestra()!=null) setCodigoMuestra(usuarioEstudio.getCodigoMuestra());
        if(usuarioEstudio.getAceptado()!=null) setAceptado(usuarioEstudio.getAceptado());
        if(usuarioEstudio.getFechaMuestreo()!=null) setFechaMuestreo(usuarioEstudio.getFechaMuestreo());
    }
}
