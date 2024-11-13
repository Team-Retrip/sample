package com.retrip.sample.domain.entity;

import com.retrip.sample.domain.vo.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.retrip.sample.domain.vo.OrderStatus.CREATED;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Order {
    @Id
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.status = CREATED;
    }
}
