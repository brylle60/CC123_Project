package db;

import adminpage.User;
import constant.commonconstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    private static String password;

    public static boolean register(String username, String email, Boolean loggin){
        try{
            if (!checkuser(username)) {
                Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME,commonconstant.DB_PASSWORD);
                PreparedStatement insertUser = connection.prepareStatement("INSERT INTO "+ commonconstant.DB_TABLE_NAME+"(User_name,USer_email, user_password, logged_in_users)"+ "VALUES(?, ?, ?, ?)");
                insertUser.setString(1, username);
                insertUser.setString(2, email);
                insertUser.setString(3, password);
                insertUser.setBoolean(4, loggin);
                insertUser.executeUpdate();
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean checkuser(String username){
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement checkuserExist = connection.prepareStatement("SELECT * FROM "+ commonconstant.DB_TABLE_NAME+" WHERE User_name = ?");
            checkuserExist.setString(1, username);
            ResultSet resultSet = checkuserExist.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean validatelogin(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME,commonconstant.DB_PASSWORD);
            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO "+ commonconstant.DB_TABLE_NAME+"(idUser_Id, User_name, user_password, logged_in_users)"+ "VALUES(?, ?, ?)");

            PreparedStatement validate = connection.prepareStatement(
                    "SELECT * FROM "+ commonconstant.DB_TABLE_NAME +" WHERE User_name = ? AND user_password = ? AND logged_in_users = 1"
            );
            validate.setString(1, username);
            validate.setString(2, password);
            ResultSet result = validate.executeQuery();

            if (!result.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public static List<User> getLoggedInUsers() {
        List<User> loggedInUsers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT idUser_Id, User_name, User_email, user_password, logged_in_users FROM " + commonconstant.DB_TABLE_NAME + " WHERE logged_in_users = 1");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idUser_Id");
                String username = resultSet.getString("User_name");
                String email = resultSet.getString("User_email");
                String password = resultSet.getString("user_password");
                boolean isLoggedIn = resultSet.getBoolean("logged_in_users");

                User user = new User(id, username, email, password, isLoggedIn);
                loggedInUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedInUsers;
    }


}
