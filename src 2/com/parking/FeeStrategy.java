
package com.parking;
public interface FeeStrategy {
    double calculate(ParkingTicket t, VehicleType type);
}
