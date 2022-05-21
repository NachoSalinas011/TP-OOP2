package com.springboot.clienteapp.controller;

import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/perfiles")
public class PerfilController {

    @Autowired
    private IPerfilService perfilService;

    @GetMapping("/")
    public String listaPerfiles(Model model){
        List<Perfil> listaPerfiles = perfilService.traerListaPerfiles();

        model.addAttribute("tituloPerfil", "Lista de perfiles");
        model.addAttribute("perfiles", listaPerfiles);

        return "/views/perfiles/listarPerfil";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Perfil perfil = new Perfil();

        model.addAttribute("titulo", "Formulario: Nuevo Perfil");
        model.addAttribute("perfil", perfil);

        return "/views/perfiles/frmCrearPerfil";
    }

    @PostMapping("/save")
    public String guardarPerfil(@ModelAttribute Perfil perfil) {
        perfilService.agregar(perfil);
        return "redirect:/views/perfiles/";
    }
}
