package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Curso;
import com.springboot.clienteapp.models.repository.CursoRepository;

@Service
public class CursoServiceImplement implements ICursoService {
	
	@Autowired
	private CursoRepository cursoRepo;
	
	@Override
	public List<Curso> listaPedidosCurso() {
		return (List<Curso>) cursoRepo.findAll();
	}

	@Override
	public Curso traerPedidoCurso(int id) {
		return cursoRepo.findById(id).orElse(null);
	}

	@Override
	public void agregar(Curso curso) {
		cursoRepo.save(curso);

	}

}
