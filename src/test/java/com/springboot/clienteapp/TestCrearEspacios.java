package com.springboot.clienteapp;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.clienteapp.models.service.IEspacioService;


@SpringBootTest
class TestCrearEspacios {

	
	@Autowired
	private IEspacioService espacioService;
	
	@Test
	void TestCrearEspacio() {
		
		LocalDate fechaInicio = LocalDate.of(2022, 6, 1);
		
		LocalDate fechaFin = LocalDate.of(2022, 7, 10);
		
		espacioService.crearEspacios(fechaInicio, fechaFin);
	}

}