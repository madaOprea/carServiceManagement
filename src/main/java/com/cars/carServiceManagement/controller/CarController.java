package com.cars.carServiceManagement.controller;

import com.cars.carServiceManagement.dto.CarRequest;
import com.cars.carServiceManagement.dto.CarResponse;
import com.cars.carServiceManagement.service.CarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping
    public List<CarResponse> getAllCarsSortedByBrand(@RequestParam(required = false) String sort)) {
        return carService.getAllCarsSortedByBrand();
    }

    @GetMapping("/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public CarResponse createCar(@Valid @RequestBody CarRequest request) {
        return carService.createCar(request);
    }

    @PutMapping("/{id}")
    public CarResponse updateCar(@PathVariable Long id, @Valid @RequestBody CarRequest request) {
        return carService.updateCar(id, request);
    }

    @PatchMapping("/{id}")
    public CarResponse updateInfoCar(@PathVariable Long id, @RequestBody Map<String, Object> updates) {

        return carService.patchCar(id, updates);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
