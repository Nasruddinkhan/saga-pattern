package com.mypractice.sanga.pattern.order.controller;

import com.mypractice.sanga.pattern.dto.OrderRequestDto;
import com.mypractice.sanga.pattern.order.model.PurchaseOrder;
import com.mypractice.sanga.pattern.order.service.OrderCommandService;
import com.mypractice.sanga.pattern.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderCommandService commandService;

    @Autowired
    private OrderQueryService queryService;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto requestDTO){
        requestDTO.setOrderId(UUID.randomUUID());
        return this.commandService.createOrder(requestDTO);
    }

    @GetMapping("/all")
    public List<PurchaseOrder> getOrders(){
        return this.queryService.findAll();
    }
}
