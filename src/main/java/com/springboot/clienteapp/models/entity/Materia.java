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
@Table (name = "materia")
public class Materia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cod_materia;
	
	@Column (name = "materia")
	private String materia_nombre;
	private String profesor;
	
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	public String getCod_materia() {
		return cod_materia;
	}

	public void setCod_materia(String cod_materia) {
		this.cod_materia = cod_materia;
	}

	public String getMateria_nombre() {
		return materia_nombre;
	}

	public void setMateria_nombre(String materia_nombre) {
		this.materia_nombre = materia_nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Materia [cod_materia=" + cod_materia + ", materia_nombre=" + materia_nombre + ", profesor=" + profesor
				+ ", carrera=" + carrera + "]";
	}
	
	
}
