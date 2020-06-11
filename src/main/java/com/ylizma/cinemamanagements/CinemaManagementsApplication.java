package com.ylizma.cinemamanagements;

import com.ylizma.cinemamanagements.model.Movie;
import com.ylizma.cinemamanagements.repository.CityRepository;
import com.ylizma.cinemamanagements.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class CinemaManagementsApplication implements CommandLineRunner {
    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(CinemaManagementsApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Movie.class);
        cinemaService.initCities();
        cinemaService.initCinemas();
        cinemaService.initRooms();
        cinemaService.initSeats();
        cinemaService.initSeances();
        cinemaService.initCategories();
        cinemaService.initMovies();
        cinemaService.initProjections();
        cinemaService.initTickets();
    }
}
