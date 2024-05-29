package db;


import constant.commonconstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NotificationManager {
    public static void storeAppointmentNotification(String last_name, String notificationMessage) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+commonconstant.NOTIFICATION+"(last_name, message, confirmed)"+" VALUES (?, ?, false)");
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
}