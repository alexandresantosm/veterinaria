package br.com.flf.clinicaveterinaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flf.clinicaveterinaria.domain.Animal;
import br.com.flf.clinicaveterinaria.domain.Especie;
import br.com.flf.clinicaveterinaria.domain.Veterinario;
import br.com.flf.clinicaveterinaria.domain.enums.TipoSex;
import br.com.flf.clinicaveterinaria.repository.AnimalRepository;
import br.com.flf.clinicaveterinaria.repository.EspecieRepository;
import br.com.flf.clinicaveterinaria.repository.VeterinarioRepository;

@SpringBootApplication
public class SistemaClinicaVeterinariaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaClinicaVeterinariaApplication.class, args);
		
		System.out.println("Hello World com Spring Boot!");
	}

	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Especie esp1 = new Especie(null, "Felino");
		Especie esp2 = new Especie(null, "Canis");

		especieRepository.saveAll(Arrays.asList(esp1,esp2));
		
		Animal a1 = new Animal(null, "Felix", 3, TipoSex.MACHO, esp1);
		Animal a2 = new Animal(null, "Tico", 2, TipoSex.FÊMEA, esp1);
		Animal a3 = new Animal(null, "Cicarelle", 5, TipoSex.FÊMEA, esp2);
		Animal a4 = new Animal(null, "Junior", 3, TipoSex.MACHO, esp2);
		
		animalRepository.saveAll(Arrays.asList(a1,a2,a3,a4));

		esp1.getAnimais().addAll(Arrays.asList(a1,a2));
		esp2.getAnimais().addAll(Arrays.asList(a3,a4));
		
		
		Veterinario v1 = new Veterinario(null, "Flavio Pinto", "12365654-45");
		Veterinario v2 = new Veterinario(null, "Michel Temer", "9876543-33");
		Veterinario v3 = new Veterinario(null, "Juciel Filho", "3434999-21");
		
		veterinarioRepository.saveAll(Arrays.asList(v1,v2,v3));
	}

}
