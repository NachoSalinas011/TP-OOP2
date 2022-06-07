package com.springboot.clienteapp.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Final;
import com.springboot.clienteapp.models.entity.Materia;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.IFinalService;
import com.springboot.clienteapp.models.service.IMateriaService;

@Controller
@RequestMapping("/views/pedidos")
public class FinalController {
	
	@Autowired
	private IFinalService finalService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IAulaService aulaService;
	
	@GetMapping("/create")
	public String crear(Model model) {
		Final f = new Final();
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		List<Aula> listaAulas = aulaService.traerListaAulas();
		model.addAttribute("titulo", "Formulario: Nueva nota pedido Final");
		model.addAttribute("final", f);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("aulas", listaAulas);
		return "/views/pedidos/frmCrearFinal";
	}
	
	@PostMapping("/save")
	public String guardarNotaPedido(@Valid @ModelAttribute Final f, BindingResult result, Model model) {
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		List<Aula> listaAulas = aulaService.traerListaAulas();
		
		if(result.hasErrors()) {		
			model.addAttribute("titulo", "Formulario: Nueva nota pedido Final2");
		model.addAttribute("final", f);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("aulas", listaAulas);
		return "/views/pedidos/frmCrearFinal";
		}	
		finalService.agregar(f);
		return "redirect:/views/pedidos/frmCrearFinal";
	}
}
