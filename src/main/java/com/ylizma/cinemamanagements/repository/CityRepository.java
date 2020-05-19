package com.ylizma.cinemamanagements.repository;

import com.ylizma.cinemamanagements.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends JpaRepository<City,Long> {
}
