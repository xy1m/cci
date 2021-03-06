package com.xy1m.cci.oo.design.parkinglot;

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }


    @Override
    public boolean carFitInSpot(ParkingSpot spot) {
        return spot.spotSize == VehicleSize.Large;
    }
}
