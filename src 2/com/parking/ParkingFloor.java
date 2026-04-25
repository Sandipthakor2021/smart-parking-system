
package com.parking;
import java.util.*;

public class ParkingFloor {
    private int floorNo;
    private Map<SpotType, Queue<ParkingSpot>> freeSpots = new HashMap<>();

    public ParkingFloor(int floorNo){
        this.floorNo = floorNo;
        for(SpotType t: SpotType.values()){
            freeSpots.put(t, new LinkedList<>());
        }
    }

    public void addSpot(ParkingSpot spot){
        freeSpots.get(spot.getType()).offer(spot);
    }

    public ParkingSpot getSpot(VehicleType type){
        if(type==VehicleType.BIKE) return freeSpots.get(SpotType.SMALL).poll();
        if(type==VehicleType.CAR){
            ParkingSpot s = freeSpots.get(SpotType.MEDIUM).poll();
            if(s==null) s = freeSpots.get(SpotType.LARGE).poll();
            return s;
        }
        return freeSpots.get(SpotType.LARGE).poll();
    }

    public void releaseSpot(ParkingSpot spot){
        spot.free();
        freeSpots.get(spot.getType()).offer(spot);
    }
}
