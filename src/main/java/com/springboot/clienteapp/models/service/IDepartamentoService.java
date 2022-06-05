package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Departamento;
import com.springboot.clienteapp.models.entity.Perfil;

public interface IDepartamentoService {
	List<Departamento> traerListaDepartamentos();

	public void agregar(Departamento departamento);

	public void eliminar(long id);


	public Departamento traer(long id);
}
