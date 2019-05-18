package com.Parking;

import java.util.Arrays;
import java.util.Date;

public class Vehicle {
    private String licensePlate;
    private Date parkingEntry;
    private Date parkingExit;
    private String type;
    public enum TypeVehicle{CAR,TIR}
    private int[] occupiedSeats;

    public Vehicle(String licensePlate, TypeVehicle typeVehicle) {
        this.licensePlate = licensePlate;
        this.type=typeVehicle.toString();
        this.occupiedSeats= new int[1];
    }

    public void setParkingEntry() {
        this.parkingEntry = new Date();
    }

    public long getParkingEntry() {
        return parkingEntry.getTime();
    }
    public void setParkingExit() {
        this.parkingExit = new Date();
    }

    public long getParkingExit() {
        return parkingExit.getTime();
    }

    public void setOccupiedSeats(int position) {
        this.occupiedSeats[0] = position;
    }

    public int getOccupiedSeats() {
        return occupiedSeats[0];
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicle " + type +
                " licensePlate='" + licensePlate + '\'' +
                ", occupiedSeats=" + Arrays.toString(occupiedSeats) +
                '}';
    }
}
