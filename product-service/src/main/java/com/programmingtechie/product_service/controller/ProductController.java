package com.programmingtechie.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.entity.Product;
import com.programmingtechie.product_service.exception.ProductNotFoundException;
import com.programmingtechie.product_service.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/createProduct")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProdcut(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product Created Successfully.");

	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) throws ProductNotFoundException {
		Product product = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@DeleteMapping("/deleteProductByID/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long id) throws ProductNotFoundException{
		 productService.deleteProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully with ID : "+id);
		
	}

}
