package db;

import constant.commonconstant;

import java.sql.*;
import java.time.LocalTime;

public class timeslotManager {
    public static boolean timeRegister(LocalTime create_time, LocalTime update_time, String doctors) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_URL);
            PreparedStatement time = connection.prepareStatement("INSERT INTO " + commonconstant.TIME + "(create_time, update_time, doctors) VALUES (?, ?, ?)");
            time.setTime(1, Time.valueOf(create_time));
            time.setTime(2, Time.valueOf(update_time));
            time.setString(3, doctors);

            time.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateTimeSlot(int timeslotId, LocalTime create_time, LocalTime update_time, String doctors) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_URL);
            PreparedStatement time = connection.prepareStatement("UPDATE " + commonconstant.TIME + " SET create_time = ?, update_time = ?, doctors = ? WHERE id = ?");
            time.setTime(1, Time.valueOf(create_time));
            time.setTime(2, Time.valueOf(update_time));
            time.setString(3, doctors);
            time.setInt(4, timeslotId);

            time.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean removeTimeSlot(int timeslotId) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_URL);
            PreparedStatement time = connection.prepareStatement("DELETE FROM " + commonconstant.TIME + " WHERE id = ?");
            time.setInt(1, timeslotId);

            time.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}