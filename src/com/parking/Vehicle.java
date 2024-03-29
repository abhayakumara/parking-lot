package com.parking;

import com.parking.enums.VehicleType;

import java.util.Objects;

public class Vehicle {
    private int vehicleNumber;
    private VehicleType vehicleType;

    private ParkingSpot parkingSpot;

    Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleNumber == vehicle.vehicleNumber && vehicleType == vehicle.vehicleType && Objects.equals(parkingSpot, vehicle.parkingSpot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, vehicleType, parkingSpot);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber=" + vehicleNumber +
                ", vehicleType=" + vehicleType +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
