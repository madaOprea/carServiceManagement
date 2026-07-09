package com.cars.carServiceManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Vehicle {

    private Integer numberOfDoors;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}