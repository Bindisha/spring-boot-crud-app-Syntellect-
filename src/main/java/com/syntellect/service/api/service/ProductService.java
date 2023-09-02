package com.syntellect.service.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.syntellect.service.api.entity.Product;

public interface ProductService {

	void saveProductData(Product product);

	Product updateProductData(Product product, long id);

	List<Product> getAllProductData();

	Product getProductDataById(long id);

	Map<String, Boolean> deleteProductDataById(long id);

}
