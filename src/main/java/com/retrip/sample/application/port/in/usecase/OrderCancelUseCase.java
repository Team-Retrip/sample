package com.retrip.sample.application.port.in.usecase;

import java.util.UUID;

public interface OrderCancelUseCase {
    void cancelOrder(UUID orderId);
}
