package com.retrip.sample.infra.adapter.out.persistence.mysql.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.retrip.sample.application.port.in.response.OrderResponse;
import com.retrip.sample.application.port.out.repository.OrderQueryRepository;
import com.retrip.sample.domain.vo.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.retrip.sample.domain.entity.QOrder.*;

@RequiredArgsConstructor
@Repository
public class OrderQuerydslRepository implements OrderQueryRepository {
    private final JPAQueryFactory query;

    @Override
    public List<OrderResponse> findAllByStatus(OrderStatus status) {
        return query
                .select(Projections.constructor(OrderResponse.class,
                        order.id,
                        order.name,
                        order.status))
                .from(order)
                .where(statusEq(status))
                .fetch();
    }

    private BooleanExpression statusEq(OrderStatus status) {
        return status == null ? null : order.status.eq(status);
    }
}
