package adminpage;


import constant.commonconstant;
import db.userDb;
import gui.home;
import gui.loginpage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class appointmentTime extends adminform {

    private JTable BookedAppointment;
    public appointmentTime (){

        super("Medical Appointment System");

        addGuiComponents();
    }


    private void addGuiComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color (0, 0, 0, 150));
        mainPanel.setBounds(250, 90, 550, 500);

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("A.M.");
        tableModel.addColumn("P.M.");

        //arrow
        ImageIcon image1 = new ImageIcon("appoinment/src/image/arrowtr.png");
        JLabel arrow = new JLabel(image1);
        arrow.setBounds ( 250, 25, 90, 50); // Adjust the position and size as needed
        add(arrow);


        //APPOINTMENT SCHEDULE TABLE LABEL
        JLabel AppointmentSchedule = new JLabel("Appointment Schedule Table (time)");
        AppointmentSchedule .setBounds(270, 0, 520, 100);
        AppointmentSchedule.setForeground(commonconstant.DARK_BLUE);
        AppointmentSchedule.setFont(new Font("Georgia", Font.BOLD, 20));
        AppointmentSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        add(AppointmentSchedule);


        //nothing button
        JButton nothing = new JButton("");
        nothing.setBounds(0, 0, 0, 0);
        nothing.setForeground(new Color(0, 0, 0, 0));
        nothing.setBackground(new Color(0, 0, 0, 0));
        nothing.setFont(new Font("Dialog", Font.BOLD, 0));

        nothing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        nothing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appointmentTime.this.dispose();

                new AdminHome().setVisible(true);

            }
        });
        add(nothing);



        //HOME BUTTON
        JButton home= new JButton("H o m e");
        home.setBounds(25, 170, 170, 40);
        home.setForeground(commonconstant.SECONDARY_COLOR);
        home.setBackground(commonconstant.HOME_BG1_BLUE);;
        home.setFont(new Font("Dialog", Font.BOLD, 15));

        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appointmentTime.this.dispose();

                new AdminHome().setVisible(true);

            }
        });
        add(home);


        //account table button
        JButton accountButton= new JButton("Account Table");
        accountButton.setBounds(25, 240, 170, 40);
        accountButton.setForeground(commonconstant.SECONDARY_COLOR);
        accountButton.setBackground(commonconstant.HOME_BG1_BLUE);;
        accountButton.setFont(new Font("Dialog", Font.BOLD, 15));

        accountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        accountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appointmentTime.this.dispose();
                new AdminPageController().setVisible(true);
            }
        });
        add(accountButton);


        //Schedule Table BUTTON
        JButton ScheduleTable = new JButton("Schedule Table");
        ScheduleTable.setFont(new Font("Dialog", Font.BOLD, 15));
        ScheduleTable.setBounds(25, 310, 170, 40);
        ScheduleTable.setBackground(commonconstant.HOME_BG1_BLUE);
        ScheduleTable.setForeground(commonconstant.SECONDARY_COLOR);

        ScheduleTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        ScheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appointmentTime.this.dispose();

                new ScheduleTable().setVisible(true);

            }
        });
        add(ScheduleTable);


        //appointment schedule (day) table button
        JButton appointmentSchedule= new JButton("Appointment Schedule (day)");
        appointmentSchedule.setBounds(25, 380, 170, 40);
        appointmentSchedule.setForeground(commonconstant.SECONDARY_COLOR);
        appointmentSchedule.setBackground(commonconstant.HOME_BG1_BLUE);;
        appointmentSchedule.setFont(new Font("Dialog", Font.BOLD, 10));

        appointmentSchedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appointmentSchedule.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appointmentTime.this.dispose();
                new appointmentSchedule().setVisible(true);
            }
        });
        add(appointmentSchedule);



        //Log out BUTTON
        JButton Logout= new JButton("Log out");
        Logout.setBounds(25, 560, 170, 40);
        Logout.setForeground(commonconstant.SECONDARY_COLOR);
        Logout.setBackground(commonconstant.TEAL_REGISTER);;
        Logout.setFont(new Font("Dialog", Font.BOLD, 15));

        Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                appointmentTime.this.dispose();
                new loginpage().setVisible(true);
            }
        });
        add(Logout);


        // Create the table
        BookedAppointment = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane loggedInUsersScrollPane = new JScrollPane(BookedAppointment);

        // Add some spacing around the scroll pane
        loggedInUsersScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the scroll pane to the main panel (using BorderLayout.CENTER by default)
        mainPanel.add(loggedInUsersScrollPane);

        // Add the main panel to the form
        add(mainPanel);

        populateLoggedInUsersTable();


        //logo
        ImageIcon image2 = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel Logo = new JLabel(image2);
        Logo.setBounds(-25, -70, 250, 250); // Adjust the position and size as needed
        add(Logo);


        //Panel Transparent upper
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(255, 255, 255, 110));
        // Set the size and location of the panel
        panel1.setBounds(0, 0, 220, 120);
        add(panel1);


        //Panel Transparent
        JPanel panel2 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel2.add(panelLabel2, BorderLayout.CENTER);
        panel2.setBackground(new Color(130, 130, 130, 110));
        // Set the size and location of the panel
        panel2.setBounds(0, 0, 220, 700);
        // Add the panel to the main container
        add(panel2);


        //left image for options
        ImageIcon image3 = new ImageIcon("appoinment/src/image/AdminBack.png");
        JLabel imageL = new JLabel(image3);
        imageL.setBounds(0, 0, 220, 660); // Adjust the position and size as needed
        add(imageL);

        //abstract wave image right
        ImageIcon image4 = new ImageIcon("appoinment/src/image/side.png");
        JLabel wave = new JLabel(image4);
        wave.setBounds ( 580, -20, 300, 702); // Adjust the position and size as needed
        add(wave);

    }

    private void populateLoggedInUsersTable() {
        DefaultTableModel tableModel = (DefaultTableModel) BookedAppointment.getModel();
        tableModel.setRowCount(0); // Clear the existing data

        List<schedules> Appointment = userDb.getAppointment();
        for (schedules schedules : Appointment) {
            int id = schedules.getid();
            String last_name = schedules.getlast_name();
            String first_name = schedules.getFirst_name();
            String middle_name = schedules.getMidlle_name();
            LocalTime time = schedules.getTime();
            LocalDate date = schedules.getDate();
            String gender = schedules.getGender();
            String address = schedules.getAdress();
            int number = schedules.getNumber();
            String appointment = schedules.getAppointmet();
            //debugger
            //  System.out.println("Logged-in Users:");

            // System.out.println( " Username: " + user.getUsername() + ", Password: " + user.getPassword()+", logged in:"+user.isLoggedIn());

            tableModel.addRow(new Object[]{id, last_name, first_name, middle_name, time, date, gender, address, number, appointment});


        }

        BookedAppointment.revalidate();
    }

}

