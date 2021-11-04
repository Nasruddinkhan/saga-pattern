package com.mypractice.sanga.pattern.order.service;

import com.mypractice.sanga.pattern.dto.PurchaseOrderDto;
import com.mypractice.sanga.pattern.events.order.OrderEvent;
import com.mypractice.sanga.pattern.events.order.OrderStatus;
import com.mypractice.sanga.pattern.order.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {
    @Autowired
    private Sinks.Many<OrderEvent> orderSink;

    public void raiseOrderEvent(final PurchaseOrder purchaseOrder, OrderStatus orderStatus){
        var dto = PurchaseOrderDto.of(
                purchaseOrder.getId(),
                purchaseOrder.getProductId(),
                purchaseOrder.getPrice(),
                purchaseOrder.getUserId()
        );
        var orderEvent = new OrderEvent(dto, orderStatus);
        this.orderSink.tryEmitNext(orderEvent);
    }
}
