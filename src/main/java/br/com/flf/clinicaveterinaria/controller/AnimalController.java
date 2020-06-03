package br.com.flf.clinicaveterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flf.clinicaveterinaria.domain.Animal;
import br.com.flf.clinicaveterinaria.service.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<List<Animal>> list() {
		List<Animal> animal = animalService.list();
		
		return ResponseEntity.ok(animal);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> find(@PathVariable Integer id) {
		Animal animal = animalService.find(id);
		
		return ResponseEntity.ok(animal);
	}
}
