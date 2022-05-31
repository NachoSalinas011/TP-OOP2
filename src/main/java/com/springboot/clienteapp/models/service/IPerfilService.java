package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Perfil;

public interface IPerfilService {
	
	List<Perfil> traerListaPerfiles();

	public void agregar(Perfil perfil);

	public void eliminar(int id);


	public Perfil traer(int id);
}
