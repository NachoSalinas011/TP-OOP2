package com.springboot.clienteapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.repository.EspacioRepository;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.IEspacioService;
import com.springboot.clienteapp.util.modelDTO;

@Controller
@RequestMapping("/views/espacios")
public class EspacioController {
	@Autowired
	private IEspacioService espacioService;
	@Autowired
	private IAulaService aulaService;
	
	
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
		
		model.addAttribute("titulo", "Formulario: Crear espacios");
		model.addAttribute("fechas", fechas);
		
		
		return "views/espacios/crearEspacios";
	}
	
/*	@GetMapping("/create")
	public String createEspacio(Model model) {
		Espacio espacio = new Espacio();
		
		model.addAttribute("titulo", "Formulario: Crear espacios");
		model.addAttribute("espacio", espacio);
		
		
		return "views/espacios/crearEspacios";
	}*/

	@PostMapping("/save")
	public String guardarEspacio(@ModelAttribute modelDTO fechas, Model model) {
		LocalDate fechaInicio = fechas.getFechaInicio();
		LocalDate fechaFin = fechas.getFechaFin();
		espacioService.crearEspacios(fechaInicio, fechaFin);
		
		return "views/espacios/crearEspacios";
	}
	
/*	@PostMapping("/save")
	public String guardarEspacio(@ModelAttribute Espacio espacio, Model model) {
		List<Aula> listaAulas = aulaService.traerListaAulas();
		espacio.setAula(listaAulas.get(1));
		espacioService.agregar(espacio);
		return "views/espacios/crearEspacios";
	}*/
	
	
	
}
