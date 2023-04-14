package br.edu.univas.tasi.prova.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univas.tasi.prova.entities.MaterialEntity;
import br.edu.univas.tasi.prova.repository.MaterialRepository;


@Service
public class MaterialService {
	
	private MaterialRepository repo;
	
	@Autowired
	public MaterialService(MaterialRepository repo) {
		this.repo = repo;
	}

	public void createMaterial(MaterialEntity material) {
		repo.save(material);
	}
	
	public MaterialEntity findById(Integer code) {
		Optional<MaterialEntity> obj = repo.findById(code);
		MaterialEntity entity = obj.get();
		return entity;
	} 
	
}
