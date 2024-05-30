package adminpage;

import constant.commonconstant;
import db.userDb;

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
    private JTable appointmentList;

    private JTable BookedAppointment;
    public ScheduleTable() {
        super("MedCare Appointment System (Schedule Table)");


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
        home.setBounds(190, 50, 135, 30);
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
        account.setBounds(340, 50, 135, 30);
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


        //MORNING SCHEDULE table button
        JButton ScheduleAM= new JButton("Morning Schedule");
        ScheduleAM.setBounds(490, 50, 135, 30);
        ScheduleAM.setForeground(commonconstant.SECONDARY_COLOR);
        ScheduleAM.setBackground(commonconstant.HOME_BG1_BLUE);;
        ScheduleAM.setFont(new Font("Dialog", Font.BOLD, 9));

        ScheduleAM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ScheduleAM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();
                new ScheduleAM().setVisible(true);
            }
        });
        add(ScheduleAM);


        //AFTERNOON SCHEDULE table button
        JButton SchedulePM= new JButton("Afternoon Schedule");
        SchedulePM.setBounds(640, 50, 135, 30);
        SchedulePM.setForeground(commonconstant.SECONDARY_COLOR);
        SchedulePM.setBackground(commonconstant.HOME_BG1_BLUE);;
        SchedulePM.setFont(new Font("Dialog", Font.BOLD, 10));

        SchedulePM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SchedulePM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScheduleTable.this.dispose();
                new SchedulePM().setVisible(true);
            }
        });
        add(SchedulePM);

        JButton finishButton = new JButton("Finished");
        finishButton.setBounds(655, 565, 200, 40);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishAppointment();
            }
        });
        add(finishButton);


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
            long number = schedules.getNumber();
            String appointment = schedules.getAppointmet();
            //debugger
            //  System.out.println("Logged-in Users:");

            // System.out.println( " Username: " + user.getUsername() + ", Password: " + user.getPassword()+", logged in:"+user.isLoggedIn());

            tableModel.addRow(new Object[]{id, last_name, first_name, middle_name, time, date, gender, address, number, appointment});


        }

        BookedAppointment.revalidate();
    }

    private void finishAppointment() {
        int selectedIndex = BookedAppointment.getSelectedRow();
        if (selectedIndex != -1) {
            String selectedAppointment = (String) BookedAppointment.getValueAt(selectedIndex, 9);

            if (selectedAppointment != null && !selectedAppointment.isEmpty()) {
                // Check if the appointment string is in the expected format (e.g., "Rehabilitation")
                if (isValidAppointmentFormat(selectedAppointment)) {
                    // Get the user ID from the table
                    int userId = (int) BookedAppointment.getValueAt(selectedIndex, 0);
                    LocalTime appointmentTime = (LocalTime) BookedAppointment.getValueAt(selectedIndex, 4);

                    boolean finished = userDb.finishAppointment(userId, appointmentTime);
                    if (finished) {
                        DefaultTableModel tableModel = (DefaultTableModel) BookedAppointment.getModel();
                        tableModel.removeRow(selectedIndex);
                        JOptionPane.showMessageDialog(this, "Appointment finished.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to cancel the appointment.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid appointment format in the selected appointment.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No appointment selected.");
            }
        }
    }

    private boolean isValidAppointmentFormat(String appointment) {
        // Split the appointment string based on spaces
        String[] parts = appointment.split("\\s+");

        // Check if the first part is a word (appointment type)
        if (parts.length > 0 && parts[0].matches("\\w+")) {
            return true;
        }

        return false;
    }
}
