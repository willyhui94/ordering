package com.willyhui94.ordering.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CancelOrderResponse {
    private boolean success;
}
