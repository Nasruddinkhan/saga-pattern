package com.mypractice.sanga.pattern.inventory.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Entity
@Table(name = "order_inventory_consumption")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class OrderInventoryConsumption {
    @Id
    private UUID orderId;
    private int productId;
    private int quantityConsumed;
}
