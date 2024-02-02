package com.FinalProject.Coders.DTOs;



import com.FinalProject.Coders.Enums.Medicine;
import com.FinalProject.Coders.Enums.TreatmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDTO {


    private List<Medicine> medicines;

    private String currentDisease;

    private TreatmentStatus treatmentStatus;

}
