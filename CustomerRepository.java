package com.pharmalens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pharmalens.service.ReportService;


@Controller
public class ReportController {


    @Autowired
    private ReportService reportService;



    @GetMapping("/reports")
    public String reports(Model model) {


        model.addAttribute("totalMedicines",
                reportService.getTotalMedicines());


        model.addAttribute("totalCustomers",
                reportService.getTotalCustomers());


        model.addAttribute("totalSuppliers",
                reportService.getTotalSuppliers());


        model.addAttribute("totalBills",
                reportService.getTotalBills());


        model.addAttribute("totalSales",
                reportService.getTotalSales());


        // Low stock medicines
        model.addAttribute("lowStock",
                reportService.getLowStockMedicines());


        return "reports";

    }

}