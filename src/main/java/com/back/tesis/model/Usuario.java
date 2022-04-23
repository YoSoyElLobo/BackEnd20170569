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

    private Character sexo;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais nacionalidad;
    //private tipoDocumento

    private String numeroDocumento;

    private String telefono;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaNacimiento;

    private String documentoConsentimiento;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaConsentimiento;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date fechaRetiro;

    private Boolean enEspera;

    private Boolean aprobado;

    private String motivoRechazo;

    @OneToMany(mappedBy = "usuario")
    private List<Peso> listPeso;

    @OneToMany(mappedBy = "usuario")
    private List<Talla> listTalla;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEnfermedad> listUsuarioEnfermedad;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioFarmaco> listUsuarioFarmaco;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioDeporte> listUsuarioDeporte;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioAlimento> listUsuarioAlimento;

    private Boolean estado = true;



}
