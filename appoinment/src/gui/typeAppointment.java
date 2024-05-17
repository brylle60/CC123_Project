package gui;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class typeAppointment extends homepage {
    public typeAppointment (){
        super ("Types of Appointment");
        addGuiComponents();
    }

    private void addGuiComponents() {

        ImageIcon logoIcon6= new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel6 = new JLabel(logoIcon6);
        logoLabel6.setBounds(10, -80, 150, 300); // Adjust the position and size as needed
        add(logoLabel6);



        JLabel comment1 = new JLabel("OUR SERVICES");
        comment1.setBounds(220, -160, 800, 450);
        comment1.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment1.setFont(new Font("Dialog", Font.BOLD, 50));
        comment1.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment1);

        JLabel comment2 = new JLabel("My health Clinic is a multi-speciality,full service clinic that serves a wide range of services.");
        comment2.setBounds(210, -120, 800, 450);
        comment2.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment2.setFont(new Font("Dialog",Font.PLAIN, 18));
        comment2.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment2);

        JLabel comment3 = new JLabel("Click on each text to proceed");
        comment3.setBounds(315, 60, 600, 150);
        comment3.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment3.setFont(new Font("Dialog", Font.BOLD, 18));
        comment3.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment3);


        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/Logo 3.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(-320, -160, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel);

        ImageIcon logoIcon1 = new ImageIcon("appoinment/src/image/Logo 2.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel1 = new JLabel(logoIcon1);
        logoLabel1.setBounds(-70, -160, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel1);

        ImageIcon logoIcon2 = new ImageIcon("appoinment/src/image/Logo 1.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel2 = new JLabel(logoIcon2);
        logoLabel2.setBounds(230, -160, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel2);

        ImageIcon logoIcon3 = new ImageIcon("appoinment/src/image/logo4.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel3 = new JLabel(logoIcon3);
        logoLabel3.setBounds(550, -160, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel3);

        JLabel label1= new JLabel("General Consultation");
        label1.setFont(new Font("Dialog", Font.BOLD, 18));
        label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                typeAppointment.this.dispose();
                new Appoinment().setVisible(true);
            }
        });
        label1.setBounds(85, 420, 200,25);
        add(label1);

        JLabel label2= new JLabel("Laboratory and Diagnostics");
        label2.setFont(new Font("Dialog", Font.BOLD, 18));
        label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label2.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               typeAppointment.this.dispose();
                new Appoinment().setVisible(true);
            }
        });
        label2.setBounds(320, 420, 300,25);
        add(label2);

        JLabel label3= new JLabel("Rehabilitation Medicine Services");
        label3.setFont(new Font("Dialog", Font.BOLD, 18));
        label3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label3.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                typeAppointment.this.dispose();
                new Appoinment().setVisible(true);
            }
        });
        label3.setBounds(600, 420, 300,25);
        add(label3);

        JLabel label4= new JLabel("Online Consultation Services");
        label4.setFont(new Font("Dialog", Font.BOLD, 18));
        label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label4.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                typeAppointment.this.dispose();
                new Appoinment().setVisible(true);
            }
        });
        label4.setBounds(920, 420, 300,25);
        add(label4);

        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (225, 255, 255, 150));
        // Set the size and location of the panel
        panel1.setBounds( 45, 200, 1150, 380);

        // Add the panel to the main container
        add(panel1);



        ImageIcon logoIcon5= new ImageIcon("appoinment/src/image/medicalbg.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel5 = new JLabel(logoIcon5);
        logoLabel5.setBounds(0, 0, 1250, 800); // Adjust the position and size as needed
        add(logoLabel5);





    }

}
