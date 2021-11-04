package com.mypractice.sanga.pattern.inventory.repository;

import com.mypractice.sanga.pattern.inventory.document.OrderInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInventoryRepository extends JpaRepository<OrderInventory, Integer> {
}
