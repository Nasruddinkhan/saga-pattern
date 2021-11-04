package com.mypractice.sanga.pattern.inventory.service.impl;

import com.mypractice.sanga.pattern.dto.InventoryDTO;
import com.mypractice.sanga.pattern.events.inventory.InventoryEvent;
import com.mypractice.sanga.pattern.events.inventory.InventoryStatus;
import com.mypractice.sanga.pattern.events.order.OrderEvent;
import com.mypractice.sanga.pattern.inventory.document.OrderInventoryConsumption;
import com.mypractice.sanga.pattern.inventory.repository.OrderInventoryConsumptionRepository;
import com.mypractice.sanga.pattern.inventory.repository.OrderInventoryRepository;
import com.mypractice.sanga.pattern.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@Transactional

public class InventoryServiceImpl implements InventoryService {

    private final OrderInventoryRepository orderInventory;
    private final OrderInventoryConsumptionRepository consumptionRepository;

    @Override
    public InventoryEvent newOrderInventory(OrderEvent event) {
        System.out.println("InventoryServiceImpl.newOrderInventory ["+event+"]");
        InventoryDTO dto = InventoryDTO.of(event.getPurchaseOrder().getOrderId(), event.getPurchaseOrder().getProductId());
       return   orderInventory.findById(event.getPurchaseOrder().getProductId())
                .filter(orderInventory -> orderInventory.getAvailableInventory() > 0)
                .map(orderInventory-> {
                    orderInventory.setAvailableInventory(orderInventory.getAvailableInventory() -1);
                    consumptionRepository.save(OrderInventoryConsumption
                            .of(event.getPurchaseOrder().getOrderId(),  event.getPurchaseOrder().getProductId(), 1));

                 return new InventoryEvent(dto, InventoryStatus.RESERVED);
                }).orElse( new InventoryEvent(dto, InventoryStatus.REJECTED));

    }
    @Override
    public void cancelOrderInventory(OrderEvent event) {
        consumptionRepository.findById(event.getPurchaseOrder().getOrderId())
                .ifPresent(ci -> {
                    orderInventory.findById(ci.getProductId())
                            .ifPresent(i ->
                                    i.setAvailableInventory(i.getAvailableInventory() + ci.getQuantityConsumed())
                            );
                    consumptionRepository.delete(ci);
                });

    }
}
