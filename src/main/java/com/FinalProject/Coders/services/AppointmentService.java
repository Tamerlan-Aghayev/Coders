package com.FinalProject.Coders.services;

import com.FinalProject.Coders.DTOs.AppointmentDTO;
import com.FinalProject.Coders.DTOs.PatientDTO;
import com.FinalProject.Coders.entities.PatientInfo;
import com.FinalProject.Coders.mapper.ModelMapperUtil;
import com.FinalProject.Coders.repositories.AppointmentRepo;
import com.FinalProject.Coders.repositories.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentService {
    private final ModelMapperUtil modelMapperUtil;
    private final AppointmentRepo appointmentRepo;
    private final PatientRepo patientRepo;

    public List<AppointmentDTO> getAppointments(Long id){
        PatientInfo patientInfo=patientRepo.getReferenceById(id);
        return appointmentRepo.findAppointmentByPatient(patientInfo).stream().map(appointment->modelMapperUtil.convertToDto(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }
    public void addAppointment(AppointmentDTO appointmentDTO, Long patientId){

    }

}
