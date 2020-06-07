package com.ylizma.cinemamanagements.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "projection",types = {com.ylizma.cinemamanagements.model.Projection.class})
public interface IProjection {
    public Long getId();
    public double getPrice();
    public Date getProjectionDate();
    public Room getRoom();
    public Movie getMovie();
    public Seance getSeance();
    public Collection<Ticket> getTickets();
}
