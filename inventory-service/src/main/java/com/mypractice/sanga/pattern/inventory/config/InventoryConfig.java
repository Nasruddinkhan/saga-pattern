package com.mypractice.sanga.pattern.inventory.config;

import com.mypractice.sanga.pattern.events.inventory.InventoryEvent;
import com.mypractice.sanga.pattern.events.order.OrderEvent;
import com.mypractice.sanga.pattern.events.order.OrderStatus;
import com.mypractice.sanga.pattern.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class InventoryConfig {
    @Autowired
    private InventoryService service;

    @Bean
    public Function<Flux<OrderEvent>, Flux<InventoryEvent>> inventoryProcessor() {
        System.out.println("InventoryConfig.inventoryProcessor [inventoryProcessor+]");
        return flux -> flux.flatMap(this::processInventory);
    }

    private Mono<InventoryEvent> processInventory(OrderEvent event){
        if(event.getOrderStatus().equals(OrderStatus.ORDER_CREATED)){
            return Mono.fromSupplier(() -> this.service.newOrderInventory(event));
        }
        return Mono.fromRunnable(() -> this.service.cancelOrderInventory(event));
    }
}
