package model;

public class Bus {
    private String busNo;
    private int capacity;
    private int seatsBooked;
    private int availableSeats;
    private String startingPoint;
    private String endingPoint;
    private double price;
    private int travelTime; // in minutes

    // Constructor
    public Bus(String busNo, int capacity, int seatsBooked, String startingPoint,
               String endingPoint, double price, int travelTime) {
        this.busNo = busNo;
        this.capacity = capacity;
        this.seatsBooked = seatsBooked;
        this.availableSeats = capacity - seatsBooked;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.price = price;
        this.travelTime = travelTime;
    }

    // Getters and Setters
    public String getBusNo() { return busNo; }
    public void setBusNo(String busNo) { this.busNo = busNo; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
        this.availableSeats = this.capacity - this.seatsBooked;
    }

    public int getAvailableSeats() { return availableSeats; }

    public String getStartingPoint() { return startingPoint; }
    public void setStartingPoint(String startingPoint) { this.startingPoint = startingPoint; }

    public String getEndingPoint() { return endingPoint; }
    public void setEndingPoint(String endingPoint) { this.endingPoint = endingPoint; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getTravelTime() { return travelTime; }
    public void setTravelTime(int travelTime) { this.travelTime = travelTime; }

    // Optional: toString method
    @Override
    public String toString() {
        int hours = travelTime / 60;
        int minutes = travelTime % 60;
        return "Bus No: " + busNo +
                ", Route: " + startingPoint + " to " + endingPoint +
                ", Capacity: " + capacity +
                ", Seats Booked: " + seatsBooked +
                ", Available: " + availableSeats +
                ", Price: ₹" + price +
                ", Duration: " + hours + "h " + minutes + "m";
    }
}
