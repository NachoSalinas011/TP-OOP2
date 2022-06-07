package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Final;
import com.springboot.clienteapp.models.repository.FinalRepository;

@Service
public class FinalServiceImplement implements IFinalService {
	
	@Autowired
	private FinalRepository finalRepo;
	
	@Override
	public List<Final> listaPedidosFinal() {
		return (List<Final>) finalRepo.findAll();
	}

	@Override
	public Final traerPedidoFinal(int id) {
		return finalRepo.findById(id).orElse(null);
	}

	@Override
	public void agregar(Final pedidoFinal) {
		finalRepo.save(pedidoFinal);

	}

	@Override
	public void eliminar(long id) {
		finalRepo.deleteById((int) id);
		
	}

}
