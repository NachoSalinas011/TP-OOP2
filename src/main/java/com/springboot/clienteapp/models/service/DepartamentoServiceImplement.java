package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Departamento;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImplement implements IDepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public List<Departamento> traerListaDepartamentos() {
		return (List<Departamento>) departamentoRepository.findAll();
	}

	@Override
	public void agregar(Departamento departamento) {
		departamentoRepository.save(departamento);

	}

	@Override
	public void eliminar(long id) {
		departamentoRepository.deleteById((int)id);

	}

	@Override
	public Departamento traer(long id) {
		return departamentoRepository.findById((int)id).orElse(null);
	}

}
