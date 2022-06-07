package com.springboot.clienteapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IPerfilService;
import com.springboot.clienteapp.models.service.IUsuarioService;


@SpringBootTest
class TestAgregarUsuario {

	@Autowired
	private IPerfilService perfilService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Test
	void TestAgregarUsuario() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		Usuario user = new Usuario();
		
		Perfil rol = perfilService.traer(1);
		
		long idUsuario = 1;
		user.setIdUsuario(idUsuario);
		user.setNombre("Nicolás");
		user.setApellido("Salinas");
		user.setCorreo("nachosalinas@live.com.ar");
		user.setNombreUsuario("nisali");
		user.setPerfil(rol);
		user.setTipoDoc("DNI");
		user.setNroDoc("42284321");
		user.setPassword("1234");
		
		usuarioService.agregar(user);
	}

}

