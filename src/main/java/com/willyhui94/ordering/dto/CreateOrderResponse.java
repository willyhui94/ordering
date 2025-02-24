package com.willyhui94.ordering.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateOrderResponse {
    private boolean success;
}
