package com.ylizma.cinemamanagements.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticket",types = {Ticket.class})
public interface TicketProjection {
    public Long getId();
    public Double getPrice();
    public Integer getPaymentCode();
    public String getClientName();
    public Seat getSeat();
    public boolean getTaken();

}
