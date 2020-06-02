package br.com.flf.clinicaveterinaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flf.clinicaveterinaria.domain.Especie;
import br.com.flf.clinicaveterinaria.repository.EspecieRepository;

@SpringBootApplication
public class SistemaClinicaVeterinariaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaClinicaVeterinariaApplication.class, args);
		
		System.out.println("Hello World com Spring Boot!");
	}

	@Autowired
	EspecieRepository especieRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Especie esp1 = new Especie(null, "Felino");
		Especie esp2 = new Especie(null, "Canis");
		
		especieRepository.saveAll(Arrays.asList(esp1,esp2));
	}

}
