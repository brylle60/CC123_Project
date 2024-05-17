package gui;

import adminpage.schedules;
import constant.TimeSlotManager;
import constant.commonconstant;
import db.userDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

public class AppointmentList extends JFrame {
    private JList<String> appointmentList;
    private DefaultListModel<String> listModel;

    public AppointmentList() {
        setTitle("Booked Appointments");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(appointmentList);
        add(scrollPane, BorderLayout.CENTER);

        JButton cancelButton = new JButton("Cancel Appointment");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAppointment();
            }
        });
        add(cancelButton, BorderLayout.SOUTH);

        loadAppointments();

       // Reload appointments from the database

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