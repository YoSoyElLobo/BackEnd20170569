package com.back.tesis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBioma;

    private String nombreEspanol;

    private String nombreIngles;


}
