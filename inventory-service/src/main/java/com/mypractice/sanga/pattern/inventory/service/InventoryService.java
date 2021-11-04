package com.mypractice.sanga.pattern.inventory.service;

import com.mypractice.sanga.pattern.events.inventory.InventoryEvent;
import com.mypractice.sanga.pattern.events.order.OrderEvent;

public interface InventoryService {
    InventoryEvent newOrderInventory(OrderEvent event);

    void cancelOrderInventory(OrderEvent event);
}
