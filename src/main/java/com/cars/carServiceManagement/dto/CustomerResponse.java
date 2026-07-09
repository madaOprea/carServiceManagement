package com.cars.carServiceManagement.dto;

import com.cars.carServiceManagement.entity.Car;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private List<Car> cars = new ArrayList<>();
}
