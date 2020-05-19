package com.ylizma.cinemamanagements;

import com.ylizma.cinemamanagements.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class CinemaManagementsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinemaManagementsApplication.class, args);
    }

}
