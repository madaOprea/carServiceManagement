package com.cars.carServiceManagement.repository;

import com.cars.carServiceManagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}