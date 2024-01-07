package com.joe.drone.service.medicationService;

import com.joe.drone.dto.request.AddMedicationRequest;
import com.joe.drone.model.Medication;

public interface MedicationService {
    Medication addMedication(AddMedicationRequest request);
}
