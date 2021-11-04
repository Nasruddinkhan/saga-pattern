package com.mypractice.sanga.pattern.events.inventory;

import com.mypractice.sanga.pattern.dto.InventoryDTO;
import com.mypractice.sanga.pattern.events.Event;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class InventoryEvent implements Event {
    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();
    private InventoryDTO inventory;
    private InventoryStatus status;

    public InventoryEvent(InventoryDTO inventory, InventoryStatus status) {
        this.inventory = inventory;
        this.status = status;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }
    public InventoryDTO getInventory() {
        return inventory;
    }

    public InventoryStatus getStatus() {
        return status;
    }
}
