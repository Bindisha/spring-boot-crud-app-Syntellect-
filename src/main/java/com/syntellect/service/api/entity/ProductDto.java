package com.syntellect.service.api.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
private Long productId;
	
	@NotEmpty
	@NotNull
	private String productName;
	
	@NotEmpty
	@Size(min=8,max=30, message = "description should have at max 30 characters")
	private String productDescription;
	
	@NotNull
	@Positive
	private Double productPrice;
}
