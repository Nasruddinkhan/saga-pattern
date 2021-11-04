package com.mypractice.sanga.pattern.inventory.repository;

import com.mypractice.sanga.pattern.inventory.document.OrderInventoryConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderInventoryConsumptionRepository extends JpaRepository<OrderInventoryConsumption, UUID> {
}
