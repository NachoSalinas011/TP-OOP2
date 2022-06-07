package com.springboot.clienteapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.service.IAulaService;
import com.springboot.clienteapp.models.service.IUsuarioService;

@SpringBootTest
class SpringbootClienteappApplicationTests {

	@Autowired
	private IAulaService aulaService;
	
	@Test
	void contextLoads() {
		
		Aula aula = aulaService.traerAula(1);
		
		System.out.println(aula.toString());
	}

}
