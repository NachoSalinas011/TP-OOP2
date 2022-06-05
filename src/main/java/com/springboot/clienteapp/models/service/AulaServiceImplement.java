package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.repository.AulaRepository;

@Service
public class AulaServiceImplement implements IAulaService {

	@Autowired
	private AulaRepository aulaRep;
	
	@Override
	public List<Aula> traerListaAulas() {
		return (List<Aula>) aulaRep.findAll();
	}

	@Override
	public Aula traerAula(int id) {
		return aulaRep.findById(id).orElse(null);
	}

}
