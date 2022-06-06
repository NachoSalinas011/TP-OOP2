package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Carrera;

public interface ICarreraService {
	
	
	List<Carrera> traerListaCarreras();

	public void agregar(Carrera carrera);

	public void eliminar(long id);


	public Carrera traer(long id);
}
