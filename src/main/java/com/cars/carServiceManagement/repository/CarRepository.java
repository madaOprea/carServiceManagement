package com.cars.carServiceManagement.repository;

import com.cars.carServiceManagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrandIgnoreCase(String brand);

    List<Car> findByFuelType(FuelType fuelType);

    List<Car> findByTransmissionIgnoreCase(String transmission);
}