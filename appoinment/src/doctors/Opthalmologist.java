package doctors;

import adminpage.User;
import constant.commonconstant;
import db.MyJDBC;
import doctors.DoctorpageComponents;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

import adminpage.schedules;
import db.userDb;
import java.time.LocalTime;

public class Opthalmologist extends DoctorpageComponents {

    private JTable opthalAppointmentTable; // Declare opthalAppointmentTable as an instance variable

    public Opthalmologist() {
        super("OPTHALMOLOGIST DOCTOR's PAGE");
        addGUIOptal();
        addGUIDoctor();
    }

    private void addGUIOptal() {


        //background
        JPanel bg1 = new JPanel(null);
        bg1.setBackground(commonconstant.BUTTON_COLOR);
        bg1.setBounds(0,80, 1250, 700);


        // Doctors name
        JLabel OptalTxt = new JLabel("WELCOME ");
        OptalTxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
        OptalTxt.setBounds(90, 20, 700, 35);

        add(OptalTxt);

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

        opthalAppointmentTable = new JTable(appointmentTableModel); // Assign the JTable to the instance variable
        JScrollPane scrollPane = new JScrollPane(opthalAppointmentTable);
        scrollPane.setBounds(600, 300, 600, 300); // Set the desired bounds for the scroll pane

        add(scrollPane); // Add the scroll pane to the frame

        populateAppointmentTable();
        add(bg1);
    }

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