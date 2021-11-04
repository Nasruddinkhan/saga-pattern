package com.mypractice.sanga.pattern.order.service;

import com.mypractice.sanga.pattern.order.model.PurchaseOrder;

import java.util.List;

public interface OrderQueryService {
    List<PurchaseOrder> findAll();
}
