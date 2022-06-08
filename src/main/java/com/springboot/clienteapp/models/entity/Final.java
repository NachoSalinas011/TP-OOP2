package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "final")
@PrimaryKeyJoinColumn(name="id_final")
public class Final extends NotaPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDate fecha_examen;
	
	
	public LocalDate getFecha_examen() {
		return fecha_examen;
	}
	public void setFecha_examen(LocalDate fecha_examen) {
		this.fecha_examen = fecha_examen;
	}
	@Override
	public String toString() {
		return "Final [fecha_examen=" + fecha_examen + "]";
	}
	
	
}
