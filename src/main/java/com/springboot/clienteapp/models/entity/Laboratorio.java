package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_laboratorio")
public class Laboratorio extends Aula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cant_PC;
	private int cant_sillas;
	
	public int getCant_PC() {
		return cant_PC;
	}
	public void setCant_PC(int cant_PC) {
		this.cant_PC = cant_PC;
	}
	public int getCant_sillas() {
		return cant_sillas;
	}
	public void setCant_sillas(int cant_sillas) {
		this.cant_sillas = cant_sillas;
	}
	@Override
	public String toString() {
		return "Laboratorio [cant_PC=" + cant_PC + ", cant_sillas=" + cant_sillas + "]";
	}
	
	
	

}
