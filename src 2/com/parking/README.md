# 🚗 Smart Parking Lot System (Low-Level Design - Java)

## 📌 Overview

This project demonstrates the **Low-Level Design (LLD)** of a Smart Parking Lot backend system.
It efficiently manages vehicle entry/exit, parking spot allocation, real-time availability tracking, and fee calculation.

The design follows **Object-Oriented Principles (OOP)** and **SOLID principles**, ensuring scalability, maintainability, and extensibility.

---

## 🎯 Features

### ✅ Parking Spot Allocation

* Automatically assigns parking spots based on vehicle type:

  * **Bike → Small**
  * **Car → Medium (fallback to Large)**
  * **Truck → Large**
* Uses **O(1) allocation** with Queue-based structure.

---

### ✅ Multi-Floor Support

* Supports multiple parking floors.
* Each floor manages its own parking spots efficiently.

---

### ✅ Check-In / Check-Out

* Generates a parking ticket on entry.
* Tracks entry and exit timestamps.
* Frees the parking spot upon exit.

---

### ✅ Fee Calculation

* Fee calculated based on:

  * Parking duration
  * Vehicle type

| Vehicle Type | Price per Hour |
| ------------ | -------------- |
| Bike         | ₹10            |
| Car          | ₹20            |
| Truck        | ₹40            |

---

### ✅ Real-Time Availability

* Maintains live availability using:

  ```
  Map<SpotType, Queue<ParkingSpot>>
  ```
* No full scan required → high performance.

---

### ✅ Concurrency Handling

* Uses:

  * `ConcurrentHashMap`
* Designed to handle multiple vehicles entering/exiting simultaneously.

---

## 🧠 Design Principles Used

### 🔹 SOLID Principles

* **Single Responsibility Principle (SRP)**
  Each class has a clear purpose.

* **Open/Closed Principle (OCP)**
  Easily extendable (e.g., new pricing strategies).

* **Strategy Pattern**

  * `FeeStrategy`
  * (Allocation logic can also be extended)

---

## 🏗️ System Design

### 📦 Core Components

* `Vehicle`
* `ParkingSpot`
* `ParkingFloor`
* `ParkingLot`
* `ParkingTicket`
* `ParkingService`

---

### ⚙️ Flow

1. Vehicle enters parking lot
2. System allocates nearest available spot
3. Ticket is generated with entry time
4. Vehicle exits → ticket closed
5. Fee calculated → spot released

---

## ⚡ Algorithm Details

### 🔹 Spot Allocation

* Uses Queue:

  ```
  O(1) allocation
  ```
* Fallback logic for better utilization

---

### 🔹 Fee Calculation

* Based on:

  ```
  Duration = ExitTime - EntryTime
  ```

---

## 🗄️ Database Schema

```sql
ParkingLot(id)
ParkingFloor(id, lot_id, floor_no)
ParkingSpot(id, floor_id, type, available)
Vehicle(id, number, type)
ParkingTicket(id, vehicle_id, spot_id, entry_time, exit_time, fee)
```

---

## 🚀 How to Run

### 1. Compile

```bash
javac com/parking/*.java
```

### 2. Run

```bash
java com.parking.Main
```

---

## 🔮 Future Enhancements

* REST APIs using Spring Boot
* Database integration (MySQL + JPA)
* Redis for ultra-fast availability tracking
* Multi-entry/exit gates
* Reservation system
* Dynamic pricing (peak hours)

---

## 🧑‍💻 Author

**Sandip Thakor**

---

## 📌 Summary

This project demonstrates a **scalable, efficient, and extensible backend design** for a Smart Parking Lot system, suitable for real-world applications and technical interviews.
