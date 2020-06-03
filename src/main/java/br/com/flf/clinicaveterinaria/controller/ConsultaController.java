package br.com.flf.clinicaveterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flf.clinicaveterinaria.domain.Consulta;
import br.com.flf.clinicaveterinaria.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> list() {
		List<Consulta> consultas = consultaService.list();
		
		return ResponseEntity.ok(consultas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> find(@PathVariable Integer id) {
		Consulta consulta = consultaService.find(id);
		
		return ResponseEntity.ok(consulta);
	}
}
