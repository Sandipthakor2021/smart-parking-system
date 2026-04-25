
CREATE TABLE ParkingLot(id INT PRIMARY KEY);
CREATE TABLE ParkingFloor(id INT, lot_id INT, floor_no INT);
CREATE TABLE ParkingSpot(id INT, floor_id INT, type VARCHAR(10), available BOOLEAN);
CREATE TABLE Vehicle(id INT, number VARCHAR(20), type VARCHAR(10));
CREATE TABLE Ticket(id INT, vehicle_id INT, spot_id INT, entry_time TIMESTAMP, exit_time TIMESTAMP, fee DOUBLE);
