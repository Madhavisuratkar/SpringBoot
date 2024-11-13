package com.programmingtechie.product_service.serviceImpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.entity.Product;
import com.programmingtechie.product_service.exception.ProductCreationException;
import com.programmingtechie.product_service.exception.ProductNotFoundException;
import com.programmingtechie.product_service.repository.ProductRepository;
import com.programmingtechie.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void createProdcut(ProductRequest productRequest) {
		if (productRequest.getPrice() == null || productRequest.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ProductCreationException("Product price must be greater than zero");
		}
		Product product = new Product();

		product.setName(productRequest.getName());
		product.setDescription(product.getDescription());
		product.setPrice(productRequest.getPrice());
		productRepository.save(product);
		log.info("Product is saved with Id: " + product.getId());

	}

	@Override
	public Product getProductById(Long id) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new ProductNotFoundException("Product is not found with ID : " + id);
		}
		return product.get();
	}

	@Override
	public void deleteProductById(Long id) throws ProductNotFoundException {
		Optional<Product> product =  productRepository.findById(id);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("Product not found with ID : "+id);
		}
		productRepository.delete(product.get());
	}
}
