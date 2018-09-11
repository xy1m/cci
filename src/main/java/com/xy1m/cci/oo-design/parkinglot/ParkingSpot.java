package com.xy1m.oo.parkinglot;

public class ParkingSpot {

    Vehicle vehicle;
    VehicleSize spotSize;
    int row;
    int spotNumber;
    Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
        this.level = lvl;
        this.row = r;
        this.spotNumber = n;
        this.spotSize = s;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /**
     * 检测车位是否够大
     *
     * @param vehicle
     * @return
     */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.carFitInSpot(this);
    }

    /**
     * 停车
     *
     * @param v
     * @return
     */
    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        this.vehicle = v;
        v.parkInSpot(this);
        return true;
    }

    /**
     * 把车开走，通知level车位可用
     */
    public void removeVehicle() {
        level.spotFreed();
        this.vehicle = null;
    }
}
