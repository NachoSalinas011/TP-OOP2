package com.springboot.clienteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IUsuarioService;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioService.traerListaUsuarios();
		
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("usuarios", listaUsuarios);
		
		return "/views/usuarios/listar";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "/views/usuarios/frmCrear";
	}
}
