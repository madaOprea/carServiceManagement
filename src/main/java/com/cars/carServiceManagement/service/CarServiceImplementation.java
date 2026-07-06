package com.cars.carServiceManagement.service;

import com.cars.carServiceManagement.dto.CarRequest;
import com.cars.carServiceManagement.dto.CarResponse;
import com.cars.carServiceManagement.entity.Car;
import com.cars.carServiceManagement.entity.FuelType;
import com.cars.carServiceManagement.exception.ResourceNotFoundException;
import com.cars.carServiceManagement.mapper.CarMapper;
import com.cars.carServiceManagement.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImplementation implements CarService {

    private final CarRepository carRepository;

    public CarServiceImplementation(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::toResponse)
                .toList();
    }

    @Override
    public CarResponse getCarById(Long id) {
        return CarMapper.toResponse(findCarById(id));
    }

    @Override
    public CarResponse createCar(CarRequest request) {
        Car car = CarMapper.toEntity(request);
        Car savedCar = carRepository.save(car);

        return CarMapper.toResponse(savedCar);
    }

    @Override
    public CarResponse updateCar(Long id, CarRequest request) {
        Car existingCar = findCarById(id);

        existingCar.setBrand(request.getBrand());
        existingCar.setModel(request.getModel());
        existingCar.setManufactureYear(request.getYear());
        existingCar.setLicensePlate(request.getLicensePlate());
        existingCar.setNumberOfDoors(request.getNumberOfDoors());
        existingCar.setFuelType(request.getFuelType());
        existingCar.setTransmission(request.getTransmission());

        Car updatedCar = carRepository.save(existingCar);

        return CarMapper.toResponse(updatedCar);
    }

    @Override
    public CarResponse patchCar(Long id, Map<String, Object> updates) {
        Car existingCar = findCarById(id);

        updates.forEach((key, value) -> {
            switch (key) {
                case "brand" -> existingCar.setBrand((String) value);
                case "model" -> existingCar.setModel((String) value);
                case "manufactureYear" -> existingCar.setManufactureYear((Integer) value);
                case "licensePlate" -> existingCar.setLicensePlate((String) value);
                case "numberOfDoors" -> existingCar.setNumberOfDoors((Integer) value);
                case "fuelType" -> existingCar.setFuelType(FuelType.valueOf((String) value));
                case "transmission" -> existingCar.setTransmission((String) value);
            }
        });

        Car updatedCar = carRepository.save(existingCar);

        return CarMapper.toResponse(updatedCar);
    }

    @Override
    public void deleteCar(Long id) {
        Car existingCar = findCarById(id);
        carRepository.delete(existingCar);
    }

    private Car findCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Car", "id", id));
    }
}