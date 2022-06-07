package com.springboot.clienteapp.models.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.repository.EspacioRepository;

@Service
public class EspacioServiceImplement implements IEspacioService {

	@Autowired
	private EspacioRepository espacioRep;

	@Override
	public List<Espacio> traerListaEspacio() {
		return (List<Espacio>) espacioRep.findAll();
	}

	@Override
	public Espacio traerEspacio(int id) {
		return espacioRep.findById(id).orElse(null);
	}

	public void agregar(Espacio espacio) {
		espacioRep.save(espacio);
		
	}

	public void eliminar(long id) {
		espacioRep.deleteById((int) id);
	}

	/*
	 * @Override public void agregarEspacio(LocalDate fecha, char turno, Aula aula,
	 * boolean libre) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void agregarEspacioMes(int mes, int anio, char turno, Aula
	 * aula) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
