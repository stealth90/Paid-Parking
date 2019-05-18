package com.Parking;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Parking {
    private int counterCars=0;
    private int counterTir=0;
    private int[] parkingSpaces;
    private int maxParkingSpaces;
    private int[] lastVehicleSeat= new int[1];

    public Parking(int maxParkingSpaces) {
        this.maxParkingSpaces = maxParkingSpaces;
        this.parkingSpaces= new int[maxParkingSpaces];
    }

    public boolean addVehicle(Vehicle vehicle){
        for(int i=0; i<this.parkingSpaces.length;i++){
            if(this.parkingSpaces[i]!=0)continue;
            else lastVehicleSeat[0]=i;
            if(vehicle.getType().equals("CAR")){
                this.parkingSpaces[i]=1;
                vehicle.setOccupiedSeats(i);
                lastVehicleSeat[0]=i;
                vehicle.setParkingEntry();
                counterCars++;
                return true;
            }
            else {
                for(int j=0;j<3;j++){
                    if(this.parkingSpaces[i+1]!=0 && this.parkingSpaces[i+2]!=0) return false;
                    else {this.parkingSpaces[i+j]=2;
                    }
                    vehicle.setOccupiedSeats(i);
                }
                counterTir++;
                vehicle.setParkingEntry();
                return true;
            }
        }
        return false;
    }
    public void removeVehicle(Vehicle vehicle){
        if(vehicle.getType().equals("CAR")){
            this.parkingSpaces[vehicle.getOccupiedSeats()]=0;
            counterCars--;
            vehicle.setParkingExit();
        }
        else{
            for(int i=0;i<3;i++){
                this.parkingSpaces[vehicle.getOccupiedSeats()+i]=0;
            }
            counterTir--;
            vehicle.setParkingExit();
        }
    }
    public double getPrice (Vehicle vehicle) {
        double price;
        long time = vehicle.getParkingEntry() - vehicle.getParkingExit();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        long minutes= TimeUnit.MILLISECONDS.toMinutes(time);
        System.out.println(hours + " " + minutes);
        if (minutes<120) price = minutes * 0.01;
        else if (minutes >= 120 && minutes <= 420) price = 2 + (minutes * 0.01);
        else price = 6.0;
        System.out.println("Your parking during "+ minutes + " minutes");
        return price;
    }

    @Override
    public String toString() {
        return "Parking : " +
                "There are =" + counterCars + " Cars"+
                "," + counterTir +" Tirs"+
                ". parkingSpaces=" + Arrays.toString(parkingSpaces) +
                ", maxParkingSpaces=" + maxParkingSpaces +
                ", lastVehicleSeat=" + Arrays.toString(lastVehicleSeat) +
                '}';
    }
}
