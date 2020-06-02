package br.com.flf.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flf.clinicaveterinaria.domain.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer>{

}
