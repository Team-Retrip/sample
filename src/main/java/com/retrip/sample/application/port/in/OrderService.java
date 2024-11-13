package com.retrip.sample.application.port.in;

import com.retrip.sample.application.port.in.request.OrderCreateRequest;
import com.retrip.sample.application.port.in.response.OrderCreateResponse;
import com.retrip.sample.application.port.in.usecase.OrderCreateUseCase;
import com.retrip.sample.application.port.out.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService implements OrderCreateUseCase {
    private final OrderRepository orderRepository;

    @Override
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        return OrderCreateResponse.of(orderRepository.save(request.to()));
    }
}
