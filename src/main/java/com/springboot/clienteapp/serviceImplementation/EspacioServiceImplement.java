package com.springboot.clienteapp.serviceImplementation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.repository.EspacioRepository;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.IEspacioService;

@Service
public class EspacioServiceImplement implements IEspacioService {

	@Autowired
	private IAulaService aulaService;
	
	@Autowired
	private EspacioRepository espacioRep;

	@Override
	public List<Espacio> traerListaEspacio() {
		return (List<Espacio>) espacioRep.findAll();
	}

	@Override
	public Espacio traerEspacio(int id) {
		return espacioRep.findById(id).orElse(null);
	}

	public void agregar(Espacio espacio) {
		espacioRep.save(espacio);
		
	}

	public void eliminar(long id) {
		espacioRep.deleteById((int) id);
	}
	
	public void crearEspacios(LocalDate fechaInicio, LocalDate fechaFin) {
		LocalDate fechaAux = fechaInicio;
		char[] turnos = {'M','T','N'}; //Turnos Mañana, Tarde y Noche
		List<Aula> aulas = aulaService.traerListaAulas();
		List<Espacio> lstEspacio = new ArrayList<Espacio>();
		
		while(!fechaAux.isAfter(fechaFin)) {
			for (Aula aula : aulas) {
				for (char c : turnos) { //Todos los días, por cada turno y aula se crea un espacio
					
					Espacio existeEspacio = espacioRep.findByFechaAndTurnoAndAula(fechaAux, c, aula);
					
					if(existeEspacio == null)
					{
						Espacio espacioAgregar = new Espacio(fechaAux, true, c, aula); //Si no existe espacio lo creo
						lstEspacio.add(espacioAgregar);
					}
				}
			}
			fechaAux = fechaAux.plusDays(1);
		}
		
		espacioRep.saveAll(lstEspacio);
	}
	
	public Espacio findByFechaAndTurnoAndAula(LocalDate fecha, char turno, Aula aula){
		return espacioRep.findByFechaAndTurnoAndAula(fecha, turno, aula);
	}
	

}
