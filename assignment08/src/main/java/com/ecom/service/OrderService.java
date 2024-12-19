package com.ecom.service;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;

public interface OrderService {

	ApiResponse addOrder(OrderReqDTO dto, int quantity);

}
