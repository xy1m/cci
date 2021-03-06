package com.xy1m.cci.oo.design.parkinglot;

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    @Override
    public boolean carFitInSpot(ParkingSpot spot) {
        return spot.spotSize == VehicleSize.Large || spot.spotSize == VehicleSize.Compact;
    }
}
