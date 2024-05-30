package doctors;


import constant.TimeSlotManager;
import db.userDb;
import gui.loginpage;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public class HistoryAppointments extends doctors{
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

        public HistoryAppointments(){
            super("Ophthalmologist Doctor Page");
            addDoctorProfileGUI();
        }

        private void addDoctorProfileGUI(int id, int age, String loggedInLastName, String loggedInFirstName, String loggedInMiddleName, String sex, long number, String address, String email) {

            this.userId = id;
            this.loggedInLastName = loggedInLastName;
            this.loggedInFirstName = loggedInFirstName;
            this.loggedInMiddleName = loggedInMiddleName;
            this.sex = sex;
            this.age = age;
            this.number = (int) number;
            this.address = address;
            this.email = email;
        }

        private void addDoctorProfileGUI() {


            JPanel userProfilePanel = new JPanel();
            userProfilePanel.setLayout(null);

            //logo image
            ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png");
            JLabel logoLabel = new JLabel(logoIcon);
            logoLabel.setBounds(150, 40, 180, 100);
            add(logoLabel);


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

            // Unavailable button
            JButton UnavailableButton = new JButton("Unavailable");
            UnavailableButton.setBounds(950, 200, 150, 25);
            UnavailableButton.setFont(new Font("Dialog", Font.BOLD, 15));
            UnavailableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            UnavailableButton.setForeground(commonconstant.TEXT_COLOR);
            UnavailableButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    HistoryAppointments.this.dispose();
                }
            });
            add(UnavailableButton);




            JButton today = new JButton("Ophthalmologist Doc Page");
            today.setBounds(10, 650, 250, 25);
            today.setFont(new Font("Dialog", Font.BOLD, 12));
            today.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            today.setForeground(commonconstant.TEXT_COLOR);
            today.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    HistoryAppointments.this.dispose();
                    new OphthalDocPage(id, age, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, number, address, email).setVisible(true);
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
                    HistoryAppointments.this.dispose();
                    userDb.removeBookedTimeSlotsForUser(id);
                    new loginpage().setVisible(true);
                }
            });
            add(logout);




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
    }



    /*
    *
        *
        *
        * // Create a JList or any other suitable UI component for medical history

        medicalHistoryModel = new DefaultListModel<>();
        medicalHistoryList = new JList<>(medicalHistoryModel);
        medicalHistoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane medicalHistoryScrollPane = new JScrollPane(medicalHistoryList);
        medicalHistoryScrollPane.setBounds(500, 220, 500, 100);
        add(medicalHistoryScrollPane);

        *
        *
        *
        *  pastappointment();


         *
         *

        *
        *
        * listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(appointmentList);
        scrollPane.setBounds(500, 550, 500, 200);
        add(scrollPane);

        loadAppointments();
    *
    *
    *
    * //list
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(appointmentList);
        scrollPane.setBounds(570, 40, 600, 140);
        add(scrollPane);
    * */

    /*


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





     */
