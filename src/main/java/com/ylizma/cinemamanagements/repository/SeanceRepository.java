package com.ylizma.cinemamanagements.repository;

import com.ylizma.cinemamanagements.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
