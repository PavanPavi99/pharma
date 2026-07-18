package com.pharmalens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pharmalens.service.DashboardService;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalMedicines",
                dashboardService.getTotalMedicines());

        model.addAttribute("totalCustomers",
                dashboardService.getTotalCustomers());

        model.addAttribute("totalSuppliers",
                dashboardService.getTotalSuppliers());

        model.addAttribute("totalBills",
                dashboardService.getTotalBills());

        // Low Stock Medicines
        model.addAttribute("lowStockMedicines",
                dashboardService.getLowStockMedicines());

        return "dashboard";
    }
}