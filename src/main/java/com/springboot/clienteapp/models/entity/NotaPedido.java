package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota_pedido")
@Inheritance(strategy= InheritanceType.JOINED)
public class NotaPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_nota;
	private Date fecha;
	private char turno;
	private int cant_estudiantes;
	private String observaciones;
	
	@OneToOne
	@JoinColumn(name = "id_materia")
	private Materia materia;

	
	@OneToOne
	@JoinColumn(name = "id_aula")
	private Aula aula;
	
	public NotaPedido () {
		
	}

	public int getId_nota() {
		return id_nota;
	}

	public void setId_nota(int id_nota) {
		this.id_nota = id_nota;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public int getCant_estudiantes() {
		return cant_estudiantes;
	}

	public void setCant_estudiantes(int cant_estudiantes) {
		this.cant_estudiantes = cant_estudiantes;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "NotaPedido [id_nota=" + id_nota + ", turno=" + turno + ", cant_estudiantes=" + cant_estudiantes
				+ ", observaciones=" + observaciones + ", materia=" + materia + ", aula=" + aula + "]";
	}

	

}
