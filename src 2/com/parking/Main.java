
package com.parking;
import java.util.*;

public class Main {
    public static void main(String[] args){
        ParkingFloor f1 = new ParkingFloor(1);
        f1.addSpot(new ParkingSpot(1, SpotType.SMALL));
        f1.addSpot(new ParkingSpot(2, SpotType.MEDIUM));
        f1.addSpot(new ParkingSpot(3, SpotType.LARGE));

        ParkingLot lot = new ParkingLot(List.of(f1));

        ParkingService service = new ParkingService(lot, new HourlyFeeStrategy());

        Vehicle v = new Vehicle("GJ01", VehicleType.CAR);
        int id = service.checkIn(v);
        try{ Thread.sleep(2000);}catch(Exception e){}
        System.out.println(service.checkOut(id, VehicleType.CAR));
    }
