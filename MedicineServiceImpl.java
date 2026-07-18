package com.pharmalens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pharmalens.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // Low stock medicines (quantity 10 or less)
    @Query("SELECT m FROM Medicine m WHERE m.quantity <= 10")
    List<Medicine> findLowStockMedicines();

    // Search medicine by name
    List<Medicine> findByMedicineNameContainingIgnoreCase(String medicineName);

    // Find medicine by exact name (used for billing)
    Medicine findByMedicineName(String medicineName);

}