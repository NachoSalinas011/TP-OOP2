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

import com.springboot.clienteapp.models.entity.Carrera;
import com.springboot.clienteapp.models.entity.Materia;
import com.springboot.clienteapp.models.entity.NotaPedido;

import com.springboot.clienteapp.models.service.ICarreraService;
import com.springboot.clienteapp.models.service.IMateriaService;
import com.springboot.clienteapp.models.service.INotaPedidoService;

@Controller
@RequestMapping("/views/pedidos")
public class NotaPedidoController {
	
	@Autowired
	private INotaPedidoService NotaPedidoService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/create")
	public String crear(Model model) {
		NotaPedido notaPedido = new NotaPedido();
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		List<Carrera> listaCarreras = carreraService.traerListaCarreras();
		model.addAttribute("titulo", "Formulario: Nueva nota pedido");
		model.addAttribute("notaPedido", notaPedido);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("carreras", listaCarreras);
		return "/views/pedidos/frmCrearPedido";
	}
	
	@PostMapping("/save")
	public String guardarNotaPedido(@Valid @ModelAttribute NotaPedido notaPedido, BindingResult result, Model model) {
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		if(result.hasErrors()) {		
			model.addAttribute("titulo", "Formulario: Nueva nota pedido");
			model.addAttribute("notaPedido", notaPedido);
			model.addAttribute("materias", listaMaterias);
			return "/views/pedidos/frmCrearPedido";
		}	
		NotaPedidoService.agregar(notaPedido);
		return "redirect:/views/pedidos/";
	}
}
