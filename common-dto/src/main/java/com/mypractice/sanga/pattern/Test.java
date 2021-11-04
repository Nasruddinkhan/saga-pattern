package com.mypractice.sanga.pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.sanga.pattern.dto.PurchaseOrderDto;
import com.mypractice.sanga.pattern.events.order.OrderEvent;
import com.mypractice.sanga.pattern.events.order.OrderStatus;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
        purchaseOrderDto.setPrice(2);
        purchaseOrderDto.setUserId(1);
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderEvent.setPurchaseOrder(purchaseOrderDto);
        ObjectMapper mapper =    new ObjectMapper();
        System.out.println( mapper.writeValueAsString(orderEvent));;
    }
}
