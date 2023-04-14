package br.edu.univas.tasi.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univas.tasi.prova.entities.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Integer> {
	
	public List<MaterialEntity>findByActive(Boolean active);
}
