package com.joe.drone.dto.response;

import com.joe.drone.model.Drone;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDroneResponse {
    private  String status;
    private List<Drone>drones;
}
