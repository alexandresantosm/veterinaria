package br.com.flf.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flf.clinicaveterinaria.domain.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{

}
