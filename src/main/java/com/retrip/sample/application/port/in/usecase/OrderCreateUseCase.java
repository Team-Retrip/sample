package com.retrip.sample.application.port.in.usecase;

import com.retrip.sample.application.port.in.request.OrderCreateRequest;
import com.retrip.sample.application.port.in.response.OrderCreateResponse;

public interface OrderCreateUseCase {
    OrderCreateResponse createOrder(OrderCreateRequest request);
}
