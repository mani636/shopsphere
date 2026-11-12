package com.shopsphere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopsphere.entity.Product;
import com.shopsphere.exception.ResourceNotFoundException;
import com.shopsphere.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repo;

	public Product create(Product p) {
		return repo.save(p);
	}

	public List<Product> getAll() {
		return repo.findAll();
	}

	public Product getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
	}

	public Product update(Long id, Product updated) {
		Product p = getById(id);
		p.setName(updated.getName());
		p.setDescription(updated.getDescription());
		p.setPrice(updated.getPrice());
		p.setStock(updated.getStock());
		return repo.save(p);
	}

	public void delete(Long id) {
		repo.delete(getById(id));
	}
}