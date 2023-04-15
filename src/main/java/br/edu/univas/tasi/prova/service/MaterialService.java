package br.edu.univas.tasi.prova.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univas.tasi.prova.dto.MaterialDTO;
import br.edu.univas.tasi.prova.entities.MaterialEntity;
import br.edu.univas.tasi.prova.repository.MaterialRepository;
import br.edu.univas.tasi.prova.support.ObjectNotFoundException;


@Service
public class MaterialService {
	
	private MaterialRepository repo;
	
	@Autowired
	public MaterialService(MaterialRepository repo) {
		this.repo = repo;
	}
	
	public MaterialEntity toEntity(MaterialDTO material) {
		return new MaterialEntity(material.getCode(), material.getName(), material.getPrice(),
				material.getProvider(),material.getLastBuy(), true);
	}

	public void createMaterial(MaterialDTO material) {
		repo.save(toEntity(material));
	}
	
	public MaterialEntity findById(Integer code) {
		Optional<MaterialEntity> obj = repo.findById(code);
		MaterialEntity entity = obj.orElseThrow(() -> 
		new ObjectNotFoundException("Product " + code + " not found"));
		return entity;
	}
	
	public MaterialEntity active (Integer id) {
		Optional<MaterialEntity> obj = repo.findById(id);
		MaterialEntity entity = obj.orElseThrow(() -> new RuntimeException());
		entity.setActive(!entity.isActive());
		repo.save(entity);	
		return entity;
	}
}
