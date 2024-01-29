//package com.FinalProject.Coders.services;
//
//import com.FinalProject.Coders.Enums.Medicine;
////import com.FinalProject.Coders.entities.DoctorInfo;
//import com.FinalProject.Coders.entities.PatientInfo;
//import com.FinalProject.Coders.entities.Treatment;
//import com.FinalProject.Coders.entities.UserEntity;
////import com.FinalProject.Coders.repositories.DoctorInfoRepo;
//import com.FinalProject.Coders.repositories.MedicineRepo;
//import com.FinalProject.Coders.repositories.PatientRepo;
//import com.FinalProject.Coders.repositories.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TreatmentService {
//    private final UserRepo userRepo;
//    private final DoctorInfoRepo doctorInfoRepo;
//    private final MedicineRepo medicineRepo;
//    private final PatientRepo patientRepo;
//
//
//    public boolean addTreatment(String email, List<Medicine> medicines)
//    {
//        try {
//            UserEntity doctor_user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            DoctorInfo doctor = Objects.requireNonNull(doctor_user.getDoctorInfo());
//            PatientInfo patient = Objects.requireNonNull(userRepo.findByEmail(email).orElse(null)).getPatientInfo();
//
//            Treatment treatment = new Treatment();
//            treatment.setMedicines(medicines);
//
//
//        }catch (Exception e)
//        {
//
//        }
//
//        return false;
//    }
//
//}
