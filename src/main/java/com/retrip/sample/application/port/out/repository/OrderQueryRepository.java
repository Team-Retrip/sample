package com.retrip.sample.application.port.out.repository;

import com.retrip.sample.application.port.in.response.OrderResponse;
import com.retrip.sample.domain.vo.OrderStatus;

import java.util.List;

public interface OrderQueryRepository {
    List<OrderResponse> findAllByStatus(OrderStatus status);
}
