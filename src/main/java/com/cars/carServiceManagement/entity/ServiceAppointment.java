package com.cars.carServiceManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment date is required")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "Description is required")
    private String description;

    private String status;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Mechanic mechanic;
}