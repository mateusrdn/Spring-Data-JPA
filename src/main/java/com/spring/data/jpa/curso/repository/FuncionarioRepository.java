package com.spring.data.jpa.curso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.data.jpa.curso.orm.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
	
	List<Funcionario> findByNome(String nome);

}
