package br.com.flf.clinicaveterinaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flf.clinicaveterinaria.domain.Animal;
import br.com.flf.clinicaveterinaria.domain.Cliente;
import br.com.flf.clinicaveterinaria.domain.Consulta;
import br.com.flf.clinicaveterinaria.domain.Especie;
import br.com.flf.clinicaveterinaria.domain.Veterinario;
import br.com.flf.clinicaveterinaria.domain.enums.TipoSex;
import br.com.flf.clinicaveterinaria.repository.AnimalRepository;
import br.com.flf.clinicaveterinaria.repository.ClienteRepository;
import br.com.flf.clinicaveterinaria.repository.ConsultaRepository;
import br.com.flf.clinicaveterinaria.repository.EspecieRepository;
import br.com.flf.clinicaveterinaria.repository.VeterinarioRepository;
import br.com.flf.clinicaveterinaria.utils.FormataDataHora;

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
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Especie esp1 = new Especie(null, "Felino");
		Especie esp2 = new Especie(null, "Canis");
		
		especieRepository.saveAll(Arrays.asList(esp1,esp2));

		Cliente c1 = new Cliente(null, "Jucileudo Arantes", "Rua 13 de maio, Bela Vista, 51", "3482-5677", "juju@gmail.com");
		Cliente c2 = new Cliente(null, "Carmelita Donca", "Av. General Sampaio, Centro, 101", "3252-1258", "kaka@gmail.com");

		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
		Animal a1 = new Animal(null, "Felix", 3, TipoSex.MACHO, esp1, c1);
		Animal a2 = new Animal(null, "Tico", 2, TipoSex.FÊMEA, esp1, c1);
		Animal a3 = new Animal(null, "Cicarelle", 5, TipoSex.FÊMEA, esp2, c2);
		Animal a4 = new Animal(null, "Junior", 3, TipoSex.MACHO, esp2, c2);
		
		c1.getPets().addAll(Arrays.asList(a1,a2));
		c2.getPets().addAll(Arrays.asList(a3,a4));
		
		animalRepository.saveAll(Arrays.asList(a1,a2,a3,a4));

		esp1.getAnimais().addAll(Arrays.asList(a1,a2));
		esp2.getAnimais().addAll(Arrays.asList(a3,a4));
		
		Veterinario v1 = new Veterinario(null, "Flavio Pinto", "12365654-45");
		Veterinario v2 = new Veterinario(null, "Michel Temer", "9876543-33");
		Veterinario v3 = new Veterinario(null, "Juciel Filho", "3434999-21");
		
		veterinarioRepository.saveAll(Arrays.asList(v1,v2,v3));
		
		Consulta con1 = new Consulta(null, new FormataDataHora("05/05/2020 13:45").converteDataHora(), "Av. Rui Barbosa, 100, Aldeota", "Exame urina", a1, v1);
		Consulta con2 = new Consulta(null, new FormataDataHora("05/12/2019 10:45").converteDataHora(), "Av. Rui Barbosa, 100, Aldeota", "Raio-X tórax", a2, v1);
		Consulta con3 = new Consulta(null, new FormataDataHora("25/05/2020 09:45").converteDataHora(), "Av. Rui Barbosa, 100, Aldeota", "Vacina gripe", a3, v2);
		Consulta con4 = new Consulta(null, new FormataDataHora("05/11/2018 14:45").converteDataHora(), "Av. Rui Barbosa, 100, Aldeota", "Cirurgia rabo", a4, v3);
		
		consultaRepository.saveAll(Arrays.asList(con1,con2,con3,con4));
	}

}
