package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "espacio")
public class Espacio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_espacio;
	
	@Column(name = "fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fecha;
	@Column(name = "libre")
	private boolean libre;
	@Column(name = "turno")
	private char turno;
	
	@OneToOne
	@JoinColumn (name = "id_aula")
	private Aula aula;
	
	public Espacio() {
		super();
	}

	
	public Espacio(LocalDate fecha, boolean libre, char turno, Aula aula) {
		super();
		this.fecha = fecha;
		this.libre = libre;
		this.turno = turno;
		this.aula = aula;
	}

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
