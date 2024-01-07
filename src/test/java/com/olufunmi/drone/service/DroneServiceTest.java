package com.joe.drone.service;

import com.joe.drone.dto.request.DroneRegistrationRequest;
import com.joe.drone.dto.response.DroneResponse;
import com.joe.drone.exceptions.DroneException;
import com.joe.drone.model.enums.DroneModel;
import com.joe.drone.service.droneService.DroneService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DroneServiceTest {
    @Autowired
    private DroneService droneService;

    @Test
    @DisplayName("Register a drone")
    void testThatADroneCanBeRegister() throws DroneException {
        DroneRegistrationRequest droneRegistrationRequest = new DroneRegistrationRequest();
        droneRegistrationRequest.setSerialNumber("BIG023");
        droneRegistrationRequest.setDroneModel(DroneModel.LIGHTWEIGHT);
//        droneRegistrationRequest.s(386);
        droneRegistrationRequest.setBatteryLevel(95);
        DroneResponse response = droneService.registerDrone(droneRegistrationRequest);
        assertNotNull(response);
    }
//    @Test
//    @DisplayName("To load a drone")
//    void testThatADroneCanLoadedWithMedication(){
//       LoadDroneRequest loadDroneRequest = new LoadDroneRequest();
//       loadDroneRequest.setSerialNumber("QWRTYU567");
//       loadDroneRequest.setName("Plaza");
//       loadDroneRequest.setImage("IMG234");
//       loadDroneRequest.setWeight(354);
//      LoadDroneResponse response = droneService.loadDrone(loadDroneRequest);
//      assertNotNull(response);



//   }

}