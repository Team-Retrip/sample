package com.retrip.sample.application.port.in;

import com.retrip.sample.application.port.in.request.OrderCreateRequest;
import com.retrip.sample.application.port.in.response.OrderCreateResponse;
import com.retrip.sample.application.port.in.response.OrderResponse;
import com.retrip.sample.application.port.in.usecase.GetOrdersUseCase;
import com.retrip.sample.application.port.in.usecase.OrderCancelUseCase;
import com.retrip.sample.application.port.in.usecase.OrderCreateUseCase;
import com.retrip.sample.application.port.out.repository.OrderQueryRepository;
import com.retrip.sample.application.port.out.repository.OrderRepository;
import com.retrip.sample.domain.entity.Order;
import com.retrip.sample.domain.vo.OrderStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService
        implements OrderCreateUseCase, OrderCancelUseCase, GetOrdersUseCase {
    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    @Override
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        return OrderCreateResponse.of(orderRepository.save(request.to()));
    }

    @Override
    public void cancelOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        order.cancel();
    }

    @Override
    public List<OrderResponse> getOrdersByStatus(String status) {
        return orderQueryRepository.findAllByStatus(OrderStatus.valueOf(status));
    }

    public void paymentAccountTransfer(UUID orderId) {

    }
}
