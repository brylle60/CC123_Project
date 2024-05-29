package db;


import constant.commonconstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NotificationManager {
    public static void storeAppointmentNotification(int appointmentId, String notificationMessage) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+commonconstant.NOTIFICATION+"(appointment_id, message, confirmed)"+" VALUES (?, ?, false)");
            statement.setInt(1, appointmentId);
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