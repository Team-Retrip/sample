package com.retrip.sample.framework.adapter.in.presentation.rest;

import com.retrip.sample.application.port.in.request.OrderCreateRequest;
import com.retrip.sample.application.port.in.response.OrderCreateResponse;
import com.retrip.sample.application.port.in.usecase.OrderCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderCreateUseCase orderCreateUseCase;

    @PostMapping
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        OrderCreateResponse order = orderCreateUseCase.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + order.getId())).body(order);
    }
}
