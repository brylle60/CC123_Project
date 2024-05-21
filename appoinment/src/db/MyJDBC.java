package db;

import adminpage.User;
import constant.commonconstant;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    private static String password;

    public static boolean register(String last_name, String first_name, String middle_name, int age, long number, String email, String password, String address, LocalDate birthdate, Boolean loggin){
        try{
            if (!checkuser(last_name)) {
                Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME,commonconstant.DB_PASSWORD);
                PreparedStatement insertUser = connection.prepareStatement("INSERT INTO "+ commonconstant.DB_TABLE_NAME+"(last_name, middle_name, first_name, age, mobile_number,User_email, user_password, address, birthdate, logged_in_users)"+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                insertUser.setString(1, last_name);
                insertUser.setString(2, first_name);
                insertUser.setString(3, middle_name);
                insertUser.setInt(4, age);
                insertUser.setLong(5, number);
                insertUser.setString(6, email);
                insertUser.setString(7, password);
                insertUser.setString(8, address);
                insertUser.setDate(9, Date.valueOf(birthdate));
                insertUser.setBoolean(10, loggin);
                insertUser.executeUpdate();
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean checkuser(String last_name){
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement checkuserExist = connection.prepareStatement("SELECT * FROM "+ commonconstant.DB_TABLE_NAME+" WHERE last_name = ?");
            checkuserExist.setString(1, last_name);
            ResultSet resultSet = checkuserExist.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean validateLogin(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement validate = connection.prepareStatement(
                    "SELECT * FROM " + commonconstant.DB_TABLE_NAME + " WHERE User_email = ? AND user_password = ? AND logged_in_users = ?"
            );
            validate.setString(1, email);
            validate.setString(2, password);
            validate.setBoolean(3, true);

            ResultSet result = validate.executeQuery();

            if (result.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<User> getLoggedInUsers() {
        List<User> loggedInUsers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT last_name, middle_name, first_name, age, mobile_number,User_email, user_password, address, birthdate, logged_in_users FROM " + commonconstant.DB_TABLE_NAME + " WHERE logged_in_users = 1");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idUser_Id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String middle_name = resultSet.getString("middle_name");
                int age = resultSet.getInt("age");
                long number= resultSet.getLong("mobile_number");
                String email = resultSet.getString("User_email");
                String password = resultSet.getString("user_password");
                String adress = resultSet.getString("address");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                boolean isLoggedIn = resultSet.getBoolean("logged_in_users");

                User user = new User(id, last_name, first_name, middle_name, age, number,email, password, adress, birthdate, isLoggedIn);
                loggedInUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedInUsers;
    }


}
