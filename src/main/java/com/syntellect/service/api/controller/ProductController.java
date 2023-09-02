package com.syntellect.service.api.controller;

import java.util.List;
import java.util.Map;

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

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.entity.ProductDto;
import com.syntellect.service.api.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService=productService;
	}
	@PostMapping 
	public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto product) {
		log.info("Calling save product method...");
		return new ResponseEntity<>(productService.saveProductData(product), HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto product, @PathVariable long id) {
		log.info("Updating Product By ID",id);
		return new ResponseEntity<>(productService.updateProductData(product,id), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<ProductDto> getAllProducts() {
		List<ProductDto> list=productService.getAllProductData();
		log.info("Getting all products ",list.size());
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
		log.info("Calling Product By ID",id);
		return new ResponseEntity<>(productService.getProductDataById(id), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProductById(@PathVariable long id) {
		log.info("Deleting Product By ID",id);
		return new ResponseEntity<>(productService.deleteProductDataById(id),HttpStatus.OK);
	}
}
