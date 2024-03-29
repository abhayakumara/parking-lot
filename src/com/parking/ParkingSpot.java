package com.parking;

import com.parking.enums.ParkingSpotType;

import java.util.Objects;

public class ParkingSpot {

    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private boolean isAvailable;


    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return isAvailable == that.isAvailable && parkingSpotType == that.parkingSpotType && Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpotType, vehicle, isAvailable);
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotType=" + parkingSpotType +
                ", vehicle=" + vehicle +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
