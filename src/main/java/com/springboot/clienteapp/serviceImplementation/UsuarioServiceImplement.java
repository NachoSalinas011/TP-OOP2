package com.springboot.clienteapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.repository.UsuarioRepository;
import com.springboot.clienteapp.models.service.IUsuarioService;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void agregar(Usuario usuario) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder(); //encodeo de password
		usuario.setPassword(pe.encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(long id) {
		usuarioRepository.deleteById(id);

	}

	@Override
	public List<Usuario> traerListaUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario traer(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario findByCorreo(String correo) {
		return usuarioRepository.findByCorreo(correo);
	}

}
