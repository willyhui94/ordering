package com.willyhui94.ordering.entity;

import com.willyhui94.ordering.constants.OrderCategory;
import com.willyhui94.ordering.constants.OrderStatus;
import com.willyhui94.ordering.constants.OrderType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "tb_order")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    private String stockCode;

    private String stockName;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private OrderCategory orderCategory;

    private BigDecimal price;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime orderedAt;
    private LocalDateTime executedAt;
    private LocalDateTime expiredAt;
}
