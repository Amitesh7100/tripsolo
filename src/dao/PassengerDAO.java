package dao;

import db.DBConnection;
import model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    // Generate PNR
    private String generatePNR() {
        return "TS" + System.currentTimeMillis() % 1000000;
    }

    // Book a passenger
    public boolean bookPassenger(Passenger p) {
        String insertSQL = "INSERT INTO passenger (pnr, name, age, gender, seats_booked, amount, status, bus_no, starting_point, ending_point) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String updateBusSQL = "UPDATE bus SET seats_booked = seats_booked + ?, available_seats = available_seats - ? WHERE bus_no = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // transaction block

            // Generate PNR and calculate fare
            String pnr = generatePNR();
            p.setPnr(pnr);

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                ps.setString(1, pnr);
                ps.setString(2, p.getName());
                ps.setInt(3, p.getAge());
                ps.setString(4, String.valueOf(p.getGender()));
                ps.setInt(5, p.getSeatsBooked());
                ps.setDouble(6, p.getAmount());
                ps.setString(7, p.getStatus());
                ps.setString(8, p.getBusNo());
                ps.setString(9, p.getStartingPoint());
                ps.setString(10, p.getEndingPoint());
                ps.executeUpdate();
            }

            try (PreparedStatement ps2 = conn.prepareStatement(updateBusSQL)) {
                ps2.setInt(1, p.getSeatsBooked());
                ps2.setInt(2, p.getSeatsBooked());
                ps2.setString(3, p.getBusNo());
                ps2.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Booking successful. PNR: " + pnr);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Booking failed: " + e.getMessage());
            return false;
        }
    }

    // View all passengers for a specific bus
    public List<Passenger> getPassengersByBus(String busNo) {
        List<Passenger> list = new ArrayList<>();
        String sql = "SELECT * FROM passenger WHERE bus_no = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, busNo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Passenger p = new Passenger(
                        rs.getString("pnr"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender").charAt(0),
                        rs.getInt("seats_booked"),
                        rs.getDouble("amount"),
                        rs.getString("status"),
                        rs.getString("bus_no"),
                        rs.getString("starting_point"),
                        rs.getString("ending_point")
                );
                p.setPassengerId(rs.getInt("passenger_id"));
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching passengers: " + e.getMessage());
        }

        return list;
    }
}
