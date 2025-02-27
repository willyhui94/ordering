package com.willyhui94.ordering.controller;

import com.willyhui94.ordering.dto.CancelOrderResponse;
import com.willyhui94.ordering.dto.CreateOrderCommand;
import com.willyhui94.ordering.dto.CreateOrderResponse;
import com.willyhui94.ordering.dto.OrderResponse;
import com.willyhui94.ordering.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping({ "", "/"})
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("createOrderCommand: {}", createOrderCommand);
        log.info("createOrderCommand: {}", createOrderCommand);
        CreateOrderResponse response = orderService.createOrder(createOrderCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping({ "", "/"})
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        log.info("getAllOrders");
        List<OrderResponse> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CancelOrderResponse> cancelOrder(@PathVariable("id") UUID orderId) {
        log.info("cancelOrder");
        CancelOrderResponse response = orderService.cancelOrder(orderId);
        return ResponseEntity.ok(response);
    }
}
