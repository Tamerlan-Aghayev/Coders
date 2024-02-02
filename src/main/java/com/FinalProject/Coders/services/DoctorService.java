package com.FinalProject.Coders.services;

import com.FinalProject.Coders.entities.DoctorInfo;
import com.FinalProject.Coders.entities.PatientInfo;
import com.FinalProject.Coders.repositories.DoctorInfoRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorInfoRepo doctorInfoRepo;

    public List<DoctorInfo> getByPatientId(PatientInfo patientInfo){
        doctorInfoRepo.
    }
}
