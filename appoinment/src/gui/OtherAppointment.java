
package gui;


import adminpage.schedules;
import constant.commonconstant;
import constant.TimeSlotManager;
import db.userDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

import static db.userDb.book;


public class OtherAppointment extends homepage {
    private static final Logger logger = Logger.getLogger(Appoinment.class.getName());
    private LocalTime time;
    private JList<String> appointmentList;
    private DefaultListModel<String> listModel;
    private ButtonGroup appointmentTypeGroup;
    private JRadioButton selectedAppointmentType;
    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age1;
    private long number1;
    private String email;
    private String address;
    private int id1;
    private String appointmentType;
    public int id2;
    private String sex;

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    private LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    // Add other user information fields as needed

    public OtherAppointment(int id, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName, String sex, int age, long number, String email, String address) {
        super("Appointment Booking");

        this.loggedInLastName = loggedInLastName;
        this.loggedInFirstName = loggedInFirstName;
        this.loggedInMiddleName = loggedInMiddleName;
        this.sex = sex;
        this.age1 = age;
        this.number1 = number;
        this.address = address;
        this.id1 = id;
        this.email = email;
        addGuiComponents();
    }


    private void addGuiComponents() {
        time = getCurrentTime();



        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logotransparent.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(100, -30, 300, 300); // Adjust the position and size as needed


        JLabel Filllabel = new JLabel("Please Fill up this form!");
        Filllabel.setBounds(400, 60, 520, 100);
        Filllabel.setForeground(commonconstant.DARKERBLUE_REG );
        Filllabel.setFont(new Font("Rockwell", Font.BOLD, 40));
        Filllabel.setHorizontalAlignment(SwingConstants.CENTER);



        JButton home = new JButton("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 18));
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.SECONDARY_COLOR);
        home.setBackground(commonconstant.HOME_BG1_BLUE);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OtherAppointment.this.dispose();

                new home(id1, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age1, number1, email, address).setVisible(true);
            }
        });
        home.setBounds(1055, 50, 140, 30);
        //reserved space for database

        //new edit chelsie user profile 05-17-24

        JButton userProfile= new JButton("User Profile");
        userProfile.setFont(new Font("Dialog", Font.BOLD, 18));

        userProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userProfile.setForeground(commonconstant.SECONDARY_COLOR);
        userProfile.setBackground(commonconstant.HOME_BG1_BLUE);
        userProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                OtherAppointment.this.dispose();
                new UserProfile(id1, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age1, number1, address, email).setVisible(true);
            }
        });
//new edit change x loc
        userProfile.setBounds(1055, 100, 140,30);


        JButton ContactUs= new JButton("Contact Us");
        ContactUs.setFont(new Font("Dialog", Font.BOLD, 18));

        ContactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ContactUs.setForeground(commonconstant.SECONDARY_COLOR);
        ContactUs.setBackground(commonconstant.HOME_BG1_BLUE);
        //set mouse listener
        ContactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                OtherAppointment.this.dispose();
                new ContactUs().setVisible(true);

            }
        });

        ContactUs.setBounds(1055, 150, 140,30);

        add(ContactUs);
        add(userProfile);
        add(logoLabel);
        add(Filllabel);
        add(home);



        JLabel timeLabel = new JLabel("Select Time Slot:");
        timeLabel.setBounds(460, 190, 200, 25);
        timeLabel.setForeground(commonconstant.TEXT_COLOR);
        timeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

//
        JComboBox<LocalTime> timeComboBox1 = new JComboBox<>();
        timeComboBox1.setBounds(460, 220, 150, 25);
        timeComboBox1.setBackground(commonconstant.SECONDARY_COLOR);
        timeComboBox1.setForeground(commonconstant.TEXT_COLOR);
        timeComboBox1.setFont(new Font("Dialog", Font.PLAIN, 14));

        // Add available time slots to the combo box
        for (LocalTime time : TimeSlotManager.timeSlots.keySet()) {
            timeComboBox1.addItem(time);
        }

        add(timeLabel);
        add(timeComboBox1);

        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(150, 190, 300, 25);
        lastName .setForeground(commonconstant.TEXT_COLOR);
        lastName .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField lastNamefield = new JTextField();
        lastNamefield.setBounds(150, 220, 250, 25);
        lastNamefield.setBackground(commonconstant.SECONDARY_COLOR);
        lastNamefield.setForeground(commonconstant.TEXT_COLOR);
        lastNamefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(150, 245, 300, 25);
        firstname .setForeground(commonconstant.TEXT_COLOR);
        firstname .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField firstnamefield = new JTextField();
        firstnamefield.setBounds(150, 270, 250, 25);
        firstnamefield.setBackground(commonconstant.SECONDARY_COLOR);
        firstnamefield.setForeground(commonconstant.TEXT_COLOR);
        firstnamefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel MI = new JLabel("Middle Name");
        MI.setBounds(150, 295, 300, 25);
        MI.setForeground(commonconstant.TEXT_COLOR);
        MI.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Mifield = new JTextField();
        Mifield.setBounds(150, 322, 250, 25);
        Mifield.setBackground(commonconstant.SECONDARY_COLOR);
        Mifield.setForeground(commonconstant.TEXT_COLOR);
        Mifield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel age = new JLabel("Age");
        age.setBounds(150, 345, 300, 25);
        age.setForeground(commonconstant.TEXT_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField agefield = new JTextField();
        agefield.setBounds(150, 372, 150, 25);
        agefield.setBackground(commonconstant.SECONDARY_COLOR);
        agefield.setForeground(commonconstant.TEXT_COLOR);
        agefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel id = new JLabel("ID");
        id .setBounds(150, 395, 300, 25);
        id .setForeground(commonconstant.TEXT_COLOR);
        id .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField IdField = new JTextField();
        IdField.setBounds(150, 420, 150, 25);
        IdField.setBackground(commonconstant.SECONDARY_COLOR);
        IdField.setForeground(commonconstant.TEXT_COLOR);
        IdField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel gender = new JLabel("Gender");
        gender.setBounds(150, 445, 200, 25);
        gender.setForeground(commonconstant.TEXT_COLOR);
        gender.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField genderflield = new JTextField();
        genderflield.setBounds(150, 470, 150, 25);
        genderflield.setForeground(commonconstant.TEXT_COLOR);
        genderflield.setFont(new Font("Dialog",Font.PLAIN, 24));


        JLabel Address = new JLabel("Address");
        Address.setBounds(150, 495,300, 25);
        Address.setForeground(commonconstant.TEXT_COLOR);
        Address.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Addressfield = new JTextField();
        Addressfield.setBounds(150, 520, 350, 25);
        Addressfield.setForeground(commonconstant.TEXT_COLOR);
        Addressfield.setFont(new Font("Dialog",Font.PLAIN, 24));

        JLabel number = new JLabel("Mobile Number");
        number.setBounds(150, 545,300, 25);
        number.setForeground(commonconstant.TEXT_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField numberfield = new JTextField();
        numberfield.setBounds(150, 572, 350, 25);
        numberfield.setForeground(commonconstant.TEXT_COLOR);
        numberfield.setFont(new Font("Dialog",Font.PLAIN, 24));

        JLabel dashBoard = new JLabel("To days Dash Board");
        dashBoard.setBounds(750, 270,300, 25);
        dashBoard.setForeground(commonconstant.TEXT_COLOR);
        dashBoard.setFont(new Font("Dialog",Font.BOLD, 18));


        JPanel list = new JPanel();
        list.setLayout(new BorderLayout()); // Set the layout to null to allow positioning components manually
        list.setBounds(600, 300, 400, 170); // Set the bounds of the panel
        list.setBackground(commonconstant.HOME_BG1_GRAY);

        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(appointmentList);
        list.add(scrollPane);
        list.add(scrollPane, BorderLayout.CENTER);
        add(list, BorderLayout.CENTER);

        loadAppointments();

        add(dashBoard);
        add(lastName);
        add(lastNamefield);
        add(firstname);
        add(firstnamefield);
        add(MI);
        add(Mifield);
        add(age);
        add(agefield);
        add(id);
        add(IdField);
        add(gender);
        add(genderflield);
        add(Address);
        add(Addressfield);
        add(number);
        add(numberfield);


        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel();
        panel.add(panelLabel, BorderLayout.CENTER);
        panel.setBackground(new Color (255, 255, 255, 200));
        // Set the size and location of the panel

        panel.setBounds( 100, 50, 930, 600);


        add(panel); //white transparent bg


        add(panel);// White background transparent


        JPanel appointmentTypePanel = new JPanel();
        appointmentTypePanel.setBackground(commonconstant.BUTTON_COLOR);
        appointmentTypePanel.setLayout(new GridLayout(0, 1, 10, 10)); // Set layout for vertical arrangement
        appointmentTypePanel.setBounds(500, 200, 300, 200); // Set the position and size of the panel
        appointmentTypePanel.setVisible(false); // Initially make it invisible

//        // Create radio buttons for different appointment types
//        JRadioButton generalCheckup = new JRadioButton("General Checkup");
//        JRadioButton dentalCheckup = new JRadioButton("Dental Checkup");
//        JRadioButton eyeCheckup = new JRadioButton("Eye Checkup");
//// Add more radio buttons as needed
//
//// Add radio buttons to a ButtonGroup to ensure only one selection
//        appointmentTypeGroup = new ButtonGroup();
//        appointmentTypeGroup.add(generalCheckup);
//        appointmentTypeGroup.add(dentalCheckup);
//        appointmentTypeGroup.add(eyeCheckup);
//
//// Add radio buttons to the panel
//        appointmentTypePanel.add(generalCheckup);
//        appointmentTypePanel.add(dentalCheckup);
//        appointmentTypePanel.add(eyeCheckup);
//
//        add(appointmentTypePanel); // Add the panel to the main container
//        //reserved space for database

        JButton submitButton = new JButton("Book Appointment");

//
        //submitButton.addActionListener(e -> submitAppointment());// Add the button to the appointment type panel

        appointmentTypePanel.add(submitButton);

        JButton Booknow = new JButton("Register");
        Booknow.setForeground(commonconstant.TEXT_COLOR);
        Booknow.setFont(new Font("Dialog", Font.BOLD, 18));
        Booknow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Booknow.setForeground(commonconstant.TEXT_COLOR);
        Booknow.setBounds(740, 560, 200,50);

        Booknow.setBackground(commonconstant.BUTTON_COLOR);

        Booknow.setBounds(650, 530, 250, 50);

        Booknow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Database validation for users
                int Id = 0;
                String LastName = null;
                String firstname = null;
                String MI = null;
                int age = 0;
                String gender = null;
                String Address = null;
                long number = 0;


                LocalTime selectedTime;
                try {
                    Id = Integer.parseInt(IdField.getText());
                    LastName = lastNamefield.getText();
                    firstname = firstnamefield.getText();
                    MI = Mifield.getText();
                    age = Integer.parseInt(agefield.getText());
                    gender = genderflield.getText();
                    Address = Addressfield.getText();
                    number = Integer.parseInt(numberfield.getText());
                    //appointmentTypePanel.setVisible(true);



                } catch (NumberFormatException ex) {
                    logger.severe("Invalid input: " + ex.getMessage());
                    JOptionPane.showMessageDialog(OtherAppointment.this, "Error: Invalid input. Please enter valid values.");
                    return;
                }
                Boolean cancel = false;
                Boolean finish = false;
                selectedTime = (LocalTime) timeComboBox1.getSelectedItem();
                String selectedService = appointmentType;
                int dailogbox =    JOptionPane.showConfirmDialog(OtherAppointment.this, "Is the info above is correct?");
                if (TimeSlotManager.isTimeSlotAvailable(selectedTime)) {
                    if (dailogbox == JOptionPane.YES_OPTION) {
                        if (validateuserinput(Id, LastName, firstname, MI, gender, Address, number, selectedService)) {

                            if (book(Id, LastName, firstname, MI, age, selectedTime, gender, Address, number, selectedService, cancel, finish)) {

                                TimeSlotManager.removeTimeSlot(selectedTime); // Remove the booked time slot
                                home home = new home(id1,loggedInLastName, loggedInFirstName, loggedInMiddleName,sex , age1, number1, email, address);
                                OtherAppointment.this.dispose();
                                home.setVisible(true);
                                // new AppointmentList().setVisible(true);

                                JOptionPane.showMessageDialog(home, "Booked account successfully");
                            } else {
                                JOptionPane.showMessageDialog(OtherAppointment.this, "Un able to Booked time\n" + "because someone is already booked in that time");
                            }
                        } else {
                            //logger.warning("Error: Invalid user input");
                            JOptionPane.showMessageDialog(OtherAppointment.this, "Error. Name and id must contain words and/or value\n" + "And/or the id must be equal to 6" + " and/or the time is already taken\n" + "the phone number must be 10");
                        }
                    }

                }else {
                    JOptionPane.showMessageDialog(OtherAppointment.this, "Selected time slot is not available. Please choose another slot.");
                }

            }

        });

        ImageIcon logoIcon3= new ImageIcon("appoinment/src/image/appointmentBG.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel4 = new JLabel(logoIcon3);
        logoLabel4.setBounds(0, 0, 1250, 800); // Adjust the position and size as needed

        // ... (existing code for adding GUI components)

//        JPanel schedules = new JPanel();
//        schedules.setBackground(new Color (120, 187, 217, 255));
//        schedules.setBounds(500, 115, 800, 700);

        add(logoLabel4);
        logoLabel4.add(Booknow);
        // add(schedules);


    }


    private boolean validateuserinput(int id, String lastName, String firstname, String middle_name, String Gender, String Address, long number, String appointment) {
        // Database
        if (id == 0 || lastName.length() == 0 || firstname.length() == 0 || middle_name.length() == 0 || Gender.length() == 0 || Address.length() == 0 || number == 0 || appointment.length() == 0 ) {
            //logger.warning("Invalid user input: One or more fields are empty or zero");
            return false;
        }

        if (id < 0 ) {
            logger.warning("Invalid user input: ID is less than 6");
            return false;
        }
        if (lastName.isBlank()) {
            logger.warning("Invalid user input: Last name is blank");
            return false;
        }
        if (firstname.isBlank()) {
            logger.warning("Invalid user input: First name is blank");
            return false;
        }
        if (middle_name.isBlank()) {
            logger.warning("Invalid user input: Middle name is blank");
            return false;
        }
        if (Gender.isBlank()) {
            logger.warning("Invalid user input: Gender should be a single character");
            return false;
        }
        if (number == 12) {
            logger.warning("Invalid user input: Number should not be 10 digits");
            return false;
        }
//        if (TimeSlotManager.isTimeSlotAvailable(time)){
//            logger.warning("Invalid user input: Time is already taken");
//
//            return false;
//        }

        return true;

    }

    // Add this method
    private void loadAppointments() {
        List<schedules> appointments = userDb.getAppointment();
        for (schedules appointment : appointments) {
            String appointmentString = String.format("%s %s (%s) - %s at %s", appointment.getFirst_name(), appointment.getlast_name(), appointment.getid(), appointment.getAppointmet(), appointment.getTime());
            listModel.addElement(appointmentString);
        }
    }

    private void cancelAppointment() {
        int selectedIndex = appointmentList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedAppointment = appointmentList.getSelectedValue();

            if (selectedAppointment != null && !selectedAppointment.isEmpty()) {
                String[] parts = selectedAppointment.split(" ");
                if (parts.length >= 4) {
                    try {
                        int userId = Integer.parseInt(parts[2].replace("(", "").replace(")", ""));
                        String[] timeParts = parts[parts.length - 1].split(":");
                        if (timeParts.length == 2) {
                            LocalTime appointmentTime = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));

                            boolean cancelled = userDb.cancelAppointment(userId, appointmentTime);
                            if (cancelled) {
                                listModel.removeElementAt(selectedIndex);
                                TimeSlotManager.cancelTimeSlot(appointmentTime);
                                JOptionPane.showMessageDialog(this, "Appointment cancelled successfully.");
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to cancel the appointment.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid time format in the selected appointment.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid user ID or time format in the selected appointment.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid appointment format in the selected appointment.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No appointment selected.");
            }
        }
    }
}