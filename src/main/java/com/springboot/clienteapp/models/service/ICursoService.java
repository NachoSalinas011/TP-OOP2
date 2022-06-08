package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Curso;

public interface ICursoService {
	List<Curso> listaPedidosCurso();

	public Curso traerPedidoCurso(int id);

	public void agregar(Curso curso);
	
	public void eliminar(long id);
}
