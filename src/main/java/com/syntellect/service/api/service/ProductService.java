package com.syntellect.service.api.service;

import com.syntellect.service.api.entity.Product;

public interface ProductService {

	void saveProductData(Product product);

	void updateProductData(Product product, long id);

	void getAllProductData();

	void getProductDataById(long id);

	void deleteProductDataById(long id);

}
