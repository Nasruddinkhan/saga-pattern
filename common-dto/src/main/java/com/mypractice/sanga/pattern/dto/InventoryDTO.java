package com.mypractice.sanga.pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class InventoryDTO {
    private UUID orderId;
    private Integer productId;
}
