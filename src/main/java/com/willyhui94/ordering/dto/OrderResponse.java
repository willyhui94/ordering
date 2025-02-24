package com.willyhui94.ordering.dto;

import com.willyhui94.ordering.constants.OrderCategory;
import com.willyhui94.ordering.constants.OrderStatus;
import com.willyhui94.ordering.constants.OrderType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {

  private UUID id;
  private String stockCode;
  private String stockName;
  private OrderType orderType;
  private OrderCategory orderCategory;
  private BigDecimal price;
  private Integer quantity;
  private OrderStatus status;
  private LocalDateTime orderedAt;
  private LocalDateTime executedAt;
  private LocalDateTime expiredAt;
}
