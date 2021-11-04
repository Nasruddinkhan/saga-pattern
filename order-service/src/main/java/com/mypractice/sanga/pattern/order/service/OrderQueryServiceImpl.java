package com.mypractice.sanga.pattern.order.service;

import com.mypractice.sanga.pattern.order.model.PurchaseOrder;
import com.mypractice.sanga.pattern.order.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderQueryServiceImpl implements OrderQueryService{
    private final PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    public OrderQueryServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }
}
