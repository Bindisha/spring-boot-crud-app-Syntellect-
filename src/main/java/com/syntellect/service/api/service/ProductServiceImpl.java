package com.syntellect.service.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.entity.ProductDto;
import com.syntellect.service.api.exception.ResourceNotFoundException;
import com.syntellect.service.api.mapper.ProductMapper;
import com.syntellect.service.api.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public ProductDto saveProductData(ProductDto productDto) {
		Product product = productMapper.getProductByDto(productDto);
		log.info("Mapping DTO to the Entity");
		return productMapper.getProductDtoByProduct(productRepository.save(product));
	}

	@Override
	public ProductDto updateProductData(ProductDto productDto, long id) {
		Product exitingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Failed to Update Product was not found with id:"+id));

		exitingProduct.setName(productDto.getProductName());
		exitingProduct.setDescription(productDto.getProductDescription());
		exitingProduct.setPrice(productDto.getProductPrice());
		log.info("Mapping DTO to the Entity");
		return productMapper.getProductDtoByProduct(productRepository.save(exitingProduct));
	}

	@Override
	public List<ProductDto> getAllProductData() {
		log.info("Mapping DTO to the Entity");
		return productMapper.getProductDtoListByProductList(productRepository.findAll());
	}

	@Override
	public ProductDto getProductDataById(long id) {
		log.info("Retrieving Product based on ID: ", id);
		return productMapper.getProductDtoByProduct(productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product ID not found. ID: "+id)));

	}

	@Override
	public Map<String, Boolean> deleteProductDataById(long id) {
		productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product was not found with id:"+id));

		Map<String, Boolean> response = new HashMap<>();
		try {
			productRepository.deleteById(id);
			response.put("deleted", Boolean.TRUE);
			log.info("Deleted successfully ",id);
		}
		catch (Exception e) {
			response.put("deleted", Boolean.FALSE);
			log.error("Failed to delete product id ",id);
		}
		return response;
	}

}
