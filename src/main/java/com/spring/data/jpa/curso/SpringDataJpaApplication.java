package com.spring.data.jpa.curso;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.data.jpa.curso.orm.Cargo;
import com.spring.data.jpa.curso.repository.CargoRepository;
import com.spring.data.jpa.curso.service.CargoService;
import com.spring.data.jpa.curso.service.FuncionarioService;
import com.spring.data.jpa.curso.service.RelatorioService;
import com.spring.data.jpa.curso.service.UnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private final CargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatorioService relatorioService;
	private boolean system = true;

	public SpringDataJpaApplication(CargoService cargoService, FuncionarioService funcionarioService,
			UnidadeTrabalhoService unidadeTrabalhoService, RelatorioService relatorioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatorios");

			int action = sc.nextInt();

			switch (action) {
			case 1: 
				cargoService.inicial(sc);
				break;
			case 2:
				funcionarioService.inicial(sc);
				break;
			case 3:
				unidadeTrabalhoService.inicial(sc);
				break;
			case 4:
				
			default:
				break;
			}

		}
	}
}
