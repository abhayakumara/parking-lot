package com.parking;

import com.parking.enums.VehicleType;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2, 2,2);
        Vehicle bike1 = new Vehicle(VehicleType.BIKE);
        bike1.setVehicleNumber(123);
        Vehicle bike2 = new Vehicle(VehicleType.BIKE);
        bike2.setVehicleNumber(345);

        Vehicle car1 = new Vehicle(VehicleType.CAR);
        car1.setVehicleNumber(1234);
        Vehicle car2 = new Vehicle(VehicleType.CAR);
        car2.setVehicleNumber(3456);

        Vehicle truck1 = new Vehicle(VehicleType.TRUCK);
        truck1.setVehicleNumber(34567);
        Vehicle truck2 = new Vehicle(VehicleType.TRUCK);
        truck2.setVehicleNumber(67898);

        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(truck2);

        Vehicle bike3 = new Vehicle(VehicleType.BIKE);
        bike3.setVehicleNumber(987);
        parkingLot.parkVehicle(bike3);

        parkingLot.unparkVehicle(bike3);

    }
}