package com.example.aggregatormicroservice.controllers;

import com.example.aggregatormicroservice.models.AggregatorResponse;
import com.example.aggregatormicroservice.models.SensorReading;
import com.example.aggregatormicroservice.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AggregatorController {
    @Value("${temperature-unit: C}")
    String unit;

    @Autowired
    private DiscoveryClient discoveryClient;

    public AggregatorController() {
    }

    @GetMapping("/current")
    public AggregatorResponse getCurrentReading(){
        SensorReading temp = new RestService(new RestTemplateBuilder()).getTemperatureReading(discoveryClient);
        SensorReading hum = new RestService(new RestTemplateBuilder()).getHumidityReading(discoveryClient);

        Integer temperature = Integer.parseInt(temp.getTemperature());

        if (unit.equalsIgnoreCase("K")) {
           temperature = temperature + 273;
        }

        return new AggregatorResponse(unit,"%",temperature,Integer.parseInt(hum.getHumidity()));
    }

}

