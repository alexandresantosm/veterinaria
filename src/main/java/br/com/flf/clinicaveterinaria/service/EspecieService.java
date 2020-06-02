package br.com.flf.clinicaveterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flf.clinicaveterinaria.domain.Especie;
import br.com.flf.clinicaveterinaria.repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> list() {
		return especieRepository.findAll();
	}
	
	public Especie find(Integer id) {
		return especieRepository.findById(id).get();
	}
}
