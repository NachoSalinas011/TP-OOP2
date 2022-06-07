package com.springboot.clienteapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IPerfilService;
import com.springboot.clienteapp.models.service.IUsuarioService;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IPerfilService perfilService;
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioService.traerListaUsuarios();		
		
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("usuarios", listaUsuarios);
		
		return "/views/usuarios/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		List<Perfil> listaPerfiles = perfilService.traerListaPerfiles();
		model.addAttribute("titulo", "Formulario: Nuevo Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfiles", listaPerfiles);
		return "/views/usuarios/frmCrear";
	}
	
	@PostMapping("/save")
	public String guardarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		List<Perfil> listaPerfiles = perfilService.traerListaPerfiles();
		if(result.hasErrors()) {		
			model.addAttribute("titulo", "Formulario: Nuevo Usuario");
			model.addAttribute("usuario", usuario);
			model.addAttribute("perfiles", listaPerfiles);
			return "/views/usuarios/frmCrear";
		}	
		usuarioService.agregar(usuario);
		return "redirect:/views/usuarios/";
	}
	
	@GetMapping("/edit/{idUsuario}")
	public String editar(@PathVariable("idUsuario") Long id, Model model) {
		Usuario usuario = usuarioService.traer(id);
		List<Perfil> listaPerfiles = perfilService.traerListaPerfiles();
		model.addAttribute("titulo", "Formulario: Editar Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfiles", listaPerfiles);
		return "/views/usuarios/frmCrear";
	}
	
	@GetMapping("/delete/{idUsuario}")
	public String eliminar(@PathVariable("idUsuario") Long id) {
		usuarioService.eliminar(id);
		
		return "redirect:/views/usuarios/";
	}
}
