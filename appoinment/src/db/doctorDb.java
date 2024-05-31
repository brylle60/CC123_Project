package db;


import adminpage.User;
import adminpage.schedules;
import constant.commonconstant;
import doctors.doctorConstructor;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class doctorDb {
    // In the userDb class
    public static boolean book(String last_name, String first_name, String middle_name, int age, String sex, String Address, long number, LocalDate birthdate, String specialization, String email, String password) {
        try {
            if (checkuser(email)) {
                // Email already exists, handle accordingly
                System.out.println("Error: Email already exists");
                return false;
            } else {
                Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
                PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + commonconstant.DOCTOR_INFO + "(last_name,first_name, middle_name,age, birthdate, sex, specialization, number, email, password)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                insertUser.setString(1, last_name);
                insertUser.setString(2, first_name);
                insertUser.setString(3, middle_name);
                insertUser.setInt(4, age);
                insertUser.setDate(5, Date.valueOf(birthdate));
                insertUser.setString(6, sex);
                insertUser.setString(7, Address);
                insertUser.setLong(8, number);
                insertUser.setString(9, email);
                insertUser.setString(10, password);

                insertUser.executeUpdate(); // Change from executeQuery() to executeUpdate()

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

        public static boolean checkuser(String email){
            try {
                Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
                PreparedStatement checkuserExist = connection.prepareStatement("SELECT * FROM "+ commonconstant.DOCTOR_INFO+" WHERE email = ?");
                checkuserExist.setString(1, email);
                ResultSet resultSet = checkuserExist.executeQuery();
                if (resultSet.isBeforeFirst()){
                    return true; // Email exists
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return false; // Email does not exist
        }





    public static boolean validateLogin(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement validate = connection.prepareStatement(
                    "SELECT * FROM " + commonconstant.DOCTOR_INFO + " WHERE email = ? AND password = ?"
            );
            validate.setString(1, email);
            validate.setString(2, password);

            ResultSet result = validate.executeQuery();

            if (result.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }


    public static List<doctorConstructor> getLoggedInDoctors() {
        List<doctorConstructor> loggedInDoctors = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT id, last_name,first_name, middle_name,age,\" +\n" +
                    "                        \" birthdate, sex, specialization, number, email, password FROM " + commonconstant.DOCTOR_INFO);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String middle_name = resultSet.getString("middle_name");
                int age = resultSet.getInt("age");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                String sex = resultSet.getString("sex");
                String specialization = resultSet.getString("specialization");
                long number= resultSet.getLong("number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");


                doctorConstructor doctor = new doctorConstructor( last_name, first_name, middle_name, specialization,sex, number,age, password, email, birthdate);
                loggedInDoctors.add(doctor);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedInDoctors;
    }



}
