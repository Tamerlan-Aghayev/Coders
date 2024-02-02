package com.FinalProject.Coders.repositories;

import com.FinalProject.Coders.entities.Appointment;
import com.FinalProject.Coders.entities.PatientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByPatient(PatientInfo patientInfo);
}
