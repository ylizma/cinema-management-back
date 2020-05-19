package com.ylizma.cinemamanagements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private int paymentCode;
    private String clientName;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Projection projection;
}
