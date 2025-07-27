package model;

public class Passenger {
    private int passengerId;
    private String pnr;
    private String name;
    private int age;
    private char gender;
    private int seatsBooked;
    private double amount;
    private String status; // CONFIRMED / WAITLISTED
    private String busNo;
    private String startingPoint;
    private String endingPoint;

    // Constructor
    public Passenger(String pnr, String name, int age, char gender, int seatsBooked,
                     double amount, String status, String busNo, String startingPoint, String endingPoint) {
        this.pnr = pnr;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.seatsBooked = seatsBooked;
        this.amount = amount;
        this.status = status;
        this.busNo = busNo;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    // Getters and Setters
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }

    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBusNo() { return busNo; }
    public void setBusNo(String busNo) { this.busNo = busNo; }

    public String getStartingPoint() { return startingPoint; }
    public void setStartingPoint(String startingPoint) { this.startingPoint = startingPoint; }

    public String getEndingPoint() { return endingPoint; }
    public void setEndingPoint(String endingPoint) { this.endingPoint = endingPoint; }

    // Optional: toString method
    @Override
    public String toString() {
        return "PNR: " + pnr +
                ", Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Seats: " + seatsBooked +
                ", Amount: ₹" + amount +
                ", Status: " + status +
                ", Bus No: " + busNo +
                ", Route: " + startingPoint + " → " + endingPoint;
    }
}
