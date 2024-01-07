package com.joe.drone.dto.response;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
@Getter
public class MedicationResponse {
    private String name;
    private double weight;

    private String code;
    private String image;
}
