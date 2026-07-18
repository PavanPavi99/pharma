package com.pharmalens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pharmalens.entity.Supplier;
import com.pharmalens.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    // Display all suppliers
    @GetMapping
    public String supplierList(Model model) {

        model.addAttribute("suppliers",
                supplierService.getAllSuppliers());

        return "supplier-list";
    }


    // Open Add Supplier Page
    @GetMapping("/add")
    public String addSupplier(Model model) {

        model.addAttribute("supplier", new Supplier());

        return "supplier-add";
    }


    // Save Supplier
    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute Supplier supplier) {

        supplierService.saveSupplier(supplier);

        return "redirect:/supplier";
    }


    // View Supplier Details
    @GetMapping("/view/{id}")
    public String viewSupplier(@PathVariable Long id, Model model) {

        model.addAttribute("supplier",
                supplierService.getSupplierById(id));

        return "supplier-view";
    }


    // Open Edit Supplier Page
    @GetMapping("/edit/{id}")
    public String editSupplier(@PathVariable Long id, Model model) {

        model.addAttribute("supplier",
                supplierService.getSupplierById(id));

        return "supplier-edit";
    }


    // Update Supplier
    @PostMapping("/update")
    public String updateSupplier(@ModelAttribute Supplier supplier) {

        supplierService.saveSupplier(supplier);

        return "redirect:/supplier";
    }


    // Delete Supplier
    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable Long id) {

        supplierService.deleteSupplier(id);

        return "redirect:/supplier";
    }

}