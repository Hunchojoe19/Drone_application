package com.joe.drone.model;

import com.joe.drone.model.enums.DroneModel;
import com.joe.drone.model.enums.DroneState;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Drones")
@Builder
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(length = 100)
    private  String serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModel droneModel;
    private final double WEIGHTLIMIT = 500.0;

    private double loadedWeight;
    private double batteryLevel;
    @Enumerated(EnumType.STRING)
    private DroneState droneState;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private List <Medication> medications ;

    public double cumulateLoadedWeight(){
        double loadedWeight = 0.0;
        if(medications.size() > 0) {
            for (Medication medication :
                    medications) {
                loadedWeight += medication.getWeight();
            }
        }
        return loadedWeight;
    }

}
