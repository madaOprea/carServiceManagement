package com.cars.carServiceManagement.service;

import com.cars.carServiceManagement.dto.*;

import java.util.*;

public interface CarService {
    List<CarResponse> getAllCars();

    List<CarResponse> getAllCarsSortedByYear();

    CarResponse getCarById(Long id);

    CarResponse createCar(CarRequest request);

    CarResponse patchCar(Long id, Map<String, Object> updates);
    CarResponse updateCar(Long id, CarRequest request);

    void deleteCar(Long id);
}