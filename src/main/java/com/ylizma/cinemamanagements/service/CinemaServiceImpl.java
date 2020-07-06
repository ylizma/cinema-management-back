package com.ylizma.cinemamanagements.service;

import com.ylizma.cinemamanagements.model.*;
import com.ylizma.cinemamanagements.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void initCities() {
        Stream.of("casablanca", "agadir", "marrakech", "tanger").forEach(v -> {
            City c = new City();
            c.setName(v);
            cityRepository.save(c);
        });
    }

    @Override
    public void initCinemas() {
        cityRepository
                .findAll()
                .forEach(city -> {
                    Stream.of("MAGMA", "FULLY", "CHAHRAZAD")
                            .forEach(name -> {
                                Cinema cinema = new Cinema();
                                cinema.setName(name);
                                cinema.setCity(city);
                                cinema.setNumberOfRooms(new Random().nextInt((10 - 2) + 1) + 2);
                                cinemaRepository.save(cinema);
                            });
                });
    }

    @Override
    public void initRooms() {
        cinemaRepository.findAll()
                .forEach(cinema -> {
                    for (int i = 0; i < cinema.getNumberOfRooms(); i++) {
                        Room room = new Room();
                        room.setName("room" + i + 1);
                        room.setCinema(cinema);
                        room.setPlacesNumber(20 + (int) (Math.random() * 10));
                        roomRepository.save(room);
                    }
                });
    }

    @Override
    public void initSeats() {
        roomRepository.findAll()
                .forEach(room -> {
                    for (int i = 0; i < room.getPlacesNumber(); i++) {
                        Seat seat = new Seat();
                        seat.setRoom(room);
                        seat.setNumber(i + 1 * 11);
                        seatRepository.save(seat);
                    }
                });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("h:mm");
        Stream.of("12:00", "14:00", "16:00", "18:00", "20:00")
                .forEach(s -> {
                    Seance seance = new Seance();
                    try {
                        seance.setStartHour(dateFormat.parse(s));
                        System.out.println(dateFormat.parse(s));
                        seanceRepository.save(seance);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void initCategories() {
        Stream.of("Horror", "Drama", "Science", "Action", "Comedy")
                .forEach(cat -> {
                    Category category = new Category();
                    category.setName(cat);
                    categoryRepository.save(category);
                });
    }

    @Override
    public void initMovies() {
        Stream.of("Exam", "Inception","Joker")
                .forEach(mov -> {
                    Movie movie = new Movie();
                    movie.setTitle(mov);
                    movie.setTime(new Random().nextDouble() + 1.0);
                    movie.setReleaseDate(new Date());
                    movie.setCategory(categoryRepository.findAll().get(new Random().nextInt(categoryRepository.findAll().size())));
                    movie.setImage(movie.getTitle()+".jpg");
                    movieRepository.save(movie);
                });
    }

    @Override
    public void initProjections() {
        List<Movie> movies = movieRepository.findAll();
        cityRepository.findAll().forEach(city -> {
            city.getCinemas().forEach(cinema -> {
                cinema.getRooms().forEach(room -> {
                    int index = new Random().nextInt(movies.size());
                    Movie movie = movies.get(index);
                        seanceRepository.findAll().forEach(seance -> {
                            Projection projection = new Projection();
                            projection.setMovie(movie);
                            projection.setPrice(new Random().nextDouble() * 50);
                            projection.setSeance(seance);
                            projection.setRoom(room);
                            projectionRepository.save(projection);
                        });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getRoom().getSeats().forEach(seat -> {
                Ticket ticket = new Ticket();
                ticket.setProjection(projection);
                ticket.setSeat(seat);
                ticket.setPrice(projection.getPrice());
                ticket.setTaken(false);
                ticketRepository.save(ticket);
            });
        });
    }
}
