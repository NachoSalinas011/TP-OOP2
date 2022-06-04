package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	@NotBlank
	@Column(name = "apellido")
	private String apellido;
	@NotBlank
	@Column(name = "tipo_doc")
	private String tipoDoc;
	@NotBlank
	@Column(name = "nro_doc")
	private String nroDoc;
	@NotBlank
	@Email
	@Column(name = "correo")
	private String correo;
	@NotBlank
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	@NotBlank
	@Column(name = "password")
	private String password;
	@Column(name = "baja")
	private boolean baja;

	@OneToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	// _____________________________________________________________

	public Usuario() {
		super();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc="
				+ tipoDoc + ", nroDoc=" + nroDoc + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario
				+ ", password=" + password + ", baja=" + baja + ", perfil=" + perfil + "]";
	}

}
