package com.syntellect.service.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.syntellect.service.api.entity.Product;
import com.syntellect.service.api.entity.ProductDto;

@Mapper
public interface ProductMapper {
	@Mapping(source = "productId",target = "id")
	@Mapping(source = "productName",target = "name")
	@Mapping(source = "productDescription",target = "description")
	@Mapping(source = "productPrice",target = "price")
	public Product getProductByDto(ProductDto dto);
	
	@Mapping(target = "productId",source = "id")
	@Mapping(target = "productName",source = "name")
	@Mapping(target = "productDescription",source = "description")
	@Mapping(target = "productPrice",source = "price")
	public ProductDto getProductDtoByProduct(Product product);
	
	
	@Mapping(target = "productId",source = "id")
	@Mapping(target = "productName",source = "name")
	@Mapping(target = "productDescription",source = "description")
	@Mapping(target = "productPrice",source = "price")
	public List<ProductDto> getProductDtoListByProductList(List<Product> product);
}
