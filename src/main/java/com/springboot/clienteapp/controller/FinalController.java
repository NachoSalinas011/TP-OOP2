package com.springboot.clienteapp.controller;
import java.util.List;
import java.util.Optional;

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
import com.springboot.clienteapp.models.entity.Final;
import com.springboot.clienteapp.models.entity.Materia;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.repository.EspacioRepository;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.IEspacioService;
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
	
	@Autowired
	private IEspacioService espacioService;
	
	@GetMapping("/")
	public String listarPedidosFinal(Model model) {
		List<Final> listaPedidosFinal = finalService.listaPedidosFinal();		
		
		model.addAttribute("titulo", "Lista de pedidos Final");
		model.addAttribute("pedidosFinal", listaPedidosFinal);
		
		return "/views/pedidos/listarSolicitudes";
	}
	
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
		return "/views/pedidos/";
		}	
		finalService.agregar(f);
		return "redirect:/views/pedidos/";
	}
	
	
	@GetMapping("/reserve/{id_nota}")
	public String aceptarSolicitud(@PathVariable("id_nota") int id, Model model) {
		Final f = finalService.traerPedidoFinal(id);
		Espacio e = espacioService.findByFechaAndTurnoAndAula(f.getFecha_examen(), f.getTurno(), f.getAula());
		e.setLibre(false);
		espacioService.agregar(e);
		//finalService.eliminar(id);
		return "redirect:/views/espacios/";
	}
	
	
}
