package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.repository.PerfilRepository;

@Service
public class PerfilServiceImplement implements IPerfilService {

	@Autowired
	private PerfilRepository perfilRepository;


	@Override
	public void agregar(Perfil perfil) {
		perfilRepository.save(perfil);
	}

	@Override
	public void eliminar(long id) {
		perfilRepository.deleteById(id);
	}
	
	@Override
	public List<Perfil> traerListaPerfiles() {
		return (List<Perfil>) perfilRepository.findAll();
	}

	@Override
	public Perfil traer(long id) {
		return perfilRepository.findById(id).orElse(null);
	}

}
