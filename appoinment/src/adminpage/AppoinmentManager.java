package adminpage;
import adminpage.schedules;
import constant.commonconstant;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class AppoinmentManager {

    public static List<schedules> getAppointmentsByUserId(int userId) {
        List<schedules> userAppointments = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + commonconstant.DB_USER_INFO + " WHERE user_id = ?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("m_i");
                LocalTime time = resultSet.getTime("time").toLocalTime();
                LocalDate date = resultSet.getDate("date").toLocalDate();

                String gender = resultSet.getString("gender");
                String address = resultSet.getString("adress");
                int number = resultSet.getInt("number");
                String Appoinment = resultSet.getString("Appointment");
                boolean cancel = resultSet.getBoolean("canceled");

                // Add more fields as needed from the database

               schedules schedule = new schedules(id, firstName, lastName, middleName, time, date, gender, address, number, Appoinment);
                // Retrieve other appointment fields as needed
                userAppointments.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAppointments;
    }

    // Add other appointment-related methods as needed
}