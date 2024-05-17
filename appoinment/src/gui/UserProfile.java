package gui;

import adminpage.AdminHome;
import adminpage.ScheduleTable;
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

public class UserProfile extends homepage {

    public UserProfile() {
        super("User Profile");
        addUserProfileGUI();
    }

    private void addUserProfileGUI() {
        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(null);
        userProfilePanel.setBounds(0,0, 1300, 900);

        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(-10, 45, 180, 100); // Adjust the position and size as needed

        add(logoLabel);

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


            }
        });
        add(nothing);
        //new time menu for the time selection mode

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
                UserProfile.this.dispose();


            }
        });
        add(home);

        JLabel patientProfile = new JLabel("Patient's Profile");
        patientProfile.setBounds(125, 145, 550, 150);
        patientProfile.setForeground(commonconstant.DARK_BLUE);
        patientProfile.setFont(new Font("Serif", Font.BOLD,18));

        add(patientProfile);

        //color
        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBounds(100,190,1000,550);
        BGlightblue.setBackground(commonconstant.HOME_BG1_GRAY);

        add(BGlightblue);



    }
}