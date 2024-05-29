package db;


import adminpage.User;
import adminpage.schedules;
import constant.TimeSlotManager;
import constant.commonconstant;
import gui.Appoinment;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class userDb {
    // In the userDb class
    public static boolean book(int id, String last_name, String first_name, String midlle_name, int age, LocalTime time, String Gender, String Address, long number, String appointment, boolean cacel, boolean finished) {
        try {
            if (TimeSlotManager.isTimeSlotAvailable(time)) {
                //if (!checkuser(id)) {
                    if (!isTimeSlotBooked(time)) {
                        Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
                        PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + commonconstant.DB_USER_INFO + "(user_id, last_name,first_name, m_i, age, time, gender, adress, number, Appointment, canceled, finished )" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        insertUser.setInt(1, id);
                        insertUser.setString(2, last_name);
                        insertUser.setString(3, first_name);
                        insertUser.setString(4, midlle_name);
                        insertUser.setInt(5, age);
                        insertUser.setTime(6, Time.valueOf(time));
                        insertUser.setString(7, Gender);
                        insertUser.setString(8, Address);
                        insertUser.setLong(9, number);
                        insertUser.setString(10, appointment);
                        insertUser.setBoolean(11, cacel);
                        insertUser.setBoolean(12, finished);

                        int rowsInserted = insertUser.executeUpdate();
                        if (rowsInserted > 0) {
                            // Book the time slot
                            TimeSlotManager.bookTimeSlot(time);
                            TimeSlotManager.removeTimeSlot(time);
//
                            // Store the appointment notification
                            String notificationMessage = "New appointment booked: " + first_name + " at " + time;
                            NotificationManager.storeAppointmentNotification(last_name, notificationMessage);

                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        // Time slot is not available
                        return false;
                    }
                }
            //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }    //check existing user
    public static boolean checkuser(int id){
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement checkuserExist = connection.prepareStatement("SELECT * FROM "+ commonconstant.DB_USER_INFO+" WHERE user_id = ?");
            checkuserExist.setInt(1, id);
            ResultSet resultSet = checkuserExist.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    public static boolean validateuser(int id, String last_name, String first_name, String midlle_name, LocalTime time, String Gender, String address, long number, String Appoinment, boolean cancel, int age, boolean finish) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            connection.prepareStatement("INSERT INTO " + commonconstant.DB_USER_INFO + "(user_id, last_name,first_name, m_i, age, time, gender, adress, number, Appointment, canceled, finished)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement validate = connection.prepareStatement(
                    "SELECT * FROM " + commonconstant.DB_USER_INFO + " WHERE user_id = ? AND last_name = ? AND first_name = ? AND m_i = ? AND age = ? AND time = ? AND gender = ? AND adress = ? And  number = ? AND Appointment = ? AND canceled = ? AND finished = ?"
            );
            validate.setInt(1, id);
            validate.setString(2, last_name);
            validate.setString(3, first_name);
            validate.setString(4, midlle_name);
            validate.setInt(5, age);
            validate.setTime(6, Time.valueOf(time));
            validate.setString(7, Gender);
            validate.setString(8, address);
            validate.setLong(9, number);
            validate.setString(10, Appoinment);
            validate.setBoolean(11, cancel);
            validate.setBoolean(12, finish);
            ResultSet result = validate.executeQuery();

            if (!result.isBeforeFirst()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
    public static boolean isTimeSlotBooked(LocalTime time) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement checkTimeSlot = connection.prepareStatement("SELECT COUNT(*) FROM " + commonconstant.DB_USER_INFO + " WHERE time = ? AND canceled = false");
            checkTimeSlot.setTime(1, Time.valueOf(time));
            ResultSet resultSet = checkTimeSlot.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            TimeSlotManager.removeTimeSlot(time);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean cancelAppointment(int userId, LocalTime appointmentTime) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement cancelStatement = connection.prepareStatement("UPDATE " + commonconstant.DB_USER_INFO + " SET canceled = ? WHERE user_id = ? AND time = ?");
            cancelStatement.setBoolean(1, true); // Set canceled to true
            cancelStatement.setInt(2, userId);
            cancelStatement.setTime(3, Time.valueOf(appointmentTime));
            int rowsAffected = cancelStatement.executeUpdate();
            if (rowsAffected > 0) {
                TimeSlotManager.freeTimeSlot(appointmentTime); // Update the available time slots
                TimeSlotManager.addTimeSlot(appointmentTime);
            //    TimeSlotManager.saveBookedTimeSlots(); // Save the updated booked time slots
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static List<schedules> getAppointment() {
        List<schedules> appointments = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, last_name, first_name, m_i, time, date, gender, adress, number, Appointment, canceled, finished FROM " + commonconstant.DB_USER_INFO
            );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String middle_name = resultSet.getString("m_i");
                LocalTime time = resultSet.getTime("time").toLocalTime();
                LocalDate date = resultSet.getDate("date").toLocalDate();
                String gender = resultSet.getString("Gender");
                String adress = resultSet.getString("adress");
                long number = resultSet.getLong("number");
                String Appointments = resultSet.getString("Appointment");
                boolean canceled = resultSet.getBoolean("canceled");
                boolean finished = resultSet.getBoolean("finished");

                //System.out.println("Retrieved appointment: " + user_id + ", " + last_name + ", " + first_name + ", " + middle_name + ", " + time + ", " + date + ", " + gender + ", " + adress + ", " + number + ", " + Appointments + ", " + canceled);


                // Skip canceled appointments and appointments with unavailable time slots
                if (canceled || !TimeSlotManager.isTimeSlotAvailable(time)) continue;
                if (finished) continue;


                schedules appointment = new schedules(user_id, last_name, first_name, middle_name, time, date, gender, adress, number, Appointments);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static List<schedules> getPastAppointments() {
        List<schedules> pastAppointments = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, last_name, first_name, m_i, time, date, gender, adress, number, Appointment, canceled, finished FROM " + commonconstant.DB_USER_INFO +
                            " WHERE canceled = true AND finished = true"
            );
           // statement.setInt(1, userId);
            //statement.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Current date

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve appointment details and create a schedules object
                int user_id = resultSet.getInt("user_id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String middle_name = resultSet.getString("m_i");
                LocalTime time = resultSet.getTime("time").toLocalTime();
                LocalDate date = resultSet.getDate("date").toLocalDate();
                String gender = resultSet.getString("Gender");
                String adress = resultSet.getString("adress");
                int number = resultSet.getInt("number");
                String Appointments = resultSet.getString("Appointment");
                boolean canceled = resultSet.getBoolean("canceled");
                schedules appointment = new schedules(user_id, last_name, first_name, middle_name, time, date, gender, adress, number, Appointments);
                pastAppointments.add(appointment);
                //System.out.println("Retrieved past appointment: " + appointment);
            }
           // System.out.println("Total past appointments retrieved: " + pastAppointments.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastAppointments;
    }

    public static void removeBookedTimeSlotsForUser(int userId) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT time FROM " + commonconstant.DB_USER_INFO + " WHERE user_id = ? AND canceled = false AND finished = false");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LocalTime bookedTime = resultSet.getTime("time").toLocalTime();
                TimeSlotManager.freeTimeSlot(bookedTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean finishAppointment(int userId, LocalTime appointmentTime) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USER, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement finishStatement = connection.prepareStatement("UPDATE " + commonconstant.DB_USER_INFO + " SET canceled = ?, finished = ? WHERE user_id = ? AND time = ?");
           finishStatement.setBoolean(1, true);
            finishStatement.setBoolean(1, true); // Set canceled to true
            finishStatement.setInt(2, userId);
            finishStatement.setTime(3, Time.valueOf(appointmentTime));
            int rowsAffected = finishStatement.executeUpdate();
            if (rowsAffected > 0) {
                TimeSlotManager.freeTimeSlot(appointmentTime); // Update the available time slots
                TimeSlotManager.addTimeSlot(appointmentTime);
                //    TimeSlotManager.saveBookedTimeSlots(); // Save the updated booked time slots
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
