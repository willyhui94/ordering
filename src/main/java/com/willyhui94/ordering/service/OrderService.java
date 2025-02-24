package com.willyhui94.ordering.service;

import com.willyhui94.ordering.dto.CancelOrderResponse;
import com.willyhui94.ordering.dto.CreateOrderCommand;
import com.willyhui94.ordering.dto.CreateOrderResponse;
import com.willyhui94.ordering.dto.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand);

    List<OrderResponse> getAllOrders();

    CancelOrderResponse cancelOrder(UUID orderId);
}
