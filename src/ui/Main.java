package ui;

import dao.BusDAO;
import dao.PassengerDAO;
import model.Bus;
import model.Passenger;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusDAO busDAO = new BusDAO();
        PassengerDAO passengerDAO = new PassengerDAO();

        int choice;

        do {
            System.out.println("\n==========================");
            System.out.println("🚌 TripSolo - Main Menu");
            System.out.println("==========================");
            System.out.println("1. Insert New Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Passengers for a Bus");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Bus No: ");
                    String busNo = scanner.nextLine().toUpperCase();
                    System.out.print("Capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Seats Booked: ");
                    int booked = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Start: ");
                    String start = scanner.nextLine().toUpperCase();
                    System.out.print("End: ");
                    String end = scanner.nextLine().toUpperCase();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Travel Time (mins): ");
                    int time = scanner.nextInt();

                    Bus bus = new Bus(busNo, capacity, booked, start, end, price, time);
                    boolean inserted = busDAO.insertBus(bus);
                    System.out.println(inserted ? "✅ Bus inserted." : "❌ Failed to insert.");
                    break;

                case 2:
                    List<Bus> buses = busDAO.getAllBuses();
                    if (buses.isEmpty()) {
                        System.out.println("No buses available.");
                    } else {
                        for (Bus b : buses) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Bus No to Book: ");
                    String selectedBusNo = scanner.nextLine().toUpperCase();
                    List<Bus> busList = busDAO.getAllBuses();
                    Bus selectedBus = null;
                    for (Bus b : busList) {
                        if (b.getBusNo().equalsIgnoreCase(selectedBusNo)) {
                            selectedBus = b;
                            break;
                        }
                    }

                    if (selectedBus == null) {
                        System.out.println("❌ Bus not found.");
                        break;
                    }

                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Gender (M/F): ");
                    char gender = scanner.next().toUpperCase().charAt(0);
                    System.out.print("Seats to Book: ");
                    int seats = scanner.nextInt();

                    if (seats > selectedBus.getAvailableSeats()) {
                        System.out.println("❌ Not enough seats.");
                        break;
                    }

                    double totalAmount = selectedBus.getPrice() * seats;
                    String status = "CONFIRMED";

                    Passenger passenger = new Passenger(null, name, age, gender, seats,
                            totalAmount, status, selectedBusNo,
                            selectedBus.getStartingPoint(), selectedBus.getEndingPoint());

                    passengerDAO.bookPassenger(passenger);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Enter Bus No: ");
                    String bno = scanner.nextLine().toUpperCase();
                    List<Passenger> passengers = passengerDAO.getPassengersByBus(bno);
                    if (passengers.isEmpty()) {
                        System.out.println("No passengers for this bus.");
                    } else {
                        for (Passenger p : passengers) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting TripSolo. Bye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
