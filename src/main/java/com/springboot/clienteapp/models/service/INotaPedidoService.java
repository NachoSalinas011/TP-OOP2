package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.NotaPedido;

public interface INotaPedidoService {

	List<NotaPedido> listaNotas();
	
	public NotaPedido traerNota(int id);
	
	public void agregar(NotaPedido notaPedido);
	
}
