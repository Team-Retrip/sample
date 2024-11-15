package com.retrip.sample.infra.adapter.in.presentation.rest;

import com.retrip.sample.application.port.in.request.OrderCreateRequest;
import com.retrip.sample.application.port.in.response.OrderCreateResponse;
import com.retrip.sample.application.port.in.response.OrderResponse;
import com.retrip.sample.application.port.in.usecase.GetOrdersUseCase;
import com.retrip.sample.application.port.in.usecase.OrderCancelUseCase;
import com.retrip.sample.application.port.in.usecase.OrderCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderCreateUseCase orderCreateUseCase;
    private final OrderCancelUseCase orderCancelUseCase;
    private final GetOrdersUseCase getOrdersUseCase;

    @PostMapping
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        OrderCreateResponse order = orderCreateUseCase.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + order.getId())).body(order);
    }

    @PutMapping("{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable UUID orderId) {
        orderCancelUseCase.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrdersByStatus(@RequestParam String status) {
        List<OrderResponse> orders = getOrdersUseCase.getOrdersByStatus(status);
        return ResponseEntity.ok().body(orders);
    }
}
