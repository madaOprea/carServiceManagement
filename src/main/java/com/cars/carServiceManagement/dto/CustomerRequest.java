package com.cars.carServiceManagement.dto;

import com.cars.carServiceManagement.entity.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private List<Car> cars = new ArrayList<>();
}
