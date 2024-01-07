package com.joe.drone.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class BatteryResponse {
    private double batteryLevel;
    private String serialNumber;
    private String droneModel;

}
