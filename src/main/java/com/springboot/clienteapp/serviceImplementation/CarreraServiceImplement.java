package com.springboot.clienteapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Carrera;
import com.springboot.clienteapp.models.repository.CarreraRepository;
import com.springboot.clienteapp.models.service.ICarreraService;
@Service
public class CarreraServiceImplement implements ICarreraService {

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Override
	public List<Carrera> traerListaCarreras() {
		return (List<Carrera>) carreraRepository.findAll();
	}

	@Override
	public void agregar(Carrera carrera) {
		carreraRepository.save(carrera);

	}

	@Override
	public void eliminar(long id) {
		carreraRepository.deleteById((int)id);

	}

	@Override
	public Carrera traer(long id) {
		return carreraRepository.findById((int)id).orElse(null);
	}

}
