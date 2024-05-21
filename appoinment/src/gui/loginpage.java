package gui;

import adminpage.AdminHome;
import adminpage.AdminPageController;
import adminpage.ScheduleTable;
import adminpage.User;
import constant.commonconstant;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;


public class loginpage extends form {
    private String email;
    private String password;
    private User loggeduser;
    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private String sex;
    private int age;
    private long number;
    private String address;
    private int id;
    public loginpage(){
        super("MedCare Login");
        addGuiComponents();

    }
//
    private void addGuiComponents(){
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logotransparent.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(55, 30, 300, 300); // Adjust the position and size as needed
        add(logoLabel);

        //Greetings
        JLabel greetlabel = new JLabel("Welcome back!");
        greetlabel.setBounds(230, 115, 520, 100);
        greetlabel.setForeground(commonconstant.DARKERBLUE_REG );
        greetlabel.setFont(new Font("Rockwell", Font.BOLD, 47));
        greetlabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(greetlabel);

        //Login
        JLabel loginlabel = new JLabel("MedCare Login");

        loginlabel.setBounds(170, 170, 520, 100);
        loginlabel.setForeground(commonconstant.DARKERBLUE_REG );
        loginlabel.setFont(new Font("Rockwell", Font.BOLD, 29));
        loginlabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(loginlabel);

        //username label for the users that have registered account
        JLabel usernamelabel = new JLabel("Email:");
        usernamelabel.setBounds(270, 283, 400, 25);
        usernamelabel.setForeground(commonconstant.TEXT_COLOR);
        usernamelabel.setFont(new Font("Dialog", Font.PLAIN, 17));

        JTextField usernameField = new JTextField();
        usernameField.setBounds(270, 313, 300, 30);
        usernameField.setBackground(commonconstant.SECONDARY_COLOR);
        usernameField.setForeground(commonconstant.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 15));

        add(usernamelabel);
        add(usernameField);

        //password label
        JLabel passwordlabel = new JLabel("Password:");

        passwordlabel.setBounds(270, 360, 400, 25);
        passwordlabel.setFont(new Font("Dialog",Font.PLAIN, 17));
        passwordlabel.setForeground(commonconstant.TEXT_COLOR);

        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(270, 390, 300, 30);
        passwordField.setBackground(commonconstant.SECONDARY_COLOR);
        passwordField.setForeground(commonconstant.TEXT_COLOR);

        passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));

        add(passwordlabel);
        add(passwordField);

        //for the login button
        JButton loginButton = new JButton("Login");
        loginButton.setForeground(commonconstant.BLUE_COLOR);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 17));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(commonconstant.HOME_BG1_BLUE);
        loginButton.setBounds(465, 470, 100, 35);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //users database validation
                String email = usernameField.getText();
                String password = new String(passwordField.getPassword());
                typeAppointment appointment = new typeAppointment(id, loggedInLastName, loggedInFirstName, loggedInMiddleName,sex, age, number, address);


                if (MyJDBC.validateLogin(email, password)) {
                      appointment.handleSuccessfulLogin(email, password);

                    loginpage.this.dispose();
                    //new home(loggedInLastName, loggedInFirstName, loggedInMiddleName).setVisible(true);
                    JOptionPane.showMessageDialog(loginpage.this, "Login Successful!");
                } else if (admin(email, password)) {
                    new AdminHome().setVisible(true);
                    loginpage.this.dispose();
                    JOptionPane.showMessageDialog(loginpage.this, "WELCOME ADMIN");
                } else {
                    JOptionPane.showMessageDialog(loginpage.this, "Login Failed...");
                }
            }
        });
        add(loginButton);

        //for account registration

        JLabel registerALabel = new JLabel("Not a user?");
        registerALabel.setBounds(272, 475, 250, 25);
        registerALabel.setForeground(commonconstant.HOME_BG1_BLUE);
        add(registerALabel);

        JLabel registerLabel = new JLabel("<html><u>REGISTER HERE!</u></html>");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        registerLabel.setForeground(commonconstant.HOME_BG1_BLUE);

        //set mouse listener
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginpage.this.dispose();

                new register().setVisible(true);
            }
        });

        registerLabel.setBounds(260, 475, 250, 25);
        add(registerLabel);

        //Panel Transparent
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (255, 255, 255, 175));
        panel1.setBounds( 115, 85, 600, 480);   // Set the size and location of the panel
        add(panel1);  // Add the panel to the main container

        //background picture
        ImageIcon image = new ImageIcon("appoinment/src/image/hex3.png");
        JLabel image2 = new JLabel(image);
        image2.setBounds(0, 0, 900, 700); // Adjust the position and size as needed
        add(image2);
    }

    public boolean admin(String email, String password){
        if(email.matches("brylle@example.com") && password.matches("password")) return true;

        if (!email.matches("brylle@emaple.com"))    return false;
        if(!password.matches("password"))   return false;
        return true;
    }

}
