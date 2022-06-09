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
		Usuario admin = new Usuario();
		
		Perfil rolAdmin = perfilService.traer(1);
		Perfil rolUser = perfilService.traer(2);
		
		long idUser = 1;
		long idAdmin = 2;
		
		user.setIdUsuario(idUser);
		user.setNombre("Nacho");
		user.setApellido("Salinas");
		user.setCorreo("user@user.com");
		user.setNombreUsuario("user");
		user.setPerfil(rolUser);
		user.setTipoDoc("DNI");
		user.setNroDoc("42284321");	
		user.setPassword("user");
		
		admin.setIdUsuario(idAdmin);
		admin.setNombre("Vanina");
		admin.setApellido("Acosta");
		admin.setCorreo("admin@admin.com");
		admin.setNombreUsuario("admin");
		admin.setPerfil(rolAdmin);
		admin.setTipoDoc("DNI");
		admin.setNroDoc("26200863");
		admin.setPassword("admin");
		
		usuarioService.agregar(user);
		usuarioService.agregar(admin);

	}

}

