package com.syntellect.service.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService=productService;
	}
	@PostMapping("/product")
	public String saveProduct(@Valid @RequestBody Product product) {
			productService.saveProductData(product);
		return "save";
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id) {
		log.info("Updating Product By ID",id);
		return new ResponseEntity<>(productService.updateProductData(product,id), HttpStatus.OK);
	}
	@GetMapping("/products")
	public ResponseEntity<Product> getAllProducts() {
		List<Product> list=productService.getAllProductData();
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		log.info("Calling Product By ID",id);
		return new ResponseEntity<>(productService.getProductDataById(id), HttpStatus.OK);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProductById(@PathVariable long id) {
		log.info("Deleting Product By ID",id);
		return new ResponseEntity<>(productService.deleteProductDataById(id),HttpStatus.OK);
	}
}
