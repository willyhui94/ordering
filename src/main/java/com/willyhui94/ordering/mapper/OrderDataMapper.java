package com.willyhui94.ordering.mapper;

import com.willyhui94.ordering.constants.OrderCategory;
import com.willyhui94.ordering.constants.OrderType;
import com.willyhui94.ordering.dto.CreateOrderCommand;
import com.willyhui94.ordering.dto.OrderResponse;
import com.willyhui94.ordering.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderDataMapper {


    public OrderEntity toOrderEntity(CreateOrderCommand createOrderCommand) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStockCode(createOrderCommand.getStockCode());
        orderEntity.setStockName(createOrderCommand.getStockName());
        orderEntity.setOrderType(OrderType.valueOf(createOrderCommand.getOrderType()));
        orderEntity.setOrderCategory(OrderCategory.valueOf(createOrderCommand.getOrderCategory()));
        orderEntity.setPrice(createOrderCommand.getPrice());
        orderEntity.setQuantity(createOrderCommand.getQuantity());
        return orderEntity;
    }

    public OrderResponse toOrderResponse(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .stockCode(orderEntity.getStockCode())
                .stockName(orderEntity.getStockName())
                .orderType(orderEntity.getOrderType())
                .orderCategory(orderEntity.getOrderCategory())
                .price(orderEntity.getPrice())
                .quantity(orderEntity.getQuantity())
                .status(orderEntity.getStatus())
                .orderedAt(orderEntity.getOrderedAt())
                .executedAt(orderEntity.getExecutedAt())
                .expiredAt(orderEntity.getExpiredAt())
                .build();
    }
}
