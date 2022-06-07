package com.springboot.clienteapp.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {

}
