package doctors;

import constant.commonconstant;
import java.sql.*;
import java.time.LocalTime;
import constant.commonconstant;
import java.sql.*;

public class loginValidateDoc {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialization;
    private String gender;
    private String address;
    private long contactNumber;
    private int age;

    public static boolean loginValidateDoc(String email, String password) {
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


    }
