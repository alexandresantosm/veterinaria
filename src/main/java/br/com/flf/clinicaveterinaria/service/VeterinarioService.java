package br.com.flf.clinicaveterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flf.clinicaveterinaria.domain.Veterinario;
import br.com.flf.clinicaveterinaria.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	public List<Veterinario> list() {
		return veterinarioRepository.findAll();
	}
	
	public Veterinario find(Integer id) {
		return veterinarioRepository.findById(id).get();
	}
}
