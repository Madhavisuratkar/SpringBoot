package com.programmintechie.order_service.service;

import org.springframework.stereotype.Service;

import com.programmintechie.order_service.dto.OrderRequestDto;
import com.programmintechie.order_service.entity.Order;

@Service
public interface OrderService {

	public void placeOrder(OrderRequestDto orderRequestDto);
}
