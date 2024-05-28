package db;

import constant.commonconstant;

import java.sql.*;

public class fam_medDb {
    public static boolean register(String last_name, String first_name, String middle_name,String gender, int age, long number,String address){
        try{
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_USER);
            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + commonconstant.FAMILY_MED + "( last_name,first_name, middle_name, sex, age, number, address)" + "VALUES(?, ?, ?, ?, ?, ?, ?)");

            insertUser.setString(1, last_name);
            insertUser.setString(2, first_name);
            insertUser.setString(3, middle_name);
            insertUser.setString(4, middle_name);
            insertUser.setString(5, gender);
            insertUser.setInt(6,age);
            insertUser.setLong(7, number);
            insertUser.setString(8, address);
            insertUser.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean validateRegistretion(String last_name, String first_name){
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD, commonconstant.DB_USER);
            PreparedStatement validate = connection.prepareStatement("SELECT * FROM "+ commonconstant.FAMILY_MED +" WHERE last_name = ? AND first_name = ?");

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
