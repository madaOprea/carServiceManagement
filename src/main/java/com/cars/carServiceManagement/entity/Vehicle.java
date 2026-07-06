package com.cars.carServiceManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank
    protected String brand;

    @NotBlank
    protected String model;

    @NotNull
    protected Integer manufactureYear;

    @NotBlank
    @Column(unique = true)
    protected String licensePlate;
}