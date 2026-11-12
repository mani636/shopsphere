package com.shopsphere.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopsphere.entity.Product;
import com.shopsphere.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(p));
	}

	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Product getOne(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product p) {
		return service.update(id, p);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}