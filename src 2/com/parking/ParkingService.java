
package com.parking;
import java.util.concurrent.*;
import java.util.*;

public class ParkingService {
    private ParkingLot lot;
    private FeeStrategy feeStrategy;
    private Map<Integer, ParkingTicket> tickets = new ConcurrentHashMap<>();
    private int counter=1;

    public ParkingService(ParkingLot lot, FeeStrategy feeStrategy){
        this.lot=lot;
        this.feeStrategy=feeStrategy;
    }

    public int checkIn(Vehicle v){
        ParkingSpot s = lot.allocate(v);
        if(s==null) throw new RuntimeException("Full");
        ParkingTicket t = new ParkingTicket(counter, s);
        tickets.put(counter, t);
        return counter++;
    }

    public double checkOut(int id, VehicleType type){
        ParkingTicket t = tickets.get(id);
        t.close();
        lot.release(t.getSpot());
        double fee = feeStrategy.calculate(t, type);
        tickets.remove(id);
        return fee;
    }
}
