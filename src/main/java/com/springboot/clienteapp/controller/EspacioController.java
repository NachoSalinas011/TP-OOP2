package com.springboot.clienteapp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IEspacioService;
import com.springboot.clienteapp.util.modelDTO;

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
		
		return "views/espacios/listarEspacios";
	}
	
	@GetMapping("/create")
	public String createEspacio(Model model) {
		modelDTO fechas = new modelDTO();
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("titulo", "Formulario: Crear espacios");
		
		return "views/espacios/crearEspacios";
	}

	@PostMapping("/save")
	public String guardarEspacio(@ModelAttribute modelDTO fechas, Model model) {
		System.out.println(fechas.toString());
		return "1";
	}
	
}
