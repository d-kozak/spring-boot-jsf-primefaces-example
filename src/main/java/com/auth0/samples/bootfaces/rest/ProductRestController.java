package com.auth0.samples.bootfaces.rest;

import com.auth0.samples.bootfaces.Product;
import com.auth0.samples.bootfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping
	public List<Product> all() {
		return productRepository.findAll();
	}
}
