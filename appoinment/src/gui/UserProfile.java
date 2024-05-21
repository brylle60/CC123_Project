package gui;

import constant.commonconstant;
import javax.swing.*;
import java.awt.*;
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
        userProfilePanel.setBounds(0, 0, 1300, 900);

        //for image
        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png"); // Replace with the actual path to your image file
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace with the actual path to your image file
        ImageIcon avatarIcon = new ImageIcon("appoinment/src/image/usernoprofile.png"); // Replace with the actual path to your image file


        // Create a JLabel to display the logo image
        JLabel logsLabel = new JLabel(losIcon);
        JLabel logoLabel = new JLabel(logoIcon);
        JLabel avatarLabel = new JLabel(avatarIcon);
        add(avatarLabel);
        avatarLabel.setBounds(170, 175, 150, 150);

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

        // Home button
        JButton home = new JButton("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 18));
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.TEXT_COLOR);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();
                new home().setVisible(true);
            }
        });

        // About Us button
        JButton about1 = new JButton("About Us");
        about1.setFont(new Font("Dialog", Font.BOLD, 18));
        about1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        about1.setForeground(commonconstant.TEXT_COLOR);

        // Contact Us button
        JButton contactUs = new JButton("Contact Us");
        contactUs.setFont(new Font("Dialog", Font.BOLD, 18));
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contactUs.setForeground(commonconstant.TEXT_COLOR);
        contactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();
                new ContactUs().setVisible(true);
            }
        });

        // Logout button
        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Dialog", Font.BOLD, 18));
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.setForeground(commonconstant.TEXT_COLOR);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserProfile.this.dispose();
                new loginpage().setVisible(true);
            }
        });

        // User information section
        JLabel patientProfile = new JLabel("Patient's Profile");
        patientProfile.setBounds(180, 245, 550, 150);
        patientProfile.setForeground(commonconstant.SECONDARY_COLOR);
        patientProfile.setFont(new Font("Serif", Font.BOLD, 18));
        add(patientProfile);

        // User information below sa Patient's Profile
        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setBounds(115, 350, 280, 25);
        fnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        fnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(fnameLabel);

        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(115, 385, 280, 25);
        lnameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        lnameLabel.setForeground(commonconstant.BLUE_COLOR);
        add(lnameLabel);


        JLabel emailLabel = new JLabel("Gender:");
        emailLabel.setBounds(115, 415, 150, 25);
        emailLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        emailLabel.setForeground(commonconstant.BLUE_COLOR);
        add(emailLabel);

        JLabel addressLabel = new JLabel("Email:");
        addressLabel.setBounds(115, 445, 150, 25);
        addressLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        addressLabel.setForeground(commonconstant.BLUE_COLOR);
        add(addressLabel);


        JLabel genderLabel = new JLabel("Address:");
        genderLabel.setBounds(115, 480, 150, 25);
        genderLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        genderLabel.setForeground(commonconstant.BLUE_COLOR);
        add(genderLabel);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberLabel.setBounds(115, 510, 150, 25);
        contactNumberLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        contactNumberLabel.setForeground(commonconstant.BLUE_COLOR);
        add(contactNumberLabel);

        // for Medical History
        JLabel medicalHistoryLabel = new JLabel("Medical History");
        medicalHistoryLabel.setBounds(668, 188, 180, 25);
        medicalHistoryLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        medicalHistoryLabel.setForeground(commonconstant.DARK_BLUE);
        add(medicalHistoryLabel);

        // for Appointment History
        JLabel appointmentHistoryLabel = new JLabel("Appointment History");
        appointmentHistoryLabel.setBounds(655, 382, 180, 25);
        appointmentHistoryLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        appointmentHistoryLabel.setForeground(commonconstant.DARK_BLUE);
        add(appointmentHistoryLabel);


        // Background panels
        JPanel BGdarkblue = new JPanel(null);
        BGdarkblue.setBackground(commonconstant.DARK_BLUE);

        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBackground(commonconstant.PRIMARY_COLOR);

        JPanel BGlightblo = new JPanel(null);
        BGlightblo.setBackground(commonconstant.PRIMARY_COLOR);

        // Adding components to the frame
        add(home);
        add(about1);
        add(contactUs);
        add(logout);

        // Set bounds for menu buttons
        home.setBounds(480, 130, 150, 25);
        about1.setBounds(780, 130, 150, 25);
        contactUs.setBounds(630, 130, 150, 25);
        logout.setBounds(927, 130, 150, 25);

        // Set bounds for background panels
        add(BGlightblo);
        add(BGdarkblue);
        add(BGlightblue);
        BGdarkblue.setBounds(100, 190, 300, 450);
        BGlightblue.setBounds(430, 190, 650, 150);
        BGlightblo.setBounds(430, 380, 650, 258);

        // Set bounds for images
        add(logoLabel);
        add(logsLabel);
        logsLabel.setBounds(0, 0, 1300, 900);
        logoLabel.setBounds(100, 45, 180, 100);
    }
}