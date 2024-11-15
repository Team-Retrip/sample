package com.retrip.sample.application.port.in.response;

import com.retrip.sample.domain.vo.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private UUID id;
    private String name;
    private OrderStatus status;
}
