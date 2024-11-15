package com.retrip.sample.application.port.in.usecase;

import com.retrip.sample.application.port.in.response.OrderResponse;

import java.util.List;

public interface GetOrdersUseCase {
    List<OrderResponse> getOrdersByStatus(String status);
}
