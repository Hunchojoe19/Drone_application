package com.joe.drone.service.droneService;

import com.joe.drone.dto.response.*;
import com.joe.drone.dto.request.DroneRegistrationRequest;
import com.joe.drone.dto.request.LoadDroneRequest;
import com.joe.drone.exceptions.DroneException;
import com.joe.drone.model.Drone;

import java.util.List;

public interface DroneService {
    DroneResponse registerDrone (DroneRegistrationRequest droneRegistrationRequest) throws DroneException;
    LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) throws DroneException;

    List <MedicationResponse> checkLoadedMedications(String serialNumber) throws DroneException;
    List<DroneResponse> viewAvailableDrone();
    BatteryResponse batteryCheck(String serialNumber) throws DroneException;

    RemoveDroneResponse removeDrone(String serialNumber) throws DroneException;
}




