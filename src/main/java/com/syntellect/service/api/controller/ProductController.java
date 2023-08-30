package com.syntellect.service.api.controller;

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

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService=productService;
	}
	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product) {
		
		productService.saveProductData(product);
		return "";
	}
	@PutMapping("/product/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable long id) {
		productService.updateProductData(product,id);
		return "";
	}
	@GetMapping("/products")
	public String getAllProducts() {
		productService.getAllProductData();
		return "";
	}
	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable long id) {
		productService.getProductDataById(id);
		return "";
	}
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable long id) {
		productService.deleteProductDataById(id);
		return "";
	}
}
