# 🚌 TripSolo - Bus Booking System

TripSolo is a simple Java-based command-line application to simulate a bus ticket booking system.  
It uses **JDBC + MySQL** for backend data operations and follows a modular architecture with **DAO**, **Service**, **UI**, and **DB** layers.

---

## 🚀 Features

- Add new buses with route, price, and capacity
- View all available buses
- Book tickets with passenger details
- View booked passengers per bus
- Auto-updates seat availability after booking

---

## 🧱 Tech Stack

- Java (Core)
- MySQL (JDBC)
- IntelliJ IDEA
- Git & GitHub

---

## 📁 Project Structure

src/
│
├── dao/
│ ├── BusDAO.java
│ └── PassengerDAO.java
│
├── db/
│ └── DBConnection.java
│
├── model/
│ ├── Bus.java
│ └── Passenger.java
│
├── service/
│ ├── BusService.java
│ └── PassengerService.java
│
└── ui/
└── Main.java

## ⚙️ Setup Instructions

1. Import project in IntelliJ
2. Create a MySQL database named `tripsolo`
3. Run `src/db/DBConnection.java` to connect
4. Execute SQL schema for buses and passengers (if any)
5. Run `Main.java`

---

## 🙋‍♂️ Author

- **Amitesh7100**
- [GitHub Profile](https://github.com/Amitesh7100)

---

## 📄 License

This project is open-source and free to use.
