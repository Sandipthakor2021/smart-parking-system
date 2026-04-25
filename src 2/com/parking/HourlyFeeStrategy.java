
package com.parking;
import java.time.*;

public class HourlyFeeStrategy implements FeeStrategy {
    public double calculate(ParkingTicket t, VehicleType type){
        long hrs = Duration.between(t.getEntry(), t.getExit()).toHours();
        if(hrs==0) hrs=1;
        int rate = switch(type){
            case BIKE -> 10;
            case CAR -> 20;
            case TRUCK -> 40;
        };
        return hrs * rate;
    }
}
