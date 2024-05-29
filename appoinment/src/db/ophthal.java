package db;

import constant.commonconstant;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ophthal {
    public static boolean register(String last_name, String first_name, String middle_name, String gender, int age, long number, String address, LocalTime time_appointment, LocalDate date_appointment){
        try{
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_DOCTORS);
            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + commonconstant.FAMILY_MED + "( last_name,first_name, middle_name, sex, age, number, address, time_appointment, date_appointment)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");


            insertUser.setString(1, last_name);
            insertUser.setString(2, first_name);
            insertUser.setString(3, middle_name);
            insertUser.setString(4, middle_name);
            insertUser.setString(5, gender);
            insertUser.setInt(6,age);
            insertUser.setLong(7, number);
            insertUser.setString(8, address);
            insertUser.setTime(9, Time.valueOf(time_appointment));
            insertUser.setDate(10, Date.valueOf(date_appointment));

            insertUser.executeUpdate();
            String notificationMessage = "New appointment booked: " + last_name;
            NotificationManager.storeAppointmentNotification(last_name, notificationMessage);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean validateRegistretion(String last_name, String first_name){
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement validate = connection.prepareStatement("SELECT * FROM "+ commonconstant.OPHTHAL +" WHERE last_name = ? AND first_name = ?");

            validate.setString(1, last_name);
            validate.setString(2, first_name);

            ResultSet result  = validate.executeQuery();
            if (result.isBeforeFirst()) {
                return true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
