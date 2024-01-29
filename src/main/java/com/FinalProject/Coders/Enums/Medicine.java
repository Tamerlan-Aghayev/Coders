package com.FinalProject.Coders.Enums;

import com.FinalProject.Coders.entities.Treatment;
import jakarta.persistence.*;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dose;
    private String takingPeriod;

    // Many-to-One relationship with Treatment
    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    // other fields and methods

}
