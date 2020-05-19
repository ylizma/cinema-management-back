package com.ylizma.cinemamanagements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity(name = "projections")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date projection_date;
    private double price;
    @ManyToOne
    private Room rooms;
    @ManyToOne
    private Movie movie;
    @OneToMany(mappedBy = "projection")
    private Collection<Ticket> tickets;
    @ManyToOne
    private Seance seance;
}
