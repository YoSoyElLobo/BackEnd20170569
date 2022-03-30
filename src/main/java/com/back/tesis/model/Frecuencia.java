package com.back.tesis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Frecuencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFrecuencia;

    private String nombreEspanol;

    private String nombreIngles;

}
