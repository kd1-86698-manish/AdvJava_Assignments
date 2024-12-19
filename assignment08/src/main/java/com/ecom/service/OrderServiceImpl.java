package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.OrdersDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;
import com.ecom.pojos.Orders;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Override
	public ApiResponse addOrder(OrderReqDTO dto, int quantity) {

		User customer = userDao.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("invalid User"));

		Product product = productDao.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Invalid Product Id"));

		Orders order = mapper.map(dto, Orders.class);

		System.out.println(order);
		System.out.println(customer);
		System.out.println(product);

		if (customer.getRole() == UserRole.CUSTOMER && quantity <= product.getQuantity()
				&& product.isStatus() == true) {

			order.setBill(product.getPrice() * quantity);
			order.setUserId(customer);
			order.setProductId(product);
			product.setQuantity(product.getQuantity() - quantity);

			Orders placeOrder = ordersDao.save(order);

			System.out.println(placeOrder);

			return new ApiResponse("order placed");

		}

		return new ApiResponse("FailedTp p;ace Order");
	}
}
