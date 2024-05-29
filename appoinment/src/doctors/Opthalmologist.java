package doctors;


import constant.TimeSlotManager;
import db.userDb;
import gui.loginpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import adminpage.schedules;

import constant.commonconstant;
import doctors.DoctorpageComponents;
import doctors.finishedAppointmentsTable;
import doctors.requests;
import doctors.todayAppointmentsTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.AWTEventMulticaster.add;

public class Opthalmologist extends  doctors{

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
    private DefaultListModel<String> medicalHistoryModel;
    private JList<String> medicalHistoryList;
    private int userId;

    private JTable opthalAppointmentTable; // Declare opthalAppointmentTable as an instance variable

    public Opthalmologist(int id, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName, String sex, int age, long number, String address, String email) {
        super("OPTHALMOLOGIST DOCTOR's PAGE");
        this.userId = id;
        this.loggedInLastName = loggedInLastName;
        this.loggedInFirstName = loggedInFirstName;
        this.loggedInMiddleName = loggedInMiddleName;
        this.sex = sex;
        this.age = age;
        this.number = (int) number;
        this.address = address;
        this.email = email; // Assign the email to the instance variable
        addDoctorProfileGUI();

    }

    private void addDoctorProfileGUI() {
        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(null);

        userProfilePanel.setBounds(0, 0, 1300, 900);

        //background
        JPanel bg1 = new JPanel(null);
        bg1.setBackground(commonconstant.BUTTON_COLOR);
        bg1.setBounds(0,0, 500, 900);


        //for image
        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png"); // Replace with the actual path to your image file
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace with the actual path to your image file
        ImageIcon avatarIcon = new ImageIcon("appoinment/src/image/usernoprofile.png"); // Replace with the actual path to your image file


        // Create a JLabel to display the logo image
        JLabel logsIcon = new JLabel(losIcon);
        JLabel logoLabel = new JLabel(logoIcon);
        JLabel avatarLabel = new JLabel(avatarIcon);

        avatarLabel.setBounds(170, 175, 150, 150);
        logsIcon.setBounds(0, 0, 1300, 900);
        logoLabel.setBounds(100, 45, 180, 100);



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

        // req button
        JButton request = new JButton("Requests");
        request.setFont(new Font("Dialog", Font.BOLD, 18));
        request.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        request.setForeground(commonconstant.TEXT_COLOR);
        request.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Opthalmologist.this.dispose();


                new requests(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);

            }
        });

        // confirmed button
        JButton confirmed = new JButton("Confirmed Appointments");
        confirmed.setFont(new Font("Dialog", Font.BOLD, 18));
        confirmed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmed.setForeground(commonconstant.TEXT_COLOR);


        // Contact Us button
        JButton finished = new JButton("Finished Appointments");
        finished.setFont(new Font("Dialog", Font.BOLD, 18));
        finished.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        finished.setForeground(commonconstant.TEXT_COLOR);
        finished.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Opthalmologist.this.dispose();
                new finishedAppointmentsTable(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);
            }
        });

        JButton today = new JButton("Today's Appointments");
        today.setFont(new Font("Dialog", Font.BOLD, 18));
        today.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        today.setForeground(commonconstant.TEXT_COLOR);
        today.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Opthalmologist.this.dispose();
                new todayAppointmentsTable(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);
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
                Opthalmologist.this.dispose();

                userDb.removeBookedTimeSlotsForUser(id);

                new loginpage().setVisible(true);
            }
        });


        // User information section
        JLabel patientProfile = new JLabel("Doctor's Profile");
        patientProfile.setBounds(180, 245, 550, 150);
        patientProfile.setForeground(commonconstant.SECONDARY_COLOR);
        patientProfile.setFont(new Font("Serif", Font.BOLD, 18));

        add(patientProfile);

        // User information below sa Patient's Profile
        JLabel fnameLabel = new JLabel("First Name: " + loggedInFirstName);
        fnameLabel.setBounds(115, 350, 300, 25);
        fnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        fnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(fnameLabel);

        JLabel lnameLabel = new JLabel("Last Name: " + loggedInLastName);
        lnameLabel.setBounds(115, 385, 300, 25);
        lnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        lnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(lnameLabel);


        JLabel emailLabel = new JLabel("Gender: " + sex);
        emailLabel.setBounds(115, 415, 300, 25);
        emailLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        emailLabel.setForeground(commonconstant.BLUE_COLOR);
        add(emailLabel);

        JLabel addressLabel = new JLabel("Email: " + email);
        addressLabel.setBounds(115, 445, 300, 25);
        addressLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        addressLabel.setForeground(commonconstant.BLUE_COLOR);
        add(addressLabel);


        JLabel genderLabel = new JLabel("Address: " + address);
        genderLabel.setBounds(115, 480, 300, 25);
        genderLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        genderLabel.setForeground(commonconstant.BLUE_COLOR);
        add(genderLabel);

        JLabel contactNumberLabel = new JLabel("Contact Number: " + number);
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
        scrollPane.setBounds(500, 550, 500, 200);
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

        // Set bounds for menu buttons
        request.setBounds(380, 130, 350, 25);
        confirmed.setBounds(680, 230, 350, 25);
        today.setBounds(630, 330, 350, 25);
        logout.setBounds(927, 430, 350, 25);

        // panels
        BGdarkblue.setBounds(80, 190, 400, 450);
        BGlightblue.setBounds(430, 190, 650, 150);
        BGlightblo.setBounds(430, 380, 650, 258);

        add(request);
        add(confirmed);
        add(today);
        add(logout);

        // Set bounds for background panels
        add(BGlightblo); //likod sa todays appointments
        BGdarkblue.add(avatarLabel);
        add(BGdarkblue);
        add(BGlightblue);//likod sa confiremed appointments
        add(logoLabel);
        add(bg1);
        add(logsIcon);

        // Set bounds for images


    }

    private void pastappointment() {
        List<schedules> pastAppointments = userDb.getPastAppointments();
        for (schedules appointment : pastAppointments) {
            String appointmentString = String.format("%s %s (%s) - %s at %s", appointment.getFirst_name(), appointment.getlast_name(), appointment.getid(), appointment.getAppointmet(), appointment.getTime());
            medicalHistoryModel.addElement(appointmentString);
        }
    }

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


//    private void addGUIOptal() {
//
//
//        //background
//        JPanel bg1 = new JPanel(null);
//        bg1.setBackground(commonconstant.BUTTON_COLOR);
//        bg1.setBounds(0,80, 1250, 700);
//
//
//        // Doctors name
//        JLabel OptalTxt = new JLabel("WELCOME ");
//        OptalTxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
//        OptalTxt.setBounds(90, 20, 700, 35);
//
//        add(OptalTxt);

//        JPanel Optalpanel = new JPanel(new BorderLayout());
//        Optalpanel.setBackground(new Color(120, 187, 217, 255));
//        Optalpanel.setBounds(260, 90, 500, 500);
//
//        DefaultTableModel appointmentTableModel = new DefaultTableModel();
//        appointmentTableModel.addColumn("Patient Number");
//        appointmentTableModel.addColumn("Last Name");
//        appointmentTableModel.addColumn("First Name");
//        appointmentTableModel.addColumn("Sex");
//        appointmentTableModel.addColumn("Age");
//        appointmentTableModel.addColumn("Time");
//        appointmentTableModel.addColumn("Date");
//
//        opthalAppointmentTable = new JTable(appointmentTableModel); // Assign the JTable to the instance variable
//        JScrollPane scrollPane = new JScrollPane(opthalAppointmentTable);
//        scrollPane.setBounds(600, 300, 600, 300); // Set the desired bounds for the scroll pane
//
//        add(scrollPane); // Add the scroll pane to the frame
//
//        populateAppointmentTable();
//        add(bg1);
//


    private void populateAppointmentTable() {
        DefaultTableModel appointmentTableModel = (DefaultTableModel) opthalAppointmentTable.getModel();
        appointmentTableModel.setRowCount(0); // Clear the existing data

        List<schedules> appointments = userDb.getAppointment();
        for (schedules appointment : appointments) {
            int patientNumber = appointment.getid();
            String lastName = appointment.getlast_name();
            String firstName = appointment.getFirst_name();
            String sex = appointment.getGender();
            int age = appointment.getAge();
            LocalDate date = appointment.getDate();
            LocalTime timeOfAppointment = appointment.getTime();

            appointmentTableModel.addRow(new Object[]{patientNumber, lastName, firstName, sex, age, timeOfAppointment});
        }
    }
}

