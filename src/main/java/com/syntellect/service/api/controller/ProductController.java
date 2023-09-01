package com.syntellect.service.api.controller;

import java.util.List;

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
	public String updateProduct(@RequestBody Product product, @PathVariable long id) {
		product.setId(id);
		productService.updateProductData(product,id);
		log.info("in");
		return "updated";
	}
	@GetMapping("/products")
	public ResponseEntity<Product> getAllProducts() {
		List<Product> list=productService.getAllProductData();
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable long id) {
		productService.getProductDataById(id);
		return "get by id";
	}
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable long id) {
		productService.deleteProductDataById(id);
		return "deleted";
	}
}
