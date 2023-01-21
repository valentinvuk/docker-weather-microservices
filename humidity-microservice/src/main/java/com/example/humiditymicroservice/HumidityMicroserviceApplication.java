package com.example.humiditymicroservice;

import com.example.humiditymicroservice.sensorreading.SensorReading;
import com.example.humiditymicroservice.sensorreading.SensorRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.FileReader;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class HumidityMicroserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HumidityMicroserviceApplication.class, args);
    }

    @Autowired
    SensorRepository repo;


    @Override
    public void run(String... args) throws Exception {
        //Fillanje baze ne radi kroz kod jer readings.csv se ne uspijeva ucitat na dockeru
        List<SensorReading> readings = new CsvToBeanBuilder<SensorReading>(new FileReader("readings.csv"))
                .withType(SensorReading.class).build().parse();

        long i = 0;
        for(SensorReading reading: readings){
            reading.setId(i++);
        }

        repo.saveAll(readings);

        readings.stream().forEach(System.out::println);
    }
}
