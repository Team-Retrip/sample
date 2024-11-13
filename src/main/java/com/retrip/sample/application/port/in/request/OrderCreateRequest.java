package com.retrip.sample.application.port.in.request;

import com.retrip.sample.domain.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderCreateRequest {
    private String name;

    public Order to() {
        return new Order(name);
    }
}
