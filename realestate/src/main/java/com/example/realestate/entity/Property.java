package com.example.realestate.entity;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


//@Entity
@Data
public class Property {
    private static final AtomicLong idCounter = new AtomicLong(1); // Atomic counter for thread-safe ID generation

    private final Long id; // Auto-generated ID
    private String address;
    private String description;

    public Property(Long id, String address, String description) {
        this.id = idCounter.getAndIncrement();
        this.address = address;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

