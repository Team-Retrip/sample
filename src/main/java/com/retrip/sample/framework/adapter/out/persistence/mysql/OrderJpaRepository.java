package com.retrip.sample.framework.adapter.out.persistence.mysql;

import com.retrip.sample.application.port.out.repository.OrderRepository;
import com.retrip.sample.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID>, OrderRepository {
}
