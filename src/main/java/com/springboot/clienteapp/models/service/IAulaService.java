package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Aula;

public interface IAulaService {

	List<Aula> traerListaAulas();
	
	public Aula traerAula(int id);
	
	
}
