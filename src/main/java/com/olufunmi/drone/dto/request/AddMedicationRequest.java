package com.joe.drone.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class AddMedicationRequest {
    private String name;
    private double weight;
    private String code;
    private String imageUrl;


}
