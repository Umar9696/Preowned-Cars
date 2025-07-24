package com.preowned.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.preowned.service.CarService;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/available-cars")
    public String viewAvailableCars(Model model) {
        model.addAttribute("cars", carService.getAvailableCars());
        return "available";
    }

    @GetMapping("/sold-cars")
    public String viewSoldCars(Model model) {
        model.addAttribute("cars", carService.getSoldCars());
        return "sold";
    }
}
