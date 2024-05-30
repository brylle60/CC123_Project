package doctors;

import adminpage.AdminHome;
import constant.commonconstant;
import db.MyJDBC;
import gui.loginpage;
import db.MyJDBC.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginpageDoc extends doctors {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialization;
    private String sex;
    private String address;
    private long contactNumber;
    private int age;
    private int birthdate;

    public loginpageDoc(int id, String lastName, String firstName, String middleName, String specialization, String sex, String address, long contactNumber, int age) {
        super("MedCare Doctor's Login");
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.specialization = specialization;
        this.sex = sex;
        this.address = address;
        this.contactNumber = contactNumber;
        this.age = age;
        this.birthdate= birthdate;
        addGuiComponents();
    }

    private void addGuiComponents() {
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(55, 30, 300, 300);
        add(logoLabel);

        JLabel greetlabel = new JLabel("Welcome back!");
        greetlabel.setBounds(230, 115, 520, 100);
        greetlabel.setForeground(commonconstant.DARKERBLUE_REG);
        greetlabel.setFont(new Font("Rockwell", Font.BOLD, 47));
        greetlabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(greetlabel);

        JLabel loginlabel = new JLabel("MedCare Login");
        loginlabel.setBounds(170, 170, 520, 100);
        loginlabel.setForeground(commonconstant.DARKERBLUE_REG);
        loginlabel.setFont(new Font("Rockwell", Font.BOLD, 29));
        loginlabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginlabel);

        JLabel usernamelabel = new JLabel("Email:");
        usernamelabel.setBounds(270, 283, 400, 25);
        usernamelabel.setForeground(commonconstant.TEXT_COLOR);
        usernamelabel.setFont(new Font("Dialog", Font.PLAIN, 17));
        add(usernamelabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(270, 313, 300, 30);
        usernameField.setBackground(commonconstant.SECONDARY_COLOR);
        usernameField.setForeground(commonconstant.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(usernameField);

        JLabel passwordlabel = new JLabel("Password:");
        passwordlabel.setBounds(270, 360, 400, 25);
        passwordlabel.setFont(new Font("Dialog", Font.PLAIN, 17));
        passwordlabel.setForeground(commonconstant.TEXT_COLOR);
        add(passwordlabel);

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

                appointmentEachConstructor docConstructor = new appointmentEachConstructor(id, lastName, firstName, middleName, sex, specialization, address, contactNumber, age);

                if (MyJDBC.validateLogin(email, password)) {
                    // Handle successful login
                    loginpageDoc.this.dispose();
                    JOptionPane.showMessageDialog(loginpageDoc.this, "Login Successful!");
                } else if (admin(email, password)) {
                    new AdminHome().setVisible(true);
                    loginpageDoc.this.dispose();
                    JOptionPane.showMessageDialog(loginpageDoc.this, "WELCOME DOCTOR");
                } else {
                    JOptionPane.showMessageDialog(loginpageDoc.this, "Login Failed: invalid password and/or email.");
                }
            }
        });
        add(loginButton);

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

    public boolean admin(String email, String password) {
        return "brylle@example.com".equals(email) && "password".equals(password);
    }
}
