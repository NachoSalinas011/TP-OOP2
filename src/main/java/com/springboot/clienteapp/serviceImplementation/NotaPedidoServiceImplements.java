package com.springboot.clienteapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.NotaPedido;
import com.springboot.clienteapp.models.repository.NotaPedidoRepository;
import com.springboot.clienteapp.models.service.INotaPedidoService;

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

	@Override
	public void agregar(NotaPedido notaPedido) {
		pedidoRepo.save(notaPedido);
		
	}

}
