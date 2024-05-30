package doctors;



import TIMESLOTS.TimeSlots;
import db.NotificationManager;
import db.NotificationQueue;
import db.timeslotManager;
import db.userDb;
import gui.loginpage;
import db.fam_medDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import adminpage.schedules;

import constant.commonconstant;
//import doctors.finishedAppointmentsTable;
//import doctors.requests;
//import doctors.todayAppointmentsTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.AWTEventMulticaster.add;

public class OphthalDocPage extends doctors{
    private static int userId;
    private static String loggedInLastName;
    private static String loggedInFirstName;
    private static String loggedInMiddleName;
    private static int age;
    private static int number;
    private static String address;
    private static int id;
    private static String sex;
    private static String email;
    private static schedules loggedInUser;
    private static List<schedules> userAppointments;
    private static JList<String> appointmentList;
    private static DefaultListModel<String> listModel;
    private static DefaultListModel<String> medicalHistoryModel;
    private static JList<String> medicalHistoryList;
    private  JTable opthalAppointmentTable;
    private JComboBox<String> startTimeDropdown;
    private JComboBox<String> endTimeDropdown;

    private static final List<LocalTime> START_TIMES = List.of(
            LocalTime.of(8, 0), // 8:00 AM
            LocalTime.of(13, 0) // 1:00 PM
    );

    private static final List<LocalTime> END_TIMES = List.of(
            LocalTime.of(11, 0), // 11:00 AM
            LocalTime.of(16, 0) // 4:00 PM
    );


    public OphthalDocPage(int id, int age, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName, String sex, int number, String address, String email) {
        super("Ophthalmologist Doctor Page");
        handleNotifications();
        retrieveUnconfirmedNotifications();
        addDoctorProfileGUI();
        loadAvailableTimeSlots();
    }
    private void addDoctorProfileGUI() {


        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(null);

        //logo image
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(150, 40, 180, 100);
        add(logoLabel);

        //Avatar
        ImageIcon avatarIcon = new ImageIcon("appoinment/src/image/khen.png");
        JLabel avatarLabel = new JLabel(avatarIcon);
        avatarLabel.setBounds(170, 190, 150, 150);
        add(avatarLabel);

        // Start time dropdown
        startTimeDropdown = new JComboBox<>();
        for (LocalTime startTime : START_TIMES) {
            startTimeDropdown.addItem(startTime.toString());
        }
        startTimeDropdown.setBounds(800, 650, 100, 25);
        add(startTimeDropdown);

// End time dropdown
        endTimeDropdown = new JComboBox<>();
        for (LocalTime endTime : END_TIMES) {
            endTimeDropdown.addItem(endTime.toString());
        }
        endTimeDropdown.setBounds(920, 650, 100, 25);
        add(endTimeDropdown);

// Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(1040, 650, 100, 25);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startTimeString = (String) startTimeDropdown.getSelectedItem();
                String endTimeString = (String) endTimeDropdown.getSelectedItem();

                // Parse the selected times into LocalTime objects
                LocalTime startTime = LocalTime.parse(startTimeString);
                LocalTime endTime = LocalTime.parse(endTimeString);

                // Call the handleTimeSlotSelection method
                handleTimeSlotSelection(startTime, endTime);
            }
        });
        add(submitButton);


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

        //Request Label
        JLabel RequestLabel = new JLabel("Appointment Requests" );
        RequestLabel.setBounds(760, 10, 300, 25);
        RequestLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        RequestLabel.setForeground(commonconstant.DARKERBLUE_REG);
        add(RequestLabel);

        // Confirm button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(630, 200, 150, 25);
        Confirm.setFont(new Font("Dialog", Font.BOLD, 15));
        Confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Confirm.setForeground(commonconstant.TEXT_COLOR);
        Confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OphthalDocPage.this.dispose();
            }
        });
        add(Confirm);

        // Unavailable button
        JButton UnavailableButton = new JButton("Unavailable");
        UnavailableButton.setBounds(950, 200, 150, 25);
        UnavailableButton.setFont(new Font("Dialog", Font.BOLD, 15));
        UnavailableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        UnavailableButton.setForeground(commonconstant.TEXT_COLOR);
        UnavailableButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OphthalDocPage.this.dispose();
            }
        });
        add(UnavailableButton);

        //list
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(appointmentList);
        scrollPane.setBounds(570, 40, 600, 140);
        add(scrollPane);




        //Confirmed Appointment Label
        JLabel ConfirmedAppointment = new JLabel("Confirmed Appointments" );
        ConfirmedAppointment.setBounds(760, 250, 300, 25);
        ConfirmedAppointment.setFont(new Font("Georgia", Font.BOLD, 18));
        ConfirmedAppointment.setForeground(commonconstant.DARKERBLUE_REG);
        add(ConfirmedAppointment);

        // Finish button
        JButton confirmed = new JButton("Finish");
        confirmed.setBounds(630, 430, 150, 25);
        confirmed.setFont(new Font("Dialog", Font.BOLD, 15));
        confirmed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmed.setForeground(commonconstant.TEXT_COLOR);
        add(confirmed);

        // cancel button
        JButton CancelButton = new JButton("Cancel");
        CancelButton.setBounds(950, 430, 150, 25);
        CancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
        CancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CancelButton.setForeground(commonconstant.TEXT_COLOR);
        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAppointment();
            }
        });
        add(CancelButton);

        //list
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane ConfirmedAppointmentScrollPane = new JScrollPane(appointmentList);
        ConfirmedAppointmentScrollPane.setBounds(580, 280, 600, 140);
        add(ConfirmedAppointmentScrollPane);

        loadAppointments();


//Today's Appointment Label
        JLabel TodayAppointment = new JLabel("Today's Appointments" );
        TodayAppointment.setBounds(760, 495, 300, 25);
        TodayAppointment.setFont(new Font("Georgia", Font.BOLD, 18));
        TodayAppointment.setForeground(commonconstant.DARKERBLUE_REG);
        add(TodayAppointment);

        //list
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane TodayAppointmentScrollPane = new JScrollPane(appointmentList);
        TodayAppointmentScrollPane.setBounds(580, 520, 600, 140);
        add(TodayAppointmentScrollPane);


        JButton today = new JButton("History/Finished Appointments");
        today.setBounds(10, 650, 250, 25);
        today.setFont(new Font("Dialog", Font.BOLD, 14));
        today.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        today.setForeground(commonconstant.TEXT_COLOR);
        today.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OphthalDocPage.this.dispose();
                new HistoryAppointments().setVisible(true);

            }
        });
        add(today);

        // Logout button
        JButton logout = new JButton("Logout");
        logout.setBounds(330, 650, 150, 25);
        logout.setFont(new Font("Dialog", Font.BOLD, 15));
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.setForeground(commonconstant.TEXT_COLOR);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OphthalDocPage.this.dispose();
                userDb.removeBookedTimeSlotsForUser(id);
                new loginpage().setVisible(true);
            }
        });
        add(logout);


        // User information section
        JLabel patientProfile = new JLabel("Doctor's Profile");
        patientProfile.setBounds(190, 115, 550, 150);
        patientProfile.setForeground(commonconstant.SECONDARY_COLOR);
        patientProfile.setFont(new Font("Serif", Font.BOLD, 15));
        add(patientProfile);

        // User information below sa Patient's Profile
        JLabel frameLabel = new JLabel("First Name: " + loggedInFirstName);
        frameLabel.setBounds(65, 350, 300, 25);
        frameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        frameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(frameLabel);

        JLabel lnameLabel = new JLabel("Last Name: " + loggedInLastName);
        lnameLabel.setBounds(65, 385, 300, 25);
        lnameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        lnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(lnameLabel);


        JLabel emailLabel = new JLabel("Gender: " + sex);
        emailLabel.setBounds(65, 420, 300, 25);
        emailLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        emailLabel.setForeground(commonconstant.BLUE_COLOR);
        add(emailLabel);

        JLabel addressLabel = new JLabel("Email: " + email);
        addressLabel.setBounds(65, 455, 300, 25);
        addressLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        addressLabel.setForeground(commonconstant.BLUE_COLOR);
        add(addressLabel);


        JLabel genderLabel = new JLabel("Address: " + address);
        genderLabel.setBounds(65, 490, 300, 25);
        genderLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        genderLabel.setForeground(commonconstant.BLUE_COLOR);
        add(genderLabel);

        JLabel contactNumberLabel = new JLabel("Contact Number: " + number);
        contactNumberLabel.setBounds(65, 525, 300, 25);
        contactNumberLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        contactNumberLabel.setForeground(commonconstant.BLUE_COLOR);
        add(contactNumberLabel);






        // Background panel for profile
        JPanel BGdarkblue = new JPanel(null);
        BGdarkblue.setBounds(50, 170, 400, 450);
        BGdarkblue.setBackground(commonconstant.DARK_BLUE);
        add(BGdarkblue);


        //likod sa request appointments
        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBounds(550, 10, 650, 185);
        BGlightblue.setBackground(commonconstant.PRIMARY_COLOR);
        add(BGlightblue);

        //likod sa confirmed appointments
        JPanel BGlightblue2 = new JPanel(null);
        BGlightblue2.setBounds(550, 250, 650, 175);
        BGlightblue2.setBackground(commonconstant.PRIMARY_COLOR);
        add(BGlightblue2);

        //Likod sa today
        JPanel todayPanel = new JPanel(null);
        todayPanel.setBackground(commonconstant.PRIMARY_COLOR);
        todayPanel.setBounds(550, 490, 650, 175);
        add(todayPanel);


        //background blue for profile2
        JPanel bg1 = new JPanel(null);
        bg1.setBackground(commonconstant.BUTTON_COLOR);
        bg1.setBounds(0,0, 500, 900);
        add(bg1);

        //for image hexagon
        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png");
        JLabel logsIcon = new JLabel(losIcon);
        logsIcon.setBounds(0, 0, 1300, 900);
        add(logsIcon);

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
                                     // Add the freed time slot back
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


    //
private void addGUIOptal() {

    JPanel Optalpanel = new JPanel(new BorderLayout());
    Optalpanel.setBackground(new Color(120, 187, 217, 255));
    Optalpanel.setBounds(260, 90, 500, 500);

    DefaultTableModel appointmentTableModel = new DefaultTableModel();
    appointmentTableModel.addColumn("Patient Number");
    appointmentTableModel.addColumn("Last Name");
    appointmentTableModel.addColumn("First Name");
    appointmentTableModel.addColumn("Sex");
    appointmentTableModel.addColumn("Age");
    appointmentTableModel.addColumn("Time");
    appointmentTableModel.addColumn("Date");

    JTable opthalAppointmentTable = new JTable(appointmentTableModel);
    JScrollPane scrollPane = new JScrollPane(opthalAppointmentTable);
    scrollPane.setBounds(600, 300, 600, 300);
    add(scrollPane);
    //populateAppointmentTable();





   //private void populateAppointmentTable() {
        appointmentTableModel = (DefaultTableModel) opthalAppointmentTable.getModel();
        appointmentTableModel.setRowCount(0);

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
    private void retrieveUnconfirmedNotifications() {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT last_name, message FROM " + commonconstant.NOTIFICATION + " WHERE confirmed = false");
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String notificationId = resultSet.getString("last_name");

                String notificationMessage = resultSet.getString("message");
                int response = JOptionPane.showConfirmDialog(this, notificationMessage, "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    confirmAppointment(notificationId);
                } else {
                    declineAppointment(notificationId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmAppointment(String last_name) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + commonconstant.NOTIFICATION + " SET confirmed = true WHERE last_name = ?");
            updateStatement.setString(1, last_name);
            updateStatement.executeUpdate();

            // Store the confirmed appointment in the main database
            PreparedStatement insertAppointment = connection.prepareStatement("INSERT INTO "+commonconstant.CONFIRMED_NOTIF+" (last_name, doctor_name, appointment_date) VALUES (?, ?, ?)");
            insertAppointment.setString(1, last_name);
            insertAppointment.setString(2, "Dr. John Brylle Crodua"); // Replace with the appropriate doctor's name
            insertAppointment.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Replace with the actual appointment date
            insertAppointment.executeUpdate();

            // Send a notification to the user
            // Send a notification to the user
            String notificationMessage = "Your appointment with Dr. John Brylle Crodua has been confirmed.";
            NotificationManager.storeAppointmentNotification(last_name, notificationMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void declineAppointment(String last_name) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + commonconstant.NOTIFICATION + " WHERE last_name = ?");
            statement.setString(1, last_name);
            statement.executeUpdate();
            // Send a notification to the user
            String notificationMessage = "Your appointment with Dr. John Brylle Crodua has been declined.";
            NotificationManager.storeAppointmentNotification(last_name, notificationMessage);
            // Additional logic to notify the user that the appointment was declined
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleNotifications() {
        while (NotificationQueue.hasNotifications()) {
            String notification = NotificationQueue.pollNotification();
            int response = JOptionPane.showConfirmDialog(this, notification, "Confirm Appointment", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                confirmAppointment(String.valueOf(response));
            } else {
                declineAppointment(String.valueOf(response));
            }
        }
    }
    private void loadAvailableTimeSlots() {
        // Get the available time slots from the database
        int doctorId = 1;
        List<TimeSlots> availableSlots = timeslotManager.getAvailableTimeSlotsForDoctorAndDate(doctorId, LocalDate.now());

        // Clear the existing time slot options
//        startTimeDropdown.removeAllItems();
//        endTimeDropdown.removeAllItems();

        // Populate the dropdowns with the available time slots
        for (TimeSlots timeSlot : availableSlots) {
            startTimeDropdown.addItem(timeSlot.getStartTime().toString());
            endTimeDropdown.addItem(timeSlot.getEndTime().toString());
        }
    }
    private void handleTimeSlotSelection(LocalTime startTime, LocalTime endTime) {
        // Call the registerTimeSlot method from the timeslotManager to store the selected time slot in the database
        int doctorId = 1;
        int slotId = timeslotManager.registerTimeSlot(doctorId, LocalDate.now(), startTime, endTime);

        // Make the registered time slot available to users
        fam_medDb.addAvailableTimeSlots(doctorId, LocalDate.now(), Collections.singletonList(startTime), Collections.singletonList(endTime));

        // Reload the available time slots after registering the new slot
        loadAvailableTimeSlots();
    }

}
