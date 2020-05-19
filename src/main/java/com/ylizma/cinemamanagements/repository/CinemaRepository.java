package com.ylizma.cinemamanagements.repository;

import com.ylizma.cinemamanagements.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
}
