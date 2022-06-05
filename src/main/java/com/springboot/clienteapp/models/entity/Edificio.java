package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="edificio")
public class Edificio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_edificio;
	private String edificio;
	
	@OneToMany(mappedBy = "edificio")
	private Set<Aula> aulas;
	
	public Edificio() {
		
	}
	
	public int getId_edificio() {
		return id_edificio;
	}
	public void setId_edificio(int id_edificio) {
		this.id_edificio = id_edificio;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	@Override
	public String toString() {
		return "Edificio [id_edificio=" + id_edificio + ", edificio=" + edificio + "]";
	}
	
	
	
}
