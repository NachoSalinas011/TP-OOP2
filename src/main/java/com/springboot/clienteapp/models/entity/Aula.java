package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "aula")
@Inheritance(strategy = InheritanceType.JOINED) //herencia clase padre
public class Aula implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_aula;
	private int numero;
	
	@ManyToOne
	@JoinColumn(name = "id_edificio")
	private Edificio edificio;
	
	public Aula ()
	{
		
	}

	public int getId_aula() {
		return id_aula;
	}

	public void setId_aula(int id_aula) {
		this.id_aula = id_aula;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Aula [id_aula=" + id_aula + ", numero=" + numero + ", edificio=" + edificio + "]";
	}
	
	
	
}
