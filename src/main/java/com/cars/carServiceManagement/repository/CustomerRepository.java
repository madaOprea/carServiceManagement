package com.cars.carServiceManagement.repository;

import com.cars.carServiceManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
