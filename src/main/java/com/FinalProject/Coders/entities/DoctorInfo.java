//package com.FinalProject.Coders.entities;
//
//import com.FinalProject.Coders.Enums.Position;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class DoctorInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Enumerated(EnumType.STRING)
//    private Position position;
//
//    private String hospital;
//
//    @OneToOne
//    @JoinColumn(name = "user_id" , referencedColumnName = "id")
//    private UserEntity userId;
//
//
//    @OneToMany(mappedBy = "doctorInfo")
//    private List<Treatment> treatments;
//
//    @OneToMany(mappedBy = "doctorInfo")
//    private List<Appointment> appointments;
//}
