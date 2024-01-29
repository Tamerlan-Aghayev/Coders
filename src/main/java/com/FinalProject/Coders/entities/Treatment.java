package com.FinalProject.Coders.entities;

import com.FinalProject.Coders.Enums.Medicine;
import com.FinalProject.Coders.Enums.TreatmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "doctor_id")
//    private DoctorInfo doctorInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private PatientInfo patientInfo;

    @OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL)
    private List<Medicine> medicines;

    private String currentDisease;

    @Enumerated(EnumType.STRING)
    private TreatmentStatus treatmentStatus;
}
