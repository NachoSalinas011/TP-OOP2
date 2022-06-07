package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Final;

public interface IFinalService {
	List<Final> listaPedidosFinal();

	public Final traerPedidoFinal(int id);

	public void agregar(Final pedidoFinal);
	
	public void eliminar(long id);
}
