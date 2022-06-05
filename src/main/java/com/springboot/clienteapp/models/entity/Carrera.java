package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_carrera;
	
	@Column(name = "carrera")
	private String carrera_nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getCarrera_nombre() {
		return carrera_nombre;
	}

	public void setCarrera_nombre(String carrera_nombre) {
		this.carrera_nombre = carrera_nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", carrera_nombre=" + carrera_nombre + ", departamento="
				+ departamento + "]";
	}

	
	
}
