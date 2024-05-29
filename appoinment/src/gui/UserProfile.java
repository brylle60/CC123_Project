package gui;


import adminpage.*;
import constant.TimeSlotManager;
import db.userDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;
import adminpage.User;
import adminpage.schedules;

import constant.commonconstant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


public class UserProfile extends homepage  {
    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age;
    private int number;
    private String address;
    private int id;
    private String sex;
    private String email;
    private schedules loggedInUser;
    private List<schedules> userAppointments;
    private JList<String> appointmentList;
    private DefaultListModel<String> listModel;
    private  DefaultListModel<String> medicalHistoryModel;
    private  JList<String> medicalHistoryList;
    private int userId;



    public UserProfile(int id, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName, String sex, int age, long number, String address, String email) {
        super("User Profile");

        this.userId = id;
        this.loggedInLastName = loggedInLastName;
        this.loggedInFirstName = loggedInFirstName;
        this.loggedInMiddleName = loggedInMiddleName;
        this.sex = sex;
        this.age = age;
        this.number = (int) number;
        this.address = address;
        this.email = email; // Assign the email to the instance variable
        addUserProfileGUI();
    }

    private void addUserProfileGUI() {
        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(null);

        userProfilePanel.setBounds(0, 0, 1300, 900);

        //for image
        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png"); // Replace with the actual path to your image file
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace with the actual path to your image file
        ImageIcon avatarIcon = new ImageIcon("appoinment/src/image/usernoprofile.png"); // Replace with the actual path to your image file


        // Create a JLabel to display the logo image
        JLabel logsLabel = new JLabel(losIcon);
        JLabel logoLabel = new JLabel(logoIcon);
        JLabel avatarLabel = new JLabel(avatarIcon);
        add(avatarLabel);
        avatarLabel.setBounds(170, 175, 150, 150);

        // Nothing button
        JButton nothing = new JButton("");
        nothing.setBounds(0, 0, 0, 0);
        nothing.setForeground(new Color(0, 0, 0, 0));
        nothing.setBackground(new Color(0, 0, 0, 0));
        nothing.setFont(new Font("Dialog", Font.BOLD, 0));
        nothing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nothing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed
            }
        });
        add(nothing);

        // Home button
        JButton home = new JButton("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 18));
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.TEXT_COLOR);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();

                new home(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);
            }
        });

        // About Us button
        JButton about1 = new JButton("About Us");
        about1.setFont(new Font("Dialog", Font.BOLD, 18));
        about1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        about1.setForeground(commonconstant.TEXT_COLOR);


        // Contact Us button
        JButton contactUs = new JButton("Contact Us");
        contactUs.setFont(new Font("Dialog", Font.BOLD, 18));
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contactUs.setForeground(commonconstant.TEXT_COLOR);
        contactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();
                new ContactUs().setVisible(true);
            }
        });

        // Logout button

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Dialog", Font.BOLD, 18));
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.setForeground(commonconstant.TEXT_COLOR);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();

                userDb.removeBookedTimeSlotsForUser(id);

                new loginpage().setVisible(true);
            }
        });


        // User information section
        JLabel patientProfile = new JLabel("Patient's Profile");
        patientProfile.setBounds(180, 245, 550, 150);
        patientProfile.setForeground(commonconstant.SECONDARY_COLOR);
        patientProfile.setFont(new Font("Serif", Font.BOLD, 18));
        add(patientProfile);

        // User information below sa Patient's Profile
        JLabel fnameLabel = new JLabel("First Name: "+ loggedInFirstName);
        fnameLabel.setBounds(115, 350, 300, 25);
        fnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        fnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(fnameLabel);

        JLabel lnameLabel = new JLabel("Last Name: "+loggedInLastName);
        lnameLabel.setBounds(115, 385, 300, 25);
        lnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        lnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(lnameLabel);


        JLabel emailLabel = new JLabel("Gender: "+sex);
        emailLabel.setBounds(115, 415, 300, 25);
        emailLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        emailLabel.setForeground(commonconstant.BLUE_COLOR);
        add(emailLabel);

        JLabel addressLabel = new JLabel("Email: "+email);
        addressLabel.setBounds(115, 445, 300, 25);
        addressLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        addressLabel.setForeground(commonconstant.BLUE_COLOR);
        add(addressLabel);


        JLabel genderLabel = new JLabel("Address: "+address);
        genderLabel.setBounds(115, 480, 300, 25);
        genderLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        genderLabel.setForeground(commonconstant.BLUE_COLOR);
        add(genderLabel);

        JLabel contactNumberLabel = new JLabel("Contact Number: "+number);
        contactNumberLabel.setBounds(115, 510, 300, 25);
        contactNumberLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        contactNumberLabel.setForeground(commonconstant.BLUE_COLOR);
        add(contactNumberLabel);

        // for Medical History
        JLabel medicalHistoryLabel = new JLabel("Previous Appointments");
        medicalHistoryLabel.setBounds(668, 188, 180, 25);
        medicalHistoryLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        medicalHistoryLabel.setForeground(commonconstant.DARK_BLUE);
        add(medicalHistoryLabel);

        // Create a JList or any other suitable UI component for medical history

        medicalHistoryModel = new DefaultListModel<>();
        medicalHistoryList = new JList<>(medicalHistoryModel);
        medicalHistoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane medicalHistoryScrollPane = new JScrollPane(medicalHistoryList);
        medicalHistoryScrollPane.setBounds(500, 220, 500, 100);
        add(medicalHistoryScrollPane);

        pastappointment();

        // for Appointment History
        JButton cancelButton = new JButton("Cancel Appointment");
        cancelButton.setBounds(655, 565, 200, 40);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAppointment();
            }
        });
        add(cancelButton);

        JLabel appointmentHistoryLabel = new JLabel("Appointment History");
        appointmentHistoryLabel.setBounds(655, 382, 180, 25);
        appointmentHistoryLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        appointmentHistoryLabel.setForeground(commonconstant.DARK_BLUE);
        add(appointmentHistoryLabel);

        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(appointmentList);
        scrollPane.setBounds(500, 410, 500, 200);
        add(scrollPane);

        loadAppointments();



        // Background panels
        JPanel BGdarkblue = new JPanel(null);
        BGdarkblue.setBackground(commonconstant.DARK_BLUE);

        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBackground(commonconstant.PRIMARY_COLOR);

        JPanel BGlightblo = new JPanel(null);
        BGlightblo.setBackground(commonconstant.PRIMARY_COLOR);

        // Adding components to the frame
        add(home);
        add(about1);
        add(contactUs);
        add(logout);

        // Set bounds for menu buttons
        home.setBounds(480, 130, 150, 25);
        about1.setBounds(780, 130, 150, 25);
        contactUs.setBounds(630, 130, 150, 25);
        logout.setBounds(927, 130, 150, 25);

        // Set bounds for background panels
        add(BGlightblo);
        add(BGdarkblue);
        add(BGlightblue);
        BGdarkblue.setBounds(100, 190, 300, 450);
        BGlightblue.setBounds(430, 190, 650, 150);
        BGlightblo.setBounds(430, 380, 650, 258);

        // Set bounds for images
        add(logoLabel);
        add(logsLabel);
        logsLabel.setBounds(0, 0, 1300, 900);
        logoLabel.setBounds(100, 45, 180, 100);
    }
    private void pastappointment(){
        List<schedules> pastAppointments = userDb.getPastAppointments();
        for (schedules appointment : pastAppointments) {
            String appointmentString = String.format("%s %s (%s) - %s at %s", appointment.getFirst_name(), appointment.getlast_name(), appointment.getid(), appointment.getAppointmet(), appointment.getTime());
            medicalHistoryModel.addElement(appointmentString);
        }
    }
    private void loadAppointments() {
        // Replace with the actual user ID
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
                String[] parts = selectedAppointment.split(" - ");
                if (parts.length == 2) {
                    String[] nameParts = parts[0].split(" ");
                    if (nameParts.length >= 3) {
                        try {
                            int userId = Integer.parseInt(nameParts[nameParts.length - 1].replace("(", "").replace(")", ""));
                            String[] timeParts = parts[1].split(" at ")[1].split(":");
                            if (timeParts.length == 2) {
                                LocalTime appointmentTime = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));

                                boolean cancelled = userDb.cancelAppointment(userId, appointmentTime);
                                if (cancelled) {
                                    listModel.removeElementAt(selectedIndex);
                                    TimeSlotManager.cancelTimeSlot(appointmentTime);
                                    TimeSlotManager.addTimeSlot(appointmentTime); // Add the freed time slot back
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
                    JOptionPane.showMessageDialog(this, "Invalid appointment format in the selected appointment.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No appointment selected.");
            }
        }
    }
    }

