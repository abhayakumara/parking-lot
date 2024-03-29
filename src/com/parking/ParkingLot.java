package com.parking;

import com.parking.enums.ParkingSpotType;
import com.parking.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.parking.utils.Constants.*;

public class ParkingLot {
    List<SmallSpot> smallSpots = new ArrayList<>();
    List<CompactSpot> compactSpots = new ArrayList<>();
    List<LargeSpot> largeSpots = new ArrayList<>();

    private int freeSmallSpots;
    private int freeCompactSpots;
    private int freeLargeSpots;

    public ParkingLot(int freeSmallSpots, int freeCompactSpots, int freeLargeSpots) {
        this.freeSmallSpots = freeSmallSpots;
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
    }


    //Park Vehicle
    public void parkVehicle(Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if(freeSmallSpots > 0) {
                parkSmallVehicle(vehicle);
            } else if(freeCompactSpots > 0) {
                parkCompactVehicle(vehicle);
            } else if(freeLargeSpots > 0) {
                parkLargeVehicle(vehicle);
            } else {
                System.out.println(NO_SPOTS + vehicle.getVehicleNumber());
            }

        } else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if(freeCompactSpots > 0) {
                parkCompactVehicle(vehicle);
            } else if(freeLargeSpots > 0) {
                parkLargeVehicle(vehicle);
            } else {
                System.out.println(NO_SPOTS + vehicle.getVehicleNumber());
            }

        } else if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if(freeLargeSpots > 0) {
                parkLargeVehicle(vehicle);
            } else {
                System.out.println(NO_SPOTS + vehicle.getVehicleNumber());
            }
        }
        printAvailableSpots();
    }

    private void parkLargeVehicle(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setAvailable(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);
        freeLargeSpots--;
        largeSpots.add(largeSpot);
        System.out.println(PARKED +
                vehicle.getVehicleNumber());
    }

    private void parkCompactVehicle(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setAvailable(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);
        freeCompactSpots--;
        compactSpots.add(compactSpot);
        System.out.println(PARKED +
                vehicle.getVehicleNumber());
    }

    private void parkSmallVehicle(Vehicle vehicle) {
        SmallSpot smallSpot = new SmallSpot(ParkingSpotType.SMALL);
        smallSpot.setAvailable(false);
        smallSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(smallSpot);
        freeSmallSpots--;
        smallSpots.add(smallSpot);
        System.out.println(PARKED +
                vehicle.getVehicleNumber());
    }


    //Unpark Vehicle
    public void unparkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        if(Objects.nonNull(parkingSpot)) {
            parkingSpot.setAvailable(true);
        }

        if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if(smallSpots.remove(parkingSpot)) {
                freeSmallSpots++;
                System.out.println(UNPARKED+
                        vehicle.getVehicleNumber());
            } else {
                System.out.printf(NO_VEHICLE,
                        vehicle.getVehicleNumber());
            }

        } else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if(compactSpots.remove(parkingSpot)) {
                freeCompactSpots++;
                System.out.println(UNPARKED+
                        vehicle.getVehicleNumber());
            } else {
                System.out.printf(NO_VEHICLE,
                        vehicle.getVehicleNumber());
            }

        } else if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if(largeSpots.remove(parkingSpot)) {
                freeLargeSpots++;
                System.out.println(UNPARKED+
                        vehicle.getVehicleNumber());
            } else {
                System.out.printf(NO_VEHICLE,
                        vehicle.getVehicleNumber());
            }
        }

        printAvailableSpots();
    }

    private void printAvailableSpots() {
        System.out.println(" Available small spots: " + freeSmallSpots);
        System.out.println(" Available compact spots: " + freeCompactSpots);
        System.out.println(" Available large spots: " + freeLargeSpots);
    }
}
