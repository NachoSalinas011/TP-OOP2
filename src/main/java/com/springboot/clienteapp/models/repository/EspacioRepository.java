package com.springboot.clienteapp.models.repository;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Aula;
import com.springboot.clienteapp.models.entity.Espacio;
import com.springboot.clienteapp.models.entity.Usuario;

public interface EspacioRepository extends CrudRepository<Espacio, Integer> {


	Espacio findByFechaAndTurnoAndAula(LocalDate fecha, char turno, Aula aula);
}
