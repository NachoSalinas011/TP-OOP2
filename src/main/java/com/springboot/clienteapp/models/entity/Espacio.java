package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "espacio")
public class Espacio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_espacio;
	private LocalDate fecha;
	private boolean libre;
	private char turno;
	
	@JoinColumn (name = "id_aula")
	private Aula aula;

	public int getId_espacio() {
		return id_espacio;
	}

	public void setId_espacio(int id_espacio) {
		this.id_espacio = id_espacio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Espacio [id_espacio=" + id_espacio + ", fecha=" + fecha + ", libre=" + libre + ", turno=" + turno
				+ ", aula=" + aula + "]";
	}
	
	

}