package com.FinalProject.Coders.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private DoctorInfo doctor;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private PatientInfo patient;
}
