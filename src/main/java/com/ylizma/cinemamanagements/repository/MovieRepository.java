package com.ylizma.cinemamanagements.repository;

import com.ylizma.cinemamanagements.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
