package com.joe.drone.exceptions;

public class LowBatteryException extends DroneException {
    public LowBatteryException(String message) {
        super(message);
    }

}
