package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.pojos.Product;

public interface ProductService {

	ApiResponse addProduct(ProductDto dto);

	ApiResponse deleteProduct(Long productId, Long userId);

}
