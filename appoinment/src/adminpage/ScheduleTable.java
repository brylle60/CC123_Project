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



public class ScheduleTable extends adminform{
    private JTable BookedAppointment;
    public ScheduleTable() {
        super("MedCare Appointment System");


       addGuiComponents();
    }

    private void addGuiComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color (120, 187, 217, 255));
        mainPanel.setBounds(19, 115, 800, 500);

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id Number");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("First Name");
        tableModel.addColumn("M.I");
        tableModel.addColumn("Time");
        tableModel.addColumn("Date");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Address");
        tableModel.addColumn("Number");
        tableModel.addColumn("Appointment");


        //SCHEDULE TABLE LABEL
        JLabel scheduleTablelabel = new JLabel("Schedule");
        scheduleTablelabel .setBounds(170, -30, 520, 100);
        scheduleTablelabel.setForeground(commonconstant.DARK_BLUE);
        scheduleTablelabel.setFont(new Font("Georgia", Font.BOLD, 25));
        add(scheduleTablelabel);


        //SCHEDULE TABLE LABEL
        JLabel scheduleTablelabel1 = new JLabel("Table");
        scheduleTablelabel1 .setBounds(290, -30, 520, 100);
        scheduleTablelabel1.setForeground(commonconstant.DARKERBLUE_REG);
        scheduleTablelabel1.setFont(new Font("Georgia", Font.BOLD, 25));
        add(scheduleTablelabel1);



        //nothing button
        JButton nothing= new JButton("");
        nothing.setBounds(0, 0, 0, 0);
        nothing.setForeground(new Color(0,0,0,0));
        nothing.setBackground(new Color(0,0,0,0));
        nothing.setFont(new Font("Dialog", Font.BOLD, 0));

        nothing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        nothing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();

                new AdminHome().setVisible(true);

            }
        });
        add(nothing);


        //HOME BUTTON
        JButton home= new JButton("H O M E");
        home.setBounds(180, 50, 100, 30);
        home.setForeground(commonconstant.SECONDARY_COLOR);
        home.setBackground(commonconstant.HOME_BG1_BLUE);
        home.setFont(new Font("Dialog", Font.BOLD, 10));

        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();

                new AdminHome().setVisible(true);

            }
        });
        add(home);


        //account table button
        JButton account= new JButton("Account Table");
        account.setBounds(300, 50, 110, 30);
        account.setForeground(commonconstant.SECONDARY_COLOR);
        account.setBackground(commonconstant.HOME_BG1_BLUE);
        account.setFont(new Font("Dialog", Font.BOLD, 10));

        account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        account.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();
                new AdminPageController().setVisible(true);
            }
        });
        add(account);


        //appointment schedule (day) table button
        JButton appointmentSchedule= new JButton("Appointment Schedule (day)");
        appointmentSchedule.setBounds(430, 50, 170, 30);
        appointmentSchedule.setForeground(commonconstant.SECONDARY_COLOR);
        appointmentSchedule.setBackground(commonconstant.HOME_BG1_BLUE);;
        appointmentSchedule.setFont(new Font("Dialog", Font.BOLD, 10));

        appointmentSchedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appointmentSchedule.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();
                new appointmentSchedule().setVisible(true);
            }
        });
        add(appointmentSchedule);


        //appointment schedule (time) table button
        JButton appointmentTime= new JButton("Appointment Schedule (time)");
        appointmentTime.setBounds(620, 50, 170, 30);
        appointmentTime.setForeground(commonconstant.SECONDARY_COLOR);
        appointmentTime.setBackground(commonconstant.HOME_BG1_BLUE);;
        appointmentTime.setFont(new Font("Dialog", Font.BOLD, 9));

        appointmentTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appointmentTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();
                new appointmentTime().setVisible(true);
            }
        });
        add(appointmentTime);


        //Log out BUTTON
//        JButton Logout= new JButton("Log out");
//        Logout.setBounds(720, 10, 100, 30);
//        Logout.setForeground(commonconstant.SECONDARY_COLOR);
//        Logout.setBackground(commonconstant.TEAL_REGISTER);;
//        Logout.setFont(new Font("Dialog", Font.BOLD, 10));
//
//        Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        Logout.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                ScheduleTable.this.dispose();
//                new loginpage().setVisible(true);
//            }
//        });
//        add(Logout);


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
        ImageIcon image1 = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel Logo = new JLabel(image1);
        Logo.setBounds ( -50, -80, 250, 250); // Adjust the position and size as needed
        add(Logo);


        //Panel Transparent upper
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (255, 255, 255, 100));
        // Set the size and location of the panel
        panel1.setBounds( 0, 0, 900, 95);
        // Add the panel to the main container
        add(panel1);


        //Upper image
        ImageIcon image2 = new ImageIcon("appoinment/src/image/upperImage (2).png");
        JLabel upperImage = new JLabel(image2);
        upperImage.setBounds ( 0, 0, 900, 95); // Adjust the position and size as needed
        add(upperImage);


        //Panel Transparent lower
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel2.add(panelLabel1, BorderLayout.CENTER);
        panel2.setBackground(new Color (255, 255, 255, 180));
        // Set the size and location of the panel
        panel2.setBounds( 0, 95, 900, 605);
        // Add the panel to the main container
        add(panel2);


        //lower image
        ImageIcon image3 = new ImageIcon("appoinment/src/image/skedyul.png");
        JLabel imagedarkblue = new JLabel(image3);
        imagedarkblue.setBounds ( 0, 95, 900, 605); // Adjust the position and size as needed
        add(imagedarkblue);

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
