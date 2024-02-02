package com.FinalProject.Coders.repositories;

import com.FinalProject.Coders.entities.DoctorInfo;
import com.FinalProject.Coders.entities.PatientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorInfoRepo extends JpaRepository<DoctorInfo , Long> {
    List<DoctorInfo> findByPatient(PatientInfo patient);
}
