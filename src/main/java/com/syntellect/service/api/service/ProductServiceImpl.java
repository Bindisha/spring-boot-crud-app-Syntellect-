package com.syntellect.service.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	/*
	 * @Autowired private ProductRepository productRepository;
	 */
	@Override
	public void saveProductData(Product product) {
		
		
	}

	@Override
	public void updateProductData(Product product, long id) {
		
	}

	@Override
	public void getAllProductData() {
		
	}

	@Override
	public void getProductDataById(long id) {
		
	}

	@Override
	public void deleteProductDataById(long id) {
		
	}
}
