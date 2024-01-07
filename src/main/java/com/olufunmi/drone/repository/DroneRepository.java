package com.joe.drone.repository;

import com.joe.drone.model.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Optional <Drone> findBySerialNumber(String id);

    @Query(value = "select * from drones where drone_state = 'LOADING' or drone_state = 'IDLE' ", nativeQuery = true)
    List<Drone> findByAvailableDroneByState();

//    List<Drone> findAllByState( DroneState droneState);
}
