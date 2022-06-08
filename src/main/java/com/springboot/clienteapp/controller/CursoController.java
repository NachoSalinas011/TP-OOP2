package com.springboot.clienteapp.controller;

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
import com.springboot.clienteapp.models.entity.Curso;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Final;
import com.springboot.clienteapp.models.entity.Materia;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.ICursoService;
import com.springboot.clienteapp.models.service.IEspacioService;
import com.springboot.clienteapp.models.service.IMateriaService;

@Controller
@RequestMapping("/views/pedidosCurso")
public class CursoController {
	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IAulaService aulaService;
	
	@Autowired
	private IEspacioService espacioService;
	
	@GetMapping("/")
	public String listarPedidosFinal(Model model) {
		List<Curso> listaPedidosCurso = cursoService.listaPedidosCurso();		
		
		model.addAttribute("titulo", "Lista de pedidos Curso");
		model.addAttribute("pedidosCurso", listaPedidosCurso);
		
		return "/views/pedidos/listarSolicitudesCurso";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		Curso c = new Curso();
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		List<Aula> listaAulas = aulaService.traerListaAulas();
		model.addAttribute("titulo", "Formulario: Nueva nota pedido Curso");
		model.addAttribute("curso", c);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("aulas", listaAulas);
		return "/views/pedidos/frmCrearCurso";
	}
	
	@PostMapping("/save")
	public String guardarNotaPedido(@Valid @ModelAttribute Curso c, BindingResult result, Model model) {
		List<Materia> listaMaterias = materiaService.traerListaMaterias();
		List<Aula> listaAulas = aulaService.traerListaAulas();
		
		if(result.hasErrors()) {		
			model.addAttribute("titulo", "Formulario: Nueva nota pedido Curso");
			model.addAttribute("curso", c);
			model.addAttribute("materias", listaMaterias);
			model.addAttribute("aulas", listaAulas);
			return "/views/pedidosCurso/";
		}	
		cursoService.agregar(c);
		return "redirect:/views/pedidosCurso/";

	}
	
	@GetMapping("/reserve/{id_nota}")
	public String aceptarSolicitud(@PathVariable("id_nota") int id, Model model) {
		Curso c = cursoService.traerPedidoCurso(id);
		Espacio e = espacioService.findByFechaAndTurnoAndAula(c.getFecha(), c.getTurno(), c.getAula());
		e.setLibre(false);
		espacioService.agregar(e);
		//cursoService.eliminar(id);
		return "redirect:/views/espacios/";
	}
}