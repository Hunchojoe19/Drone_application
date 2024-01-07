package com.joe.drone.dto.response;

import com.joe.drone.model.Medication;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoadDroneResponse {
    private String message;
    private Medication medication;


}
