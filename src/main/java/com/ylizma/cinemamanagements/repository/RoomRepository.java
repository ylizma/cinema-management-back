package com.ylizma.cinemamanagements.repository;

import com.ylizma.cinemamanagements.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room,Long> {
}
