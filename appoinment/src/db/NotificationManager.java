package db;

import constant.commonconstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    public static void storeAppointmentNotification(String last_name, String notificationMessage) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + commonconstant.NOTIFICATION + "(last_name, message, confirmed)" + " VALUES (?, ?, false)");
            statement.setString(1, last_name);
            statement.setString(2, notificationMessage);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> getUserNotifications(String last_name) {
        List<String> notifications = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT message FROM " + commonconstant.NOTIFICATION + " WHERE last_name = ? AND confirmed = false");
            statement.setString(1, last_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String notificationText = resultSet.getString("message");
                notifications.add(notificationText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return notifications;
    }
}