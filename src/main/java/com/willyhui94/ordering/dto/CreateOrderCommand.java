package com.willyhui94.ordering.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateOrderCommand {

    private String stockCode;
    private String stockName;
    private String orderType;
    private String orderCategory;
    private BigDecimal price;
    private Integer quantity;
    private String expiredAt = LocalDate.now().toString();
}
