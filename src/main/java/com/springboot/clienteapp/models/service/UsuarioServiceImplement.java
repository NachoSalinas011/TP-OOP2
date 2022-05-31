package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void agregar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(int id) {
		usuarioRepository.deleteById(id);

	}

	@Override
	public List<Usuario> traerListaUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario traer(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}
