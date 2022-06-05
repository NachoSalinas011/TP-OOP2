package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Departamento;
import com.springboot.clienteapp.models.entity.Materia;
import com.springboot.clienteapp.models.repository.DepartamentoRepository;
import com.springboot.clienteapp.models.repository.MateriaRepository;

@Service
public class MateriaServiceImplement implements IMateriaService {
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	public List<Materia> traerListaMaterias() {
		return (List<Materia>) materiaRepository.findAll();
	}

	@Override
	public void agregar(Materia materia) {
		materiaRepository.save(materia);
	}

	@Override
	public void eliminar(long id) {
		materiaRepository.deleteById((int)id);

	}

	@Override
	public Materia traer(long id) {
		return materiaRepository.findById((int)id).orElse(null);
	}

}
