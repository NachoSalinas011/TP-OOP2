package com.springboot.clienteapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Edificio;
import com.springboot.clienteapp.models.repository.EdificioRepository;
import com.springboot.clienteapp.models.service.IEdificioService;

@Service
public class EdificioServiceImplement implements IEdificioService {

	@Autowired
	private EdificioRepository edificioRep;
	
	@Override
	public List<Edificio> traerListEdificio() {
		return (List<Edificio>) edificioRep.findAll();
	}

	@Override
	public Edificio traerEdificio(int id) {
		return edificioRep.findById(id).orElse(null);
	}

	@Override
	public Edificio traerEdificioConAulas(int id) {
		return null;
	}

}
