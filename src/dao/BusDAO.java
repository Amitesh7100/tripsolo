package dao;

import db.DBConnection;
import model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    // 1. Insert new bus into DB
    public boolean insertBus(Bus bus) {
        String sql = "INSERT INTO bus (bus_no, capacity, seats_booked, available_seats, " +
                "starting_point, ending_point, price, travel_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bus.getBusNo());
            ps.setInt(2, bus.getCapacity());
            ps.setInt(3, bus.getSeatsBooked());
            ps.setInt(4, bus.getAvailableSeats());
            ps.setString(5, bus.getStartingPoint());
            ps.setString(6, bus.getEndingPoint());
            ps.setDouble(7, bus.getPrice());
            ps.setInt(8, bus.getTravelTime());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error inserting bus: " + e.getMessage());
            return false;
        }
    }

    // 2. Get all buses from DB
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM bus";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Bus bus = new Bus(
                        rs.getString("bus_no"),
                        rs.getInt("capacity"),
                        rs.getInt("seats_booked"),
                        rs.getString("starting_point"),
                        rs.getString("ending_point"),
                        rs.getDouble("price"),
                        rs.getInt("travel_time")
                );
                buses.add(bus);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching buses: " + e.getMessage());
        }

        return buses;
    }
}
