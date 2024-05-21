package gui;

import adminpage.User;
import constant.commonconstant;
import db.MyJDBC;
import db.userDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;




public class typeAppointment extends homepage {
    private String email;
    private String password;
    private  User loggeduser;
    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age;
    private long number;
    private String address;
    private int id;
    public  String sex;
    private static final Logger logger = Logger.getLogger(Appoinment.class.getName());
    public static String selectedService;
    public static ButtonGroup service;
    public static String appointment;
    private JComboBox<String> comboBox;

    public typeAppointment(int id, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName,String sex, int age, long number, String address) {
        super("Types of Appointment");
        this.loggedInLastName = loggedInLastName;
        this.loggedInFirstName = loggedInFirstName;
        this.loggedInMiddleName = loggedInMiddleName;
        this.sex = sex;
        this.age = age;
        this.number = number;
        this.address = address;
        this.id = id;
        addGuiComponents();
    }
    private void addGuiComponents() {
        service = new ButtonGroup();

        ImageIcon logoIcon6= new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel6 = new JLabel(logoIcon6);
        logoLabel6.setBounds(10, -80, 150, 300); // Adjust the position and size as needed
        add(logoLabel6);



        JLabel comment1 = new JLabel("OUR SERVICES");
        comment1.setBounds(220, -160, 800, 450);
        comment1.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment1.setFont(new Font("Dialog", Font.BOLD, 50));
        comment1.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment1);

        JLabel comment2 = new JLabel("My health Clinic is a multi-speciality,full service clinic that serves a wide range of services.");
        comment2.setBounds(210, -120, 800, 450);
        comment2.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment2.setFont(new Font("Dialog",Font.PLAIN, 18));
        comment2.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment2);

        JLabel comment3 = new JLabel("Please select what type of services do you want!");
        comment3.setBounds(315, 60, 600, 150);
        comment3.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment3.setFont(new Font("Dialog", Font.BOLD, 18));
        comment3.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment3);


        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/Logo 3.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(-320, -240, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel);

        ImageIcon logoIcon1 = new ImageIcon("appoinment/src/image/Logo 2.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel1 = new JLabel(logoIcon1);
        logoLabel1.setBounds(-70, -240, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel1);

        ImageIcon logoIcon2 = new ImageIcon("appoinment/src/image/Logo 1.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel2 = new JLabel(logoIcon2);
        logoLabel2.setBounds(230, -240, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel2);

        ImageIcon logoIcon3 = new ImageIcon("appoinment/src/image/logo4.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel3 = new JLabel(logoIcon3);
        logoLabel3.setBounds(550, -240, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel3);

        JCheckBox checkBox = new JCheckBox("General Consultation");
        checkBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        checkBox.setForeground(commonconstant.TEXT_COLOR);
        checkBox.setBounds(70, 340, 220, 25);
        checkBox.setOpaque(false);
        add(checkBox);
        service.add(checkBox);

        JCheckBox checkBox1 = new JCheckBox("Laboratory and Diagnostics");
        checkBox1.setFont(new Font("Dialog", Font.PLAIN, 18));
        checkBox1.setForeground(commonconstant.TEXT_COLOR);
        checkBox1.setBounds(320, 340, 280, 25);
        checkBox1.setOpaque(false);

        add(checkBox1);
        service.add(checkBox1);

        JCheckBox checkBox2 = new JCheckBox("Rehabilitation Medicine Services");
        checkBox2.setFont(new Font("Dialog", Font.PLAIN, 18));
        checkBox2.setForeground(commonconstant.TEXT_COLOR);
        checkBox2.setBounds(600, 340, 300, 25);
        checkBox2.setOpaque(false);

        add(checkBox2);
        service.add(checkBox2);

        JCheckBox checkBox3 = new JCheckBox("Online Consultation Services");
        checkBox3.setFont(new Font("Dialog", Font.PLAIN, 18));
        checkBox3.setForeground(commonconstant.TEXT_COLOR);
        checkBox3.setBounds(935, 340, 300, 25);
        checkBox3.setOpaque(false);
        add(checkBox3);
        service.add(checkBox3);

        JLabel comment = new JLabel("for whom?");
        comment.setBounds(70, 333, 600, 150);
        comment.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment.setFont(new Font("Dialog", Font.PLAIN, 15));
        comment.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment);


// Add similar ItemListeners for checkBox2 and checkBox3

        String[] appointmentType = {
                "For myself",
                "Parent",
                "Child",
                "Spouse",
                "Relatives",
                "Friend",
        };


         comboBox = new JComboBox<>(appointmentType);
        comboBox.setFont(new Font("Dialog", Font.PLAIN,25));
        comboBox.setForeground(commonconstant.TEXT_COLOR);
        comboBox.setBounds(325, 420, 250, 30);
        add(comboBox);


        JButton Submit = new JButton("SUBMIT");
        Submit.setFont(new Font("Dialog", Font.BOLD, 18));
        Submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Submit.setForeground(commonconstant.TEXT_COLOR);


        // In the typeAppointment class
        Submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if (selectedService != null) {
                        typeAppointment.this.dispose();
                        // Appoinment appoinment = new Appoinment(loggedInLastName, loggedInFirstName, loggedInMiddleName);
                        //appoinment.setAppointmentType(selectedService);
                        //appoinment.setVisible(true);
                    } else {
                        logger.warning("No appointment type selected");
                        JOptionPane.showMessageDialog(typeAppointment.this, "Please select an appointment type");
                    }
            }
        });
        Submit.addActionListener(e -> submitAppointment());
        Submit.setBounds(660, 500, 180, 30);
        //reserved space for database

        add(Submit);



        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (225, 255, 255, 150));
        // Set the size and location of the panel
        panel1.setBounds( 0, 180, 1250, 400);

        // Add the panel to the main container
        add(panel1);



        ImageIcon logoIcon5= new ImageIcon("appoinment/src/image/medicalbg.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel5 = new JLabel(logoIcon5);
        logoLabel5.setBounds(0, 0, 1250, 800); // Adjust the position and size as needed
        add(logoLabel5);





    }

    // Add this method
    public void submitAppointment() {
        selectedService = null; // Reset selectedService

        for (Enumeration<AbstractButton> buttons = service.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button instanceof JCheckBox && ((JCheckBox) button).isSelected()) {
                selectedService = ((JCheckBox) button).getText();
                break;
            }
        }
        if (comboBox.getSelectedItem().equals("For myself")) {
            typeAppointment.this.dispose();
            Appoinment appoinment = new Appoinment(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, address);
            appoinment.setAppointmentType(selectedService);
            appoinment.setVisible(true);

        if (selectedService != null) {
            typeAppointment.this.dispose();

            loginpage login = new loginpage();
            handleSuccessfulLogin(email, password);
            appoinment.setAppointmentType(selectedService);
            appoinment.setVisible(true);
        } else {
            logger.warning("No appointment type selected");
            JOptionPane.showMessageDialog(typeAppointment.this, "Please select an appointment type");
        }

        }else {
            typeAppointment.this.dispose();
            new OtherAppointment().setVisible(true);
        }
     }
    public void handleSuccessfulLogin(String email, String password) {
        // Retrieve user information from the database
        User loggedInUser = getUserFromDatabase(email, password);


        if (loggedInUser != null) {
            // Create an instance of the Appoinment class with the logged-in user's information

            new home(loggedInUser.getid(),loggedInUser.getLast_name(), loggedInUser.getFirst_name(),loggedInUser.getMiddle_name(),loggedInUser.getSex(), loggedInUser.getAge(), loggedInUser.getNumber(), loggedInUser.getAddress()).setVisible(true);

          //  new Appoinment(loggedInUser.getLast_name(), loggedInUser.getFirst_name(), loggedInUser.getMiddle_name()).setVisible(true);

//            // Dispose of the login page
//  this.dispose();
      } //else {
////            // Handle the case where the user is not found in the database
//            JOptionPane.showMessageDialog(this, "Invalid email or password.");
//        }
    }

    private User getUserFromDatabase(String email, String password) {
        try {
            // Check if the user exists and is logged in
            if (MyJDBC.validateLogin(email, password)) {
                Connection connection = DriverManager.getConnection(commonconstant.DB_URL, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT idUser_Id, last_name, middle_name, first_name, sex, age, mobile_number, address, birthdate FROM " + commonconstant.DB_TABLE_NAME + " WHERE User_email = ? AND user_password = ?");
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int Id = resultSet.getInt("idUser_Id");
                    String lastName = resultSet.getString("last_name");
                    String firstName = resultSet.getString("first_name");
                    String middleName = resultSet.getString("middle_name");
                    String sex = resultSet.getString("sex");
                    int age = resultSet.getInt("age");
                    long mobileNumber = resultSet.getLong("mobile_number");
                    String address = resultSet.getString("address");
                    LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                    boolean logged = true;

                    // Create and return a User object with the retrieved information
                    return new User(Id, lastName, firstName, middleName, sex, age, mobileNumber, email, password, address, birthdate, logged);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If the user is not found or an error occurs, return null
        return null;
    }
    }



