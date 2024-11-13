package com.retrip.sample.application.port.out.repository;

import com.retrip.sample.domain.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(UUID orderId);
}
