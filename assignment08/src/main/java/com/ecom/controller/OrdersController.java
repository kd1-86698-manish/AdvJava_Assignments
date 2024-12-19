package com.ecom.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;
import com.ecom.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/{quantity}")
	public ResponseEntity<?> addOrders(@RequestBody OrderReqDTO dto, @PathVariable int quantity) {

		System.out.println("in add Orders" + dto);

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(dto, quantity));

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
