package db;

import constant.commonconstant;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class fam_medDb {
    public static boolean register(String last_name, String first_name, String middle_name, String gender, int age, long number, String address, LocalTime time_appointment, LocalDate date_appointment) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + commonconstant.FAMILY_MED + "( last_name, first_name, middle_name, sex, age, number, address, time_appoitnment, date_appointment)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            insertUser.setString(1, last_name);
            insertUser.setString(2, first_name);
            insertUser.setString(3, middle_name);
            insertUser.setString(4, gender);
            insertUser.setInt(5, age);
            insertUser.setLong(6, number);
            insertUser.setString(7, address);
            insertUser.setTime(8, Time.valueOf(time_appointment));
            insertUser.setDate(9, Date.valueOf(date_appointment));

            int rowsInserted = insertUser.executeUpdate();
            if (rowsInserted > 0) {
                // Mark the booked time slot as unavailable
                PreparedStatement updateTimeSlot = connection.prepareStatement("UPDATE " + commonconstant.TIME_SLOTS+ " SET is_available = false WHERE date = ? AND start_time = ?");
                updateTimeSlot.setDate(1, Date.valueOf(date_appointment));
                updateTimeSlot.setTime(2, Time.valueOf(time_appointment));
                updateTimeSlot.executeUpdate();

                // Store the appointment notification
                String notificationMessage = "New appointment booked: " + last_name;
                NotificationManager.storeAppointmentNotification(last_name, notificationMessage);

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void addAvailableTimeSlots(int doctorId, LocalDate date, List<LocalTime> startTimes, List<LocalTime> endTimes) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + commonconstant.TIME_SLOTS + " (doctor_id, date, start_time, end_time, is_available) VALUES (?, ?, ?, ?, ?)");

            for (int i = 0; i < startTimes.size(); i++) {
                LocalTime startTime = startTimes.get(i);
                LocalTime endTime = endTimes.get(i);

                statement.setInt(1, doctorId);
                statement.setDate(2, Date.valueOf(date));
                statement.setTime(3, Time.valueOf(startTime));
                statement.setTime(4, Time.valueOf(endTime));
                statement.setBoolean(5, true);
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
