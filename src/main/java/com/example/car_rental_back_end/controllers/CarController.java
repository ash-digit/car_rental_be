package com.example.car_rental_back_end.controllers;

import com.example.car_rental_back_end.models.Car;
import com.example.car_rental_back_end.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

//    CREATE
    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

//    READ
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

//     DELETE
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return String.format("Car with id %d has been deleted", id);
    }
}
