package com.programmingtechie.product_service.service;

import org.springframework.stereotype.Service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.entity.Product;
import com.programmingtechie.product_service.exception.ProductNotFoundException;

@Service
public interface ProductService {
	
	public void createProdcut(ProductRequest productRequest);
	
	public Product getProductById(Long id) throws ProductNotFoundException;
	
	public void deleteProductById(Long id) throws ProductNotFoundException ;

}
