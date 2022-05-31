package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Usuario;

public interface IUsuarioService {
	
	
	public void agregar(Usuario usuario);
	
	public void eliminar(int id);
	
	public List<Usuario> traerListaUsuarios();
	
	public Usuario traer(int id);
	
}
