package com.joe.drone.service.medicationService;

import com.joe.drone.dto.request.AddMedicationRequest;
import com.joe.drone.model.Medication;
import com.joe.drone.repository.MedicationRepository;
import com.joe.drone.service.medicationService.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;

    @Override
    public Medication addMedication(AddMedicationRequest request) {

        Medication medication = Medication.builder()
                .image(request.getImageUrl())
                .code(request.getCode())
                .weight(request.getWeight())
                .name(request.getName())
                .build();
        medicationRepository.save(medication);
        return medication;
    }
}
