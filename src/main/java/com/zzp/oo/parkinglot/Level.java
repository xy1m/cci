package com.zzp.oo.parkinglot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int numberSpots) {
        this.floor = floor;
        spots = new ParkingSpot[numberSpots];
        int largeSpots = numberSpots / 4;
        int motocycleSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - motocycleSpots;

        for (int i = 0; i < numberSpots; i++) {
            VehicleSize sz = VehicleSize.Motocycle;
            if (i < largeSpots) {
                sz = VehicleSize.Large;
            } else if (i < largeSpots + compactSpots) {
                sz = VehicleSize.Compact;
            }
            int row = i / SPOTS_PER_ROW;
            spots[i] = new ParkingSpot(this, row, i, sz);
        }
        availableSpots = numberSpots;
    }

    /**
     * 找车位停车
     *
     * @param vehicle
     * @return
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots < vehicle.spotsNeeded) return false;
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) return false;
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    /**
     * 把车停入指定车位，直到满足vehicle.spotsNeeded
     *
     * @param num
     * @param v
     * @return
     */
    private boolean parkStartingAtSpot(int num, Vehicle v) {
        v.clearSpot();
        boolean success = true;
        for (int i = num; i < num + v.spotsNeeded; i++) {
            success &= spots[i].park(v);
        }
        availableSpots -= v.spotsNeeded;
        return success;
    }

    /**
     * 找到车位号
     *
     * @param vehicle
     * @return
     */
    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.spotsNeeded;

        int lastRow = -1;
        int spotsFound = 0;

        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.row) {
                spotsFound = 0;
                lastRow = spot.row;
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - (spotsFound - 1);
            }
        }
        return -1;
    }

    /**
     * 车离开车位，增加可用车位
     */
    public void spotFreed() {
        availableSpots++;
    }
}
