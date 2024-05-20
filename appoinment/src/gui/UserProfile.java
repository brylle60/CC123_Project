package gui;


import constant.commonconstant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserProfile extends homepage  {

    public UserProfile() {
        super("User Profile");
        addUserProfileGUI();
    }

    private void addUserProfileGUI() {
        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(null);
        userProfilePanel.setBounds(0,0, 1300, 900);

        //for image
        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logsLabel = new JLabel(losIcon);
        JLabel logoLabel = new JLabel(logoIcon);


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

        //for about us direct
        JButton about1 = new JButton("About us");
        about1.setFont(new Font("Dialog", Font.BOLD, 18));
        about1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        about1.setForeground(commonconstant.TEXT_COLOR);


        //for contact us direct
        JButton ContactUs= new JButton("Contact Us");
        ContactUs.setFont(new Font("Dialog", Font.BOLD, 18));
        ContactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ContactUs.setForeground(commonconstant.TEXT_COLOR);

        //set mouse listener
        ContactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                UserProfile.this.dispose();
                new ContactUs().setVisible(true);

            }
        });


        // for log out and direct to log out
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

        //reserved space for database


        //para sa text title
        JLabel patientProfile = new JLabel("Patient's Profile");
        patientProfile.setBounds(180, 145, 550, 150);
        patientProfile.setForeground(commonconstant.SECONDARY_COLOR);
        patientProfile.setFont(new Font("Serif", Font.BOLD,18));

        add(patientProfile);


        //color
        JPanel BGdarkblue = new JPanel(null);
        BGdarkblue.setBackground(commonconstant.DARK_BLUE);

        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBackground(commonconstant.PRIMARY_COLOR);

        JPanel BGlightblo = new JPanel(null);
        BGlightblo.setBackground(commonconstant.PRIMARY_COLOR);

        //for menu
        add(home);
        add(about1);
        add(ContactUs);
        add(logout);

        //size and position sa menu
        home.setBounds(480, 130, 150, 25);
        about1.setBounds(780, 130, 150, 25);
        ContactUs.setBounds(630, 130, 150,25);
        logout.setBounds(927, 130, 150, 25);

        //for color and bg
        add(BGlightblo);
        add(BGdarkblue);
        add(BGlightblue);
        //size and position sa color bg
        BGdarkblue.setBounds(100,190,300,450);
        BGlightblue.setBounds(430,190,650,150);
        BGlightblo.setBounds(430,380,650,258);

        //for image background and logo
        add(logoLabel);
        add(logsLabel);
        //image position and size
        logsLabel.setBounds(0, 0, 1300,900 );//background sa userprofile
        logoLabel.setBounds(100, 45, 180, 100);//logo sa medical

    }
}
