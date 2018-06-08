package com.zzp.oo.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    String licensePlate;
    int spotsNeeded;
    VehicleSize size;

    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    /**
     * Remove car from spot and notify spot that it's gone
     */
    public void clearSpot() {
        for (ParkingSpot spot : parkingSpots) {
            spot.removeVehicle();
        }
        parkingSpots.clear();
    }

    /**
     * 车位是否足够大并且可用，只比较大小
     *
     * @param spot
     * @return
     */
    public abstract boolean carFitInSpot(ParkingSpot spot);
}
