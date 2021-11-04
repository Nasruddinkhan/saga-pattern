package com.mypractice.sanga.pattern.order.model;

import com.mypractice.sanga.pattern.events.inventory.InventoryStatus;
import com.mypractice.sanga.pattern.events.order.OrderStatus;
import com.mypractice.sanga.pattern.events.payment.PaymentStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
@ToString
public class PurchaseOrder {

    @Id
    private UUID id;
    private Integer userId;
    private Integer productId;
    private Integer price;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private InventoryStatus inventoryStatus;

    @Version
    private int version;

}