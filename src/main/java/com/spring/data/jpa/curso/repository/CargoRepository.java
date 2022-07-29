package com.spring.data.jpa.curso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.curso.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long>{
	
	

}
