package br.com.flf.clinicaveterinaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home() {
		return "Olá, seja bem vindo a Clínica Veterinária. Aqui o seu pet terá o melhor tratamento!";
	}
}
