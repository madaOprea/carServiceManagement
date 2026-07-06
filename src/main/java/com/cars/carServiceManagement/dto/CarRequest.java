package com.cars.carServiceManagement.dto;

import com.cars.carServiceManagement.entity.FuelType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CarRequest {

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Year is required")
    private Integer year;

    @NotBlank(message = "License plate is required")
    private String licensePlate;

    private Integer numberOfDoors;

    private FuelType fuelType;

    private String transmission;
}