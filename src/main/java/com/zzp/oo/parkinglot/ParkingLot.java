package com.zzp.oo.parkinglot;

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    /**
     * 把车停入车位，返回是否成功
     *
     * @param vehicle
     * @return
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for (Level lvl : levels) {
            if (lvl.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}
