package com.back.tesis.model;

import com.back.tesis.dto.UsuarioDatosGeneralesDTO;
import com.back.tesis.dto.UsuarioRetiroDTO;
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

    public void copyUsuario (Usuario usuario){
        if (usuario.getRol() != null && usuario.getRol().getIdRol() != 0) setRol(usuario.getRol());
        if (usuario.getNombres() != null) setNombres(usuario.getNombres());
        if (usuario.getApellidos() != null) setApellidos(usuario.getApellidos());
        if (usuario.getCorreoElectronico() != null) setCorreoElectronico(usuario.getCorreoElectronico());
        if (usuario.getSexo() != null) setSexo(usuario.getSexo());
        if (usuario.getNacionalidad() != null && usuario.getNacionalidad().getIdPais() != 0)  setNacionalidad(usuario.getNacionalidad());
        if (usuario.getNumeroDocumento() != null) setNumeroDocumento(usuario.getNumeroDocumento());
        if (usuario.getTelefono() != null) setTelefono(usuario.getTelefono());
        if (usuario.getFechaNacimiento() != null) setFechaNacimiento(usuario.getFechaNacimiento());
        if (usuario.getDocumentoConsentimiento() != null) setDocumentoConsentimiento(usuario.getDocumentoConsentimiento());
        if (usuario.getFechaConsentimiento() != null) setFechaConsentimiento(usuario.getFechaConsentimiento());
        if (usuario.getFechaRetiro() != null) setFechaRetiro(usuario.getFechaRetiro());
        if (usuario.getEnEspera() != null) setEnEspera(usuario.getEnEspera());
        if (usuario.getAprobado() != null) setAprobado(usuario.getAprobado());
        if (usuario.getMotivoRechazo() != null) setMotivoRechazo(usuario.getMotivoRechazo());
    }

    public void copyUsuario (UsuarioDatosGeneralesDTO usuario){
        if (usuario.getCorreoElectronico() != null) setCorreoElectronico(usuario.getCorreoElectronico());
        if (usuario.getSexo() != null) setSexo(usuario.getSexo());
        if (usuario.getTelefono() != null) setTelefono(usuario.getTelefono());
        if (usuario.getFechaNacimiento() != null) setFechaNacimiento(usuario.getFechaNacimiento());
    }

    public void copyUsuario (UsuarioRetiroDTO usuario){
        if (usuario.getMotivoRechazo() != null) setMotivoRechazo(usuario.getMotivoRechazo());
    }

}
