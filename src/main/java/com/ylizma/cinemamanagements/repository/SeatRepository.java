package com.ylizma.cinemamanagements.repository;


import com.ylizma.cinemamanagements.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat,Long> {
}
