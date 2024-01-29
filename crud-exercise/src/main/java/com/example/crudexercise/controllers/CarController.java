package com.example.crudexercise.controllers;

import com.example.crudexercise.entities.Car;
import com.example.crudexercise.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @PostMapping(path = "create")
    public Car createCar (@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }
    @GetMapping(path = "/read/{id}")
    public Car readCar (@PathVariable long id){
        Car car = null;
        if(!carRepository.existsById(id)){
            return car;
        }
        else {
            return carRepository.getById(id);
        }
    }

    @GetMapping(path = "/readall")
    public List<Car> readCars (){
        return carRepository.findAll();
    }


    @PutMapping(path = "/update/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car){
        car.setId(id);
        return carRepository.saveAndFlush(car);
    }
    @DeleteMapping(path = "deleteone/{id}")
    public void deleteOne (@PathVariable long id){
        carRepository.deleteById(id);
    }
    @DeleteMapping(path = "deleteall")
    public void deleteAll ( long id){
        carRepository.deleteAll();
    }
}
