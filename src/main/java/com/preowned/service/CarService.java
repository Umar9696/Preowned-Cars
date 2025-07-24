package com.preowned.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.preowned.model.Car;
import com.preowned.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    @Autowired
    private Cloudinary cloudinary;

    public void saveCarWithImage(Car car, MultipartFile file) {
        try {
            // Upload the image to Cloudinary
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");

            // Set the Cloudinary URL in the Car entity
            car.setImageUrl(imageUrl);
            car.setStatus("Available"); // Default status
            carRepo.save(car);

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public List<Car> getAvailableCars() {
        return carRepo.findByStatus("Available");
    }

    public List<Car> getSoldCars() {
        return carRepo.findByStatus("Sold");
    }

    public Car getCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    public void updateCar(Car car) {
        carRepo.save(car); // This will update the car if it already exists
    }

    // ✅ NEW: Filter cars based on fuel, brand, and maxPrice
    public List<Car> filterCars(String fuel, String brand, Double maxPrice) {
        if ((fuel == null || fuel.isEmpty()) &&
            (brand == null || brand.isEmpty()) &&
            maxPrice == null) {
            return getAvailableCars();
        }
        return carRepo.findByFilters(fuel, brand, maxPrice);
    }
}
