package com.retrip.sample.application.port.out.repository;

import com.retrip.sample.domain.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
