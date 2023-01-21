package com.example.temperaturemicroservice.controllers;

import com.example.temperaturemicroservice.sensorreading.SensorReading;
import com.example.temperaturemicroservice.sensorreading.SensorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SensorReadingController {
    private SensorRepository repo;

    public SensorReadingController(SensorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/current")
    public Optional<SensorReading> getCurrentReading(){
        long id = (System.currentTimeMillis()% 100) + 1;
        return repo.findById(id);
    }
}
