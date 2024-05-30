package doctors;

import constant.commonconstant;
import db.NotificationManager;
import db.NotificationQueue;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class doctorhomepage extends doctors{
    public doctorhomepage() {
        super("Health Appointment");
        DoctorComponents();
        handleNotifications();
        retrieveUnconfirmedNotifications();

    }
    private void DoctorComponents(){

        JLabel text = new JLabel("We're bridging the gap between Doctors and Patients");
        text.setBounds(16, 80, 600, 400);
        text.setForeground(commonconstant.TEXT_COLOR.brighter());
        text.setFont(new Font("Dialog", Font.BOLD, 60));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel text1 = new JLabel("You'll never miss another Doctor's appointment!");
        text1.setBounds(16, 80, 600, 400);
        text1.setForeground(commonconstant.TEXT_COLOR.brighter());
        text1.setFont(new Font("Dialog", Font.BOLD, 60));
        text1.setHorizontalAlignment(SwingConstants.CENTER);

        add(text);
        add(text1);

        JPanel doctorpanel1 = new JPanel();
        doctorpanel1.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel1.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel1.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel1);

        JPanel doctorpanel2 = new JPanel();
        doctorpanel2.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel2.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel2.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel2);

        JPanel doctorpanel3 = new JPanel();
        doctorpanel3.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel3.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel3.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel3);

        JPanel doctorpanel4 = new JPanel();
        doctorpanel4.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel4.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel4.setBackground(new Color(1, 122, 194, 100));

        add(doctorpanel1);
        add(doctorpanel2);
        add(doctorpanel3);
        add(doctorpanel4);
    }

    public static class Pediatrics extends DoctorpageComponents {
        public Pediatrics(){
            super("Doctors homepage");

            addGUIDoctor();
            addGUIPediatrics();

        }
        private void addGUIPediatrics(){
            //doctors name
            JLabel PediaTxt = new JLabel("WELCOME DR. SINETCH ITEY");
            PediaTxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
            PediaTxt.setBounds(90,20,700,35);

            add(PediaTxt);
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
}
