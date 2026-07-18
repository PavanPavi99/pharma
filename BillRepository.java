package com.pharmalens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pharmalens.entity.Medicine;
import com.pharmalens.service.MedicineService;

@Controller
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    // Display all medicines
    @GetMapping
    public String medicineList(Model model) {

        model.addAttribute("medicines",
                medicineService.getAllMedicines());

        return "medicine-list";
    }


    // Search Medicine
    @GetMapping("/search")
    public String searchMedicine(
            @RequestParam("keyword") String keyword,
            Model model) {

        model.addAttribute("medicines",
                medicineService.searchMedicine(keyword));

        return "medicine-list";
    }


    // Open Add Medicine Page
    @GetMapping("/add")
    public String addMedicine(Model model) {

        model.addAttribute("medicine", new Medicine());

        return "medicine-add";
    }


    // Save Medicine
    @PostMapping("/save")
    public String saveMedicine(@ModelAttribute Medicine medicine) {

        medicineService.saveMedicine(medicine);

        return "redirect:/medicine";
    }


    // Open Edit Medicine Page
    @GetMapping("/edit/{id}")
    public String editMedicine(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("medicine",
                medicineService.getMedicineById(id));

        return "medicine-edit";
    }


    // Update Medicine
    @PostMapping("/update")
    public String updateMedicine(@ModelAttribute Medicine medicine) {

        medicineService.saveMedicine(medicine);

        return "redirect:/medicine";
    }


    // Delete Medicine
    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {

        medicineService.deleteMedicine(id);

        return "redirect:/medicine";
    }

}