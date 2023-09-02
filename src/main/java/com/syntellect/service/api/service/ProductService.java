package com.syntellect.service.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.entity.ProductDto;

public interface ProductService {

	ProductDto saveProductData(ProductDto product);

	ProductDto updateProductData(ProductDto product, long id);

	List<ProductDto> getAllProductData();

	ProductDto getProductDataById(long id);

	Map<String, Boolean> deleteProductDataById(long id);

}
