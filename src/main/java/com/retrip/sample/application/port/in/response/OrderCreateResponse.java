package com.retrip.sample.application.port.in.response;

import com.retrip.sample.domain.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateResponse {
    private UUID id;
    private String name;

    public static OrderCreateResponse of(Order order) {
        return new OrderCreateResponse(order.getId(), order.getName());
    }
}
