package com.springboot.clienteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IEspacioService;

@Controller
@RequestMapping("/views/espacios")
public class EspacioController {
	@Autowired
	private IEspacioService espacioService;
	
	@GetMapping("/")
	public String listarPedidosFinal(Model model) {
		List<Espacio> listaEspacios = espacioService.traerListaEspacio();		
		
		model.addAttribute("titulo", "Lista de espacios reservados");
		model.addAttribute("listaEspacios", listaEspacios);
		
		return "/views/espacios/listarEspacios";
	}
	

	
}
