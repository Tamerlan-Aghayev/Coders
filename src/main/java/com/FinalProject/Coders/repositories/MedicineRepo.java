package com.FinalProject.Coders.repositories;

import com.FinalProject.Coders.Enums.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine , Long> {
}
