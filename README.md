# 🅿️ Parking Lot Management System

(Java Swing + JDBC + MySQL)

## 📌 Project Overview

The **Parking Lot Management System** is a desktop-based application designed to manage vehicle parking operations efficiently. It is developed using **Java Swing** for the graphical user interface, **JDBC** for database connectivity, and **MySQL** as the backend database.

This system allows users to park vehicles, assign parking slots, track vehicle entry and exit, and monitor parking status in real-time.

---

## 🚀 Key Features

* 🚗 Park vehicle (entry system)
* 📍 Automatic parking slot assignment
* 📋 View all parked vehicles
* 🚪 Exit vehicle and free parking slot
* ⏱️ Track entry and exit time
* 🔄 Automatic UI refresh after each operation

---

## 🛠️ Tech Stack

* **Java (Swing)** → GUI development
* **JDBC** → Database connectivity
* **MySQL** → Data storage

---

## 📁 Project Structure

```
DBConnection.java   → Handles database connection  
Dashboard.java      → Main interface  
ParkVehicle.java    → Vehicle entry  
ViewParking.java    → View parked vehicles  
ExitVehicle.java    → Vehicle exit  
Main.java           → Entry point  
```

---

## 🗄️ Database Configuration

```sql
CREATE DATABASE parking_db;
USE parking_db;

CREATE TABLE parking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_no VARCHAR(50),
    slot_no INT,
    entry_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    exit_time TIMESTAMP NULL,
    status VARCHAR(20)
);
```

---

## ▶️ How to Run the Project

1. Install and start MySQL server
2. Create the database using the SQL commands above
3. Add **MySQL Connector/J** to your Java project
4. Update database credentials in `DBConnection.java`
5. Compile and run `Main.java`

---

## 💾 Backup & Restore

### Export Database

```
mysqldump -u root -p parking_db > parking_db.sql
```

### Import Database

```
mysql -u root -p parking_db < parking_db.sql
```

---

## ⚠️ Important Notes

* Ensure MySQL server is running before executing the application
* Default username is `root` (update password if required)
* Parking slots are assigned sequentially

---

## 🎯 Future Improvements

* ♻️ Slot reuse mechanism
* 💰 Parking fee calculation system
* 📊 JTable-based UI
* 🔐 Login authentication system

---

## 👨‍💻 Author

Parking Lot Management System
Developed using Java Swing, JDBC, and MySQL
