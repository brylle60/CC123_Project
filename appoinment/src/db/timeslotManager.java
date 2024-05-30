package db;

import TIMESLOTS.TimeSlots;
import constant.commonconstant;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class timeslotManager {
    public static int registerTimeSlot(int doctorId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + commonconstant.TIME_SLOTS + " (doctor_id, date, start_time, end_time, is_available) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, doctorId);
            statement.setDate(2, Date.valueOf(date));
            statement.setTime(3, Time.valueOf(startTime));
            statement.setTime(4, Time.valueOf(endTime));
            statement.setBoolean(5, true);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if there was an error
    }
    public static boolean updateTimeSlotAvailability(int slotId, boolean isAvailable) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE " + commonconstant.TIME_SLOTS + " SET is_available = ? WHERE id = ?");
            statement.setBoolean(1, isAvailable);
            statement.setInt(2, slotId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<TimeSlots> getAvailableTimeSlotsForDoctorAndDate(int doctorId, LocalDate date) {
        List<TimeSlots> availableSlots = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT doctor_id, start_time, end_time FROM " + commonconstant.TIME_SLOTS + " WHERE doctor_id = ? AND date = ? AND is_available = true");
            statement.setInt(1, doctorId);
            statement.setDate(2, Date.valueOf(date));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int slotId = resultSet.getInt("doctor_id");
                LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
                LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
                TimeSlots timeSlot = new TimeSlots(slotId, startTime, endTime, true);
                availableSlots.add(timeSlot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableSlots;
    }

    }