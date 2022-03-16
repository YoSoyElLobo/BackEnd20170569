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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    private String nombres;

    private String apellidos;

    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    //private tipoDocumento

    private String numeroDocumento;

    private String telefono;

    private ZonedDateTime fechaNacimiento;

    private Long peso;

    private Long talla;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEnfermedad> listUsuarioEnfermedad;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioFarmaco> listUsuarioFarmaco;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioDeporte> listUsuarioDeporte;

    private Boolean estado = true;



}
