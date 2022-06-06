package com.springboot.clienteapp.models.service;

import java.time.LocalDate;
import java.util.List;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;

public interface IEspacioService {

	List<Espacio> traerListaEspacio();
	
	public Espacio traerEspacio(int id);
	
	public void agregarEspacio (LocalDate fecha, char turno, Aula aula, boolean libre);
	
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula);
	
}