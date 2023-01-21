package com.example.aggregatormicroservice.services;

import com.example.aggregatormicroservice.models.SensorReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public SensorReading getTemperatureReading(DiscoveryClient discoveryClient) {
        List<ServiceInstance> instances = discoveryClient.getInstances("temperature-microservice");
        String endpoint = instances.get(0).getUri()+"/current";
        return this.restTemplate.getForObject(endpoint, SensorReading.class);
    }

    public SensorReading getHumidityReading(DiscoveryClient discoveryClient) {
        List<ServiceInstance> instances = discoveryClient.getInstances("humidity-microservice");
        String endpoint = instances.get(0).getUri()+"/current";

        return this.restTemplate.getForObject(endpoint, SensorReading.class);
    }
}