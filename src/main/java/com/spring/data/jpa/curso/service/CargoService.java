package com.spring.data.jpa.curso.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.spring.data.jpa.curso.orm.Cargo;
import com.spring.data.jpa.curso.repository.CargoRepository;

@Service
public class CargoService {

	private boolean system = true;
	private CargoRepository cargoRepository;

	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner sc) {
		while (system) {
			System.out.println("Qual acao de cargo deseja executar: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = sc.nextInt();

			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {
		System.out.println("Descricao do cargo: ");
		String descricao = sc.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner sc) {
		System.out.println("ID: ");
		Long id = (long) sc.nextInt();
		System.out.println("Descricao: ");
		String desc = sc.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(desc);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");

	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner sc) {
		System.out.println("ID");
		Long id = sc.nextLong();
		cargoRepository.deleteById(id);
		Cargo cargo = new Cargo();
		System.out.println("Deltado");

	}
}
