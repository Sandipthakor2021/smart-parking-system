
package com.parking;
import java.time.*;

public class ParkingTicket {
    private int id;
    private ParkingSpot spot;
    private LocalDateTime entry;
    private LocalDateTime exit;

    public ParkingTicket(int id, ParkingSpot spot){
        this.id=id;
        this.spot=spot;
        this.entry=LocalDateTime.now();
    }

    public void close(){ this.exit=LocalDateTime.now(); }
    public LocalDateTime getEntry(){ return entry; }
    public LocalDateTime getExit(){ return exit; }
    public ParkingSpot getSpot(){ return spot; }
}
