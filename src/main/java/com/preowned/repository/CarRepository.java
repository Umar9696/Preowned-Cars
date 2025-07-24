package com.preowned.repository;

import com.preowned.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByStatus(String status);

    @Query("SELECT c FROM Car c WHERE c.status = 'Available' " +
           "AND (:fuel IS NULL OR LOWER(c.fuel) = LOWER(:fuel)) " +
           "AND (:brand IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :brand, '%'))) " +
           "AND (:maxPrice IS NULL OR c.price <= :maxPrice)")
    List<Car> findByFilters(@Param("fuel") String fuel,
                            @Param("brand") String brand,
                            @Param("maxPrice") Double maxPrice);
}
