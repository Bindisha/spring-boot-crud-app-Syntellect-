package com.syntellect.service.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.exception.ResourceNotFoundException;
import com.syntellect.service.api.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveProductData(Product product) {
		
		productRepository.save(product);
	}

	@Override
	public Product updateProductData(Product product, long id) {
		productRepository.findById(id).ifPresentOrElse(x->{
			x.setName(product.getName());
			x.setDescription(product.getDescription());
			x.setPrice(product.getPrice());
			productRepository.save(x);
		}, ()-> new ResourceNotFoundException("Product ID not found. ID: "+id));
		log.info("Updated Successfully of ID: ",id);
		 return product;
	}

	@Override
	public List<Product> getAllProductData() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductDataById(long id) {
		log.info("Retrieving Product ased on ID: ", id);
		return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product ID not found. ID: "+id));
		
	}

	@Override
	public Map<String, Boolean> deleteProductDataById(long id) {
		productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product ID not found. ID: "+id));
		productRepository.deleteById(id);
		Map<String, Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		log.info("Product Deleted of ID: ", id);
		return response;
	}
}
