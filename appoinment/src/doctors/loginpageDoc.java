package doctors;
import db.doctorDb;
import constant.commonconstant;
import gui.loginpage;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class loginpageDoc extends JFrame {
    private int id;
    private int age;
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialization;
    private String sex;
    private String address;
    private long contactNumber;
    private LocalDate birthdate;
private String password;
    public loginpageDoc() {
        super("MedCare Doctor's Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Prevent resizing
        setLayout(null);
        addGuiComponents();
    }

    private void addGuiComponents() {
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(55, 30, 300, 300);
        add(logoLabel);

        JLabel greetLabel = new JLabel("Welcome Doctor!");
        greetLabel.setBounds(230, 115, 520, 100);
        greetLabel.setForeground(commonconstant.DARKERBLUE_REG);
        greetLabel.setFont(new Font("Rockwell", Font.BOLD, 47));
        greetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(greetLabel);

        JLabel loginLabel = new JLabel("MedCare Doctor Login");
        loginLabel.setBounds(170, 170, 650, 100);
        loginLabel.setForeground(commonconstant.DARKERBLUE_REG);
        loginLabel.setFont(new Font("Rockwell", Font.BOLD, 29));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel usernameLabel = new JLabel("Email:");
        usernameLabel.setBounds(270, 283, 400, 25);
        usernameLabel.setForeground(commonconstant.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(270, 313, 300, 30);
        usernameField.setBackground(commonconstant.SECONDARY_COLOR);
        usernameField.setForeground(commonconstant.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(270, 360, 400, 25);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
        passwordLabel.setForeground(commonconstant.TEXT_COLOR);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(270, 390, 300, 30);
        passwordField.setBackground(commonconstant.SECONDARY_COLOR);
        passwordField.setForeground(commonconstant.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setForeground(commonconstant.BLUE_COLOR);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 17));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(commonconstant.HOME_BG1_BLUE);
        loginButton.setBounds(465, 470, 100, 35);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                String password = new String(passwordField.getPassword());
                DoctorHomePage homepage = new DoctorHomePage(lastName, firstName, middleName, sex, age, contactNumber, specialization);

                if (doctorDb.validateLogin(email, password)){
                    handleSuccessfulLogin(email, password);
                    loginpageDoc.this.dispose();
                    JOptionPane.showMessageDialog(loginpageDoc.this,"Logged in successfully");
                }else {
                    JOptionPane.showMessageDialog(loginpageDoc.this,"incorrect email or password");
                }

            }
        });
        add(loginButton);

       JButton back = new JButton("Return");
       back.setBounds(120, 540, 100, 20 );
       back.setBackground(commonconstant.BUTTON_COLOR);
       back.addActionListener(e->{

           loginpageDoc.this.dispose();
           new loginpage().setVisible(true);

       });
       add(back);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(255, 255, 255, 175));
        panel1.setBounds(115, 85, 600, 480);
        add(panel1);

        ImageIcon image = new ImageIcon("appoinment/src/image/hex3.png");
        JLabel image2 = new JLabel(image);
        image2.setBounds(0, 0, 900, 700);
        add(image2);
    }

    public void handleSuccessfulLogin(String email, String password) {
        // Retrieve user information from the database
       doctorConstructor loggedInDoctors = getDocFromDatabase(email, password);
        if (loggedInDoctors != null) {
            // Create an instance of the Appoinment class with the logged-in user's information

            new DoctorHomePage(loggedInDoctors.getLastName(), loggedInDoctors.getFirstName(),loggedInDoctors.getMiddleName(),loggedInDoctors.getSex(), loggedInDoctors.getAge(), loggedInDoctors.getContactNumber(), loggedInDoctors.getSpecialization()).setVisible(true);
        }
    }


    private doctorConstructor getDocFromDatabase(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_DOCTORS, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, last_name, first_name, middle_name, specialization, sex, age, number, birthdate " +
                            "FROM doctor_info " +
                            "WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String specialization = resultSet.getString("specialization");
                String sex = resultSet.getString("sex");
                 int age = resultSet.getInt("age");
                long contactNumber = resultSet.getLong("number");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();

                return new doctorConstructor(lastName, firstName, middleName, specialization, sex, contactNumber, age, password,email, birthdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;


    }




}