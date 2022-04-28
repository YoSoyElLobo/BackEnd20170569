package com.back.tesis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Peso {

    public Peso(Usuario usuario, Integer cantidad){
        setUsuario(usuario);
        setCantidad(cantidad);
        setFechaModificacion(new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    private Integer cantidad;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaModificacion;
}
