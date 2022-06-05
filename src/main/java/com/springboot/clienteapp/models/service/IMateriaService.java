package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Materia;

public interface IMateriaService {
	List<Materia> traerListaMaterias();

	public void agregar(Materia materia);

	public void eliminar(long id);


	public Materia traer(long id);
}
