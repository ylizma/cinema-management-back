package com.ylizma.cinemamanagements.controller;


import com.ylizma.cinemamanagements.model.Movie;
import com.ylizma.cinemamanagements.model.Ticket;
import com.ylizma.cinemamanagements.repository.MovieRepository;
import com.ylizma.cinemamanagements.repository.TicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(value = "/img/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id") Long id) throws IOException {
        Movie movie = movieRepository.findById(id).get();
        String imageName = movie.getImage();
        File imageDirectory =  new File(System.getProperty("user.home")+"/javaProjects/cinemaImages/"+imageName+".jpg");
        Path path = Paths.get(imageDirectory.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping("/payTicket")
    @Transactional
    @CrossOrigin("*")
    public List<Ticket> payedTickets(@RequestBody TicketForm ticketForm){
        ticketForm.getTickets().forEach(id ->{
            Ticket ticket = ticketRepository.findById(id).get();
            ticket.setClientName(ticketForm.getClientName());
            ticket.setTaken(true);
            ticket.setPaymentCode(ticketForm.getPaymentId());
            ticketRepository.save(ticket);
        });
        List<Ticket> tickets = new ArrayList<>();
        return tickets;
    }
}

@Data
class TicketForm{
    private List<Long> tickets = new ArrayList<>();
    private String clientName;
    private int paymentId;
}
