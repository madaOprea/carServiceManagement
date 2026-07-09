package com.cars.carServiceManagement.mapper;

import com.cars.carServiceManagement.dto.*;
import com.cars.carServiceManagement.entity.Customer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class CustomerMapper {

    public static Customer toEntity(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setCars(request.getCars());

        return customer;
    }

    public static CustomerResponse toResponse(Customer customer) {

        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .cars(customer.getCars())
                .build();
    }
}