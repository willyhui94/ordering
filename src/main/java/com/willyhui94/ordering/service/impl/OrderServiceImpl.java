package com.willyhui94.ordering.service.impl;

import com.willyhui94.ordering.constants.OrderStatus;
import com.willyhui94.ordering.constants.OrderType;
import com.willyhui94.ordering.dto.CancelOrderResponse;
import com.willyhui94.ordering.dto.CreateOrderCommand;
import com.willyhui94.ordering.dto.CreateOrderResponse;
import com.willyhui94.ordering.dto.OrderResponse;
import com.willyhui94.ordering.entity.OrderEntity;
import com.willyhui94.ordering.mapper.OrderDataMapper;
import com.willyhui94.ordering.repository.OrderRepository;
import com.willyhui94.ordering.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderDataMapper orderDataMapper,
                            OrderRepository orderRepository
    ) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderEntity orderEntity = orderDataMapper.toOrderEntity(createOrderCommand);

        if (orderEntity.getOrderType() == OrderType.MARKET_ORDER) {
            orderEntity.setStatus(OrderStatus.EXECUTED);
            orderEntity.setExpiredAt(LocalDateTime.now());
        } else {
            orderEntity.setStatus(OrderStatus.PENDING);
            orderEntity.setExpiredAt(LocalDate.parse(createOrderCommand.getExpiredAt(), formatter).atStartOfDay());
        }
        orderEntity.setOrderedAt(LocalDateTime.now());

        orderRepository.save(orderEntity);
        return CreateOrderResponse.builder().success(true).build();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAllByOrderByOrderedAtDesc();
        return orderEntities.stream().map(orderDataMapper::toOrderResponse).toList();
    }

    @Override
    public CancelOrderResponse cancelOrder(UUID orderId) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(orderId);
        if (orderEntityOptional.isPresent()) {
            OrderEntity orderEntity = orderEntityOptional.get();
            orderEntity.setStatus(OrderStatus.CANCELED);
            orderEntity.setExpiredAt(LocalDateTime.now());
            orderRepository.save(orderEntity);
        }
        return CancelOrderResponse.builder().success(true).build();
    }
}
