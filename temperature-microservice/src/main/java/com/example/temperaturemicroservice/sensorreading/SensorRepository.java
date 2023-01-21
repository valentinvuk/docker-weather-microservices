package com.example.temperaturemicroservice.sensorreading;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<SensorReading,Long> {
}
