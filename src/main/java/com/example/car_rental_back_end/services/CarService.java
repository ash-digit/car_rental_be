package com.example.car_rental_back_end.services;

import com.example.car_rental_back_end.models.Car;
import com.example.car_rental_back_end.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    public final CarRepository carRepo;

    public CarService(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

//    CREATE
    public Car createCar(Car car){
        return carRepo.save(car);
    }

//    READ
    public Car getCarById(Long id){
        return carRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("User with id %d does not exist", id)));
    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }

//    DELETE
    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }
}
