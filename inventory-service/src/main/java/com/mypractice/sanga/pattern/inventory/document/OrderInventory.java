package com.mypractice.sanga.pattern.inventory.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="order_inventory")
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class OrderInventory {
    @Id
    private Integer productId;
    private Integer availableInventory;
}
