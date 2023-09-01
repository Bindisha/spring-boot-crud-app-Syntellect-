package com.syntellect.service.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveProductData(Product product) {
		
		productRepository.save(product);
	}

	@Override
	public void updateProductData(Product product, long id) {
		 if(productRepository.findById(id).isPresent()) {
			product.setDescription(product.getDescription());
			product.setName(product.getName());
			productRepository.save(product);
		 }
	}

	@Override
	public List<Product> getAllProductData() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductDataById(long id) {
		Optional<Product> findById = productRepository.findById(id);
		return findById.get();
	}

	@Override
	public void deleteProductDataById(long id) {
		productRepository.deleteById(id);
	}
}
