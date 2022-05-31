package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.NotaPedido;
import com.springboot.clienteapp.models.repository.NotaPedidoRepository;

@Service
public class NotaPedidoServiceImplements implements INotaPedidoService {

	@Autowired
	private NotaPedidoRepository pedidoRepo;
	
	@Override
	public List<NotaPedido> listaNotas() {
		return (List<NotaPedido>) pedidoRepo.findAll();
	}

	@Override
	public NotaPedido traerNota(int id) {
		return pedidoRepo.findById(id).orElse(null);
	}

}
