package com.mypractice.sanga.pattern.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "user_balance")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserTransaction {

    @Id
    private UUID orderId;
    private int userId;
    private int amount;

}