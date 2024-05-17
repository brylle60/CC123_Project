package adminpage;

import constant.commonconstant;
import gui.loginpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHome extends adminform {
    public AdminHome() {
        super("Admin Homepage");
        addGuiComponents();
    }


    private void addGuiComponents() {


        //arrow
        ImageIcon image1 = new ImageIcon("appoinment/src/image/arrowtr.png");
        JLabel arrow = new JLabel(image1);
        arrow.setBounds ( 250, 25, 90, 50); // Adjust the position and size as needed
        add(arrow);

        //Admin home label
        JLabel AdminHomeLabel = new JLabel("Admin Home");
        AdminHomeLabel .setBounds(345, 0, 520, 100);
        AdminHomeLabel.setForeground(commonconstant.DARK_BLUE);
        AdminHomeLabel.setFont(new Font("Georgia", Font.BOLD, 25));
        add(AdminHomeLabel);


        //Greetings
        JLabel description1label = new JLabel("Welcome to MedCare Admin Home!");
        description1label.setBounds(240, 100, 800, 35);
        description1label.setForeground(commonconstant.DARKERBLUE_REG);
        description1label.setFont(new Font("Georgia",Font.BOLD, 30));
        add(description1label);

        JLabel description1Alabel = new JLabel("Exclusive for doctors and secretaries");
        description1Alabel.setBounds(430, 140, 800, 35);
        description1Alabel.setForeground(commonconstant.DARKERBLUE_REG);
        description1Alabel.setFont(new Font("Georgia",Font.BOLD, 20 ));
        add(description1Alabel);

        //tagline
        JLabel tag = new JLabel("Where medical synergy and collective care flourish");
        tag.setBounds(300, 570, 800, 35);
        tag.setForeground(commonconstant.DARKERBLUE_REG);
        tag.setFont(new Font("Georgia",Font.ITALIC, 20 ));
        add(tag);

        //3d
        ImageIcon image2 = new ImageIcon("appoinment/src/image/3d500.png");
        JLabel image3d = new JLabel(image2);
        image3d.setBounds(290, 150, 450, 450); // Adjust the position and size as needed
        add(image3d);

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



        //pannel for  background picture
        JPanel panel2 = new JPanel();

        panel2.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel2.add(panelLabel2, BorderLayout.CENTER);
        panel2.setBackground(new Color(255, 255, 255, 110));
        // Set the size and location of the panel
        panel2.setBounds(220, 0, 640, 700);
        add(panel2);


        //right image
        ImageIcon image3 = new ImageIcon("appoinment/src/image/hexag.png");
        JLabel imagehex = new JLabel(image3);
        imagehex.setBounds(220, 0, 640, 700); // Adjust the position and size as needed
        add(imagehex);


        //account table button
        JButton accountButton= new JButton("Account Table");
        accountButton.setBounds(25, 170, 170, 40);
        accountButton.setForeground(commonconstant.SECONDARY_COLOR);
        accountButton.setBackground(commonconstant.HOME_BG1_BLUE);;
        accountButton.setFont(new Font("Dialog", Font.BOLD, 15));

        accountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        accountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminHome.this.dispose();
                new AdminPageController().setVisible(true);
            }
        });
        add(accountButton);


        //Schedule Table BUTTON
        JButton ScheduleTable = new JButton("Schedule Table");
        ScheduleTable.setFont(new Font("Dialog", Font.BOLD, 15));
        ScheduleTable.setBounds(25, 240, 170, 40);
        ScheduleTable.setBackground(commonconstant.HOME_BG1_BLUE);
        ScheduleTable.setForeground(commonconstant.SECONDARY_COLOR);

        ScheduleTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        ScheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminHome.this.dispose();

                new ScheduleTable().setVisible(true);

            }
        });
        add(ScheduleTable);


        //appointment schedule (day) table button
        JButton appointmentSchedule= new JButton("Appointment Schedule (day)");
        appointmentSchedule.setBounds(25, 310, 170, 40);
        appointmentSchedule.setForeground(commonconstant.SECONDARY_COLOR);
        appointmentSchedule.setBackground(commonconstant.HOME_BG1_BLUE);;
        appointmentSchedule.setFont(new Font("Dialog", Font.BOLD, 10));

        appointmentSchedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appointmentSchedule.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminHome.this.dispose();
                new appointmentSchedule().setVisible(true);
            }
        });
        add(appointmentSchedule);


        //appointment schedule (time) table button
        JButton appointmentTime= new JButton("Appointment Schedule (time)");
        appointmentTime.setBounds(25, 380, 170, 40);
        appointmentTime.setForeground(commonconstant.SECONDARY_COLOR);
        appointmentTime.setBackground(commonconstant.HOME_BG1_BLUE);;
        appointmentTime.setFont(new Font("Dialog", Font.BOLD, 9));

        appointmentTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appointmentTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminHome.this.dispose();
                new appointmentTime().setVisible(true);
            }
        });
        add(appointmentTime);



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
                AdminHome.this.dispose();
                new loginpage().setVisible(true);
            }
        });
        add(Logout);



        //logo
        ImageIcon image4 = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel Logo = new JLabel(image4);
        Logo.setBounds(-25, -70, 250, 250); // Adjust the position and size as needed
        add(Logo);


        //Panel Transparent upper
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        JLabel panelLabel3 = new JLabel();
        panel3.add(panelLabel3, BorderLayout.CENTER);
        panel3.setBackground(new Color(255, 255, 255, 110));
        // Set the size and location of the panel
        panel3.setBounds(0, 0, 220, 120);
        add(panel3);


        //Panel Transparent
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(130, 130, 130, 110));
        // Set the size and location of the panel
        panel1.setBounds(0, 0, 220, 700);
        // Add the panel to the main container
        add(panel1);


        //left image
        ImageIcon image5 = new ImageIcon("appoinment/src/image/AdminBack.png");
        JLabel imageL = new JLabel(image5);
        imageL.setBounds(0, 0, 220, 660); // Adjust the position and size as needed
        add(imageL);



    }
}