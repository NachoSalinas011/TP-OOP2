package com.springboot.clienteapp.models.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Usuario;

public interface IEspacioService {

	List<Espacio> traerListaEspacio();
	
	public Espacio traerEspacio(int id);
	
	public void agregar(Espacio e);
	
	public void eliminar(long id);
	
	public void crearEspacios(LocalDate fechaInicio, LocalDate fechaFin);
	/*
	 * public void agregarEspacio (LocalDate fecha, char turno, Aula aula, boolean
	 * libre);
	 * 
	 * public void agregarEspacioMes(int mes, int anio, char turno, Aula aula);
	 */
	Espacio findByFechaAndTurnoAndAula(LocalDate fecha, char turno, Aula aula);
	
	//public void reservarEspacio(Espacio espacio);
}
