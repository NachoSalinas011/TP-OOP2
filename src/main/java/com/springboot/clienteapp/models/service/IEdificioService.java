package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Edificio;

public interface IEdificioService {
	
	List<Edificio> traerListEdificio();
	
	public Edificio traerEdificio(int id);
	
	public Edificio traerEdificioConAulas(int id);
	
	
}
