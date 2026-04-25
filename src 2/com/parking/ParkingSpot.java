
package com.parking;
public class ParkingSpot {
    private int id;
    private SpotType type;
    private boolean available = true;

    public ParkingSpot(int id, SpotType type){
        this.id=id; this.type=type;
    }
    public boolean isAvailable(){ return available; }
    public void occupy(){ available=false; }
    public void free(){ available=true; }
    public SpotType getType(){ return type; }
}
