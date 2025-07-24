package com.preowned.controller;

import com.preowned.model.Car;
import com.preowned.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String home(Model model) {
        List<Car> availableCars = carService.getAvailableCars();
        model.addAttribute("cars", availableCars);
        model.addAttribute("inquiry", new com.preowned.model.Inquiry()); // for form binding
        return "index";
    }

    @GetMapping("/available")
    public String showAvailableCars(@RequestParam(required = false) String fuel,
                                    @RequestParam(required = false) String brand,
                                    @RequestParam(required = false) Double maxPrice,
                                    Model model) {
        List<Car> filteredCars = carService.filterCars(fuel, brand, maxPrice);
        model.addAttribute("cars", filteredCars);
        return "available";
    }

    @GetMapping("/sold")
    public String showSoldCars(Model model) {
        List<Car> soldCars = carService.getSoldCars();
        model.addAttribute("cars", soldCars);
        return "sold";
    }

    @GetMapping("/happy-customers")
    public String happyCustomers() {
        return "happyCustomers";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/car/{id}")
    public String showCarDetails(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return "redirect:/";
        }
        model.addAttribute("car", car);
        return "productDetails";
    }
}
