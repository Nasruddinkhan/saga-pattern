package com.mypractice.sanga.pattern.order;

import com.mypractice.sanga.pattern.order.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("OrderApplication.run start");
        purchaseOrderRepository.findAll().forEach(System.out::println);
        System.out.println("OrderApplication.run end");
    }
}
