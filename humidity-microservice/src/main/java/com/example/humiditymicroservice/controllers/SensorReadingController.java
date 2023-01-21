package com.example.humiditymicroservice.controllers;

import com.example.humiditymicroservice.sensorreading.SensorReading;
import com.example.humiditymicroservice.sensorreading.SensorRepository;
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
        long id = (System.currentTimeMillis()% 100);
        return repo.findById(id);
    }
}
