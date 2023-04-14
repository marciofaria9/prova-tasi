package br.edu.univas.tasi.prova.service;


import org.springframework.beans.factory.annotation.Autowired;


import br.edu.univas.tasi.prova.entities.MaterialEntity;
import br.edu.univas.tasi.prova.repository.MaterialRepository;

public class MaterialService {
	
	private MaterialRepository repo;
	
	@Autowired
	public MaterialService(MaterialRepository repo) {
		this.repo = repo;
	}

	public void createProduct(MaterialEntity material) {
		repo.save(material);
	}
}
