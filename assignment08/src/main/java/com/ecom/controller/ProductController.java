package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDto dto) {
		System.out.println("in add product " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(dto));

		} catch (RuntimeException e) {

			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/{productId}/{userId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId, Long userId) {

		System.out.println("in delete product");

		try {

			return ResponseEntity.ok(productService.deleteProduct(productId, userId));
		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}

}
