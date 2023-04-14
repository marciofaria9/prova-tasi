package br.edu.univas.tasi.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.edu.univas.tasi.prova.entities.MaterialEntity;
import br.edu.univas.tasi.prova.service.MaterialService;

@RestController
@RequestMapping("/materials")
public class MaterialController {

	@Autowired
	private MaterialService service;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createMaterial(@RequestBody MaterialEntity material) {
		service.createMaterial(material);	
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<MaterialEntity> getProductById(@PathVariable Integer code) {
		MaterialEntity entity = new MaterialEntity();
		entity = service.findById(code);
		return ResponseEntity.ok().body(entity);
		
	}
}
