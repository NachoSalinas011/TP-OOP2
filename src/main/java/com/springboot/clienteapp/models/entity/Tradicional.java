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
@PrimaryKeyJoinColumn(name="id_tradicional")
public class Tradicional extends Aula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cant_bancos;
	private String pizarron;
	private boolean tiene_proyector;
	
	public int getCant_bancos() {
		return cant_bancos;
	}
	public void setCant_bancos(int cant_bancos) {
		this.cant_bancos = cant_bancos;
	}
	public String getPizarron() {
		return pizarron;
	}
	public void setPizarron(String pizarron) {
		this.pizarron = pizarron;
	}
	public boolean isTiene_proyector() {
		return tiene_proyector;
	}
	public void setTiene_proyector(boolean tiene_proyector) {
		this.tiene_proyector = tiene_proyector;
	}
	
	@Override
	public String toString() {
		return "Tradicional [cant_bancos=" + cant_bancos + ", pizarron=" + pizarron + ", tiene_proyector="
				+ tiene_proyector + "]";
	}
	
	
	
}
