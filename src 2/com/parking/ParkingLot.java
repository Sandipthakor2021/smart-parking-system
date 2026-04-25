
package com.parking;
import java.util.*;

public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors){
        this.floors = floors;
    }

    public ParkingSpot allocate(Vehicle v){
        for(ParkingFloor f: floors){
            ParkingSpot s = f.getSpot(v.getType());
            if(s!=null){
                s.occupy();
                return s;
            }
        }
        return null;
    }

    public void release(ParkingSpot spot){
        for(ParkingFloor f: floors){
            f.releaseSpot(spot);
            return;
        }
    }
}
