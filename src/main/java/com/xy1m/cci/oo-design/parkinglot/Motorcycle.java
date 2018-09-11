package com.zzp.oo.parkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motocycle;
    }

    @Override
    public boolean carFitInSpot(ParkingSpot spot) {
        return spot.spotSize == VehicleSize.Large || spot.spotSize == VehicleSize.Compact || spot.spotSize == VehicleSize.Motocycle;
    }
}
