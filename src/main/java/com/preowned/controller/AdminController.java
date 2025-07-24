package com.preowned.controller;

import com.preowned.model.Car;
import com.preowned.service.CarService;
import com.preowned.service.InquiryService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private InquiryService inquiryService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/add-car")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "admin/addCar";
    }

    @PostMapping("/add-car")
    public String addCar(HttpServletRequest request,
                         @ModelAttribute Car car,
                         @RequestParam("file") MultipartFile file) {
        try {
            System.out.println("📦 File name: " + file.getOriginalFilename());
            System.out.println("📦 Request parts: " + request.getParts().size());

            carService.saveCarWithImage(car, file);
            return "redirect:/admin/view-cars";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/add-car?error";
        }
    }

    @GetMapping("/view-cars")
    public String viewCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "admin/viewCars";
    }

    @PostMapping("/mark-sold/{id}")
    public String markAsSold(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            car.setStatus("SOLD");
            carService.updateCar(car); // Save the updated car
        }
        return "redirect:/admin/view-cars";
    }

    @GetMapping("/view-inquiries")
    public String viewInquiries(Model model) {
        model.addAttribute("inquiries", inquiryService.getAllInquiries());
        return "admin/viewInquiries";
    }
}
