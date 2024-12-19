package com.ecom.controller;

import java.util.List;

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

import com.ecom.dto.UserReqDto;
import com.ecom.pojos.Product;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@PostMapping()
	public ResponseEntity<?> addUser(@RequestBody UserReqDto userDto) {
		System.out.println("in add user" + userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userDto));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllProducts(@PathVariable Long userId) {
		System.out.println("get all Products");

		List<Product> products = userService.findByStatusTrue(userId);

		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	return ResponseEntity.ok(products);
	}

}
