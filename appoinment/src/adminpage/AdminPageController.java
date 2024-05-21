package adminpage;

import constant.commonconstant;
import db.MyJDBC;
import gui.form;
import gui.loginpage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AdminPageController extends adminform {
    private JTable loggedInUsersTable;


    public AdminPageController() {
        super("MedCare Appointment System (Account Table)");

        addGuiComponents();
    }

    private void addGuiComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color (120, 187, 217, 255));
        mainPanel.setBounds(260, 90, 500, 500);

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id Number");
        tableModel.addColumn("Username");
        tableModel.addColumn("Email");
        tableModel.addColumn("Password");
        tableModel.addColumn("Logged In");

        //arrow
        ImageIcon imageA = new ImageIcon("appoinment/src/image/arrowtr.png");
        JLabel arrow = new JLabel(imageA);
        arrow.setBounds ( 250, 25, 90, 50); // Adjust the position and size as needed
        add(arrow);


        //ACCOUNT TABLE LABEL
        JLabel accountlabel = new JLabel("Account Table");
        accountlabel .setBounds(345, 0, 520, 100);
        accountlabel.setForeground(commonconstant.DARK_BLUE);
        accountlabel.setFont(new Font("Georgia", Font.BOLD, 30));
        add(accountlabel);

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

                new AdminHome().setVisible(true);

            }
        });
        add(nothing);


        //HOME BUTTON
        JButton home= new JButton("H o m e");
        home.setBounds(25, 180, 170, 40);
        home.setForeground(commonconstant.SECONDARY_COLOR);
        home.setBackground(commonconstant.HOME_BG1_BLUE);;
        home.setFont(new Font("Dialog", Font.BOLD, 15));

        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminPageController.this.dispose();

                new AdminHome().setVisible(true);

            }
        });
        add(home);


        //Schedule Table BUTTON
        JButton ScheduleTable = new JButton("Schedule Table");
        ScheduleTable.setFont(new Font("Dialog", Font.BOLD, 15));
        ScheduleTable.setBounds(25, 245, 170, 40);
        ScheduleTable.setBackground(commonconstant.HOME_BG1_BLUE);
        ScheduleTable.setForeground(commonconstant.SECONDARY_COLOR);

        ScheduleTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        ScheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AdminPageController.this.dispose();
                new ScheduleTable().setVisible(true);

            }
        });

        add(ScheduleTable);


        //MORNING SCHEDULE table button
        JButton ScheduleAM= new JButton("Morning Schedule");
        ScheduleAM.setBounds(25, 310, 170, 40);
        ScheduleAM.setForeground(commonconstant.SECONDARY_COLOR);
        ScheduleAM.setBackground(commonconstant.HOME_BG1_BLUE);;
        ScheduleAM.setFont(new Font("Dialog", Font.BOLD, 15));

        ScheduleAM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ScheduleAM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminPageController.this.dispose();
                new ScheduleAM().setVisible(true);
            }
        });
        add(ScheduleAM);



        //AFTERNOON SCHEDULE table button
        JButton SchedulePM= new JButton("Afternoon Schedule");
        SchedulePM.setBounds(25, 380, 170, 40);
        SchedulePM.setForeground(commonconstant.SECONDARY_COLOR);
        SchedulePM.setBackground(commonconstant.HOME_BG1_BLUE);;
        SchedulePM.setFont(new Font("Dialog", Font.BOLD, 13));

        SchedulePM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SchedulePM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminPageController.this.dispose();
                new SchedulePM().setVisible(true);
            }
        });
        add(SchedulePM);



        // Create the table
        loggedInUsersTable = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane loggedInUsersScrollPane = new JScrollPane(loggedInUsersTable);

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
        Logo.setBounds ( -25, -70, 250, 250); // Adjust the position and size as needed
        add(Logo);


        //Panel Transparent upper
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel2.add(panelLabel2, BorderLayout.CENTER);
        panel2.setBackground(new Color (255, 255, 255, 110));
        // Set the size and location of the panel
        panel2.setBounds( 0, 0, 220, 120);
        // Add the panel to the main container
        add(panel2);


        //Panel Transparent left
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (130, 130, 130, 110));
        // Set the size and location of the panel
        panel1.setBounds( 0, 0, 220, 700);
        // Add the panel to the main container
        add(panel1);


        //left image for options
        ImageIcon image2 = new ImageIcon("appoinment/src/image/AdminBack.png");
        JLabel imageL = new JLabel(image2);
        imageL.setBounds ( 0, 0, 220, 660); // Adjust the position and size as needed
        add(imageL);


        //abstract wave image right
        ImageIcon image3 = new ImageIcon("appoinment/src/image/side.png");
        JLabel wave = new JLabel(image3);
        wave.setBounds ( 580, -20, 300, 702); // Adjust the position and size as needed
        add(wave);
}

    private void populateLoggedInUsersTable() {
        DefaultTableModel tableModel = (DefaultTableModel) loggedInUsersTable.getModel();
        tableModel.setRowCount(0); // Clear the existing data

        List<User> loggedInUsers = MyJDBC.getLoggedInUsers();
        for (User user : loggedInUsers) {
            int id = user.getid();
            String username = user.getLast_name();
            String email = user.getEmail();
            // Consider removing password from the table for security reasons.
            String password = user.getPassword();
            boolean isLoggedIn = user.isLoggedIn();

            //debugger
          //  System.out.println("Logged-in Users:");

           // System.out.println( " Username: " + user.getUsername() + ", Password: " + user.getPassword()+", logged in:"+user.isLoggedIn());

            tableModel.addRow(new Object[]{id, username, email, password, isLoggedIn});


        }

        loggedInUsersTable.revalidate();
    }

}
