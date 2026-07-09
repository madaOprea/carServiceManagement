package com.cars.carServiceManagement.mapper;

import com.cars.carServiceManagement.dto.*;
import com.cars.carServiceManagement.entity.Car;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class CarMapper {

    public static Car toEntity(CarRequest request) {

        Car car = new Car();

        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setManufactureYear(request.getYear());
        car.setLicensePlate(request.getLicensePlate());
        car.setNumberOfDoors(request.getNumberOfDoors());
        car.setFuelType(request.getFuelType());
        car.setTransmission(request.getTransmission());

        return car;
    }

    public static CarResponse toResponse(Car car) {

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getManufactureYear())
                .licensePlate(car.getLicensePlate())
                .numberOfDoors(car.getNumberOfDoors())
                .fuelType(car.getFuelType())
                .transmission(car.getTransmission())
                .build();
    }
}