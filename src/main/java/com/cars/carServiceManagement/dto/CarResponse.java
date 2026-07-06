package com.cars.carServiceManagement.dto;

import com.cars.carServiceManagement.entity.FuelType;
import lombok.*;

@Data
@Builder
public class CarResponse {

    private Long id;

    private String brand;

    private String model;

    private Integer year;

    private String licensePlate;

    private Integer numberOfDoors;

    private FuelType fuelType;

    private String transmission;
}