package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
@PrimaryKeyJoinColumn(name="id_curso")
public class Curso extends NotaPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod_curso;
	private Set<Date> fecha;
	
	private String getCod_curso() {
		return cod_curso;
	}
	private void setCod_curso(String cod_curso) {
		this.cod_curso = cod_curso;
	}
	private Set<Date> getFechas() {
		return fecha;
	}
	private void setFechas(Set<Date> fechas) {
		this.fecha = fechas;
	}
	@Override
	public String toString() {
		return "Curso [cod_curso=" + cod_curso + ", fecha=" + fecha + "]";
	}
	
	
	
	
}
