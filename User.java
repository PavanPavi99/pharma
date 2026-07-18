package com.pharmalens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pharmalens.entity.Bill;
import com.pharmalens.service.BillService;
import com.pharmalens.service.MedicineService;


@Controller
@RequestMapping("/bill")
public class BillController {


    @Autowired
    private BillService billService;


    @Autowired
    private MedicineService medicineService;



    // Show all bills
    @GetMapping
    public String billList(Model model) {

        model.addAttribute("bills",
                billService.getAllBills());

        return "bill-list";
    }



    // Open add bill page
    @GetMapping("/add")
    public String addBill(Model model) {

        model.addAttribute("bill", new Bill());


        // Send medicines to dropdown
        model.addAttribute("medicines",
                medicineService.getAllMedicines());


        return "billing";
    }




    // Save bill
    @PostMapping("/save")
    public String saveBill(@ModelAttribute Bill bill) {


        billService.saveBill(bill);


        return "redirect:/bill";
    }




    // View bill
    @GetMapping("/view/{id}")
    public String viewBill(
            @PathVariable Long id,
            Model model) {


        model.addAttribute("bill",
                billService.getBillById(id));


        return "invoice";
    }





    // Delete bill
    @GetMapping("/delete/{id}")
    public String deleteBill(
            @PathVariable Long id) {


        billService.deleteBill(id);


        return "redirect:/bill";
    }

}