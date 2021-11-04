package com.mypractice.sanga.pattern.inventory;

import com.mypractice.sanga.pattern.inventory.repository.OrderInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication implements CommandLineRunner {

    @Autowired
    private OrderInventoryRepository orderInventoryRepository;
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("InventoryApplication.run");
        orderInventoryRepository.findAll().forEach(System.out::println);
        System.out.println("InventoryApplication.run end");

    }
}
