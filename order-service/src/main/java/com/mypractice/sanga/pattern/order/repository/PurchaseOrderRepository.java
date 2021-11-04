package com.mypractice.sanga.pattern.order.repository;

import com.mypractice.sanga.pattern.order.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder, UUID> {
}
