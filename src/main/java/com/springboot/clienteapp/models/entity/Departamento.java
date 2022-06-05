package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_departamento;
	
	@Column(name = "departamento")
	private String departamento_nombre;

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getDepartamento_nombre() {
		return departamento_nombre;
	}

	public void setDepartamento_nombre(String departamento_nombre) {
		this.departamento_nombre = departamento_nombre;
	}

	@Override
	public String toString() {
		return "Departamento [id_departamento=" + id_departamento + ", departamento_nombre=" + departamento_nombre
				+ "]";
	}
	
	

}
