package gui;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About extends homepage{
    public About(){
        super("HealthAppointment");
        addGuiComponents();

    }

    private void addGuiComponents() {




        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/20240424_162915_0000.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(490, -100, 1000, 1000); // Adjust the position and size as needed
        add(logoLabel);

       ImageIcon logoIcon1= new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
       JLabel logoLabel2 = new JLabel(logoIcon1);
        logoLabel2.setBounds(10, -80, 150, 300); // Adjust the position and size as needed
        add(logoLabel2);

        ImageIcon logoIcon2= new ImageIcon("appoinment/src/image/Picsart_24-04-24_17-53-27-111.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel3 = new JLabel(logoIcon2);
        logoLabel3.setBounds(-1150, -350, 2500, 1500); // Adjust the position and size as needed
        add(logoLabel3);


        //new time menu for the time selection mode

        JButton home = new JButton("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 18));
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.TEXT_COLOR);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                About.this.dispose();

                new home().setVisible(true);
            }
        });
        home.setBounds(760, 130, 150, 25);
        //reserved space for database
        add(home);

     JButton about1 = new JButton("About us");
     about1.setFont(new Font("Georgia", Font.BOLD, 18));
     about1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     about1.setForeground(commonconstant.TEXT_COLOR);
     about1.setBounds(910, 130, 150, 25);
     //reserved space for database
     add(about1);

     JButton logout = new JButton("Logout");
     logout.setFont(new Font("Dialog", Font.BOLD, 18));
     logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     logout.setForeground(commonconstant.TEXT_COLOR);
     logout.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
       About.this.dispose();

       new loginpage().setVisible(true);
      }
     });
     logout.setBounds(1060, 130, 150, 25);
     //reserved space for database
     add(logout);



        JLabel text = new JLabel("About us!");
        text.setBounds(100, 180, 400, 100);
        text.setForeground(commonconstant.TEXT_COLOR.brighter());
        text.setFont(new Font("Dialog", Font.BOLD, 50));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        add(text);

        JLabel comment = new JLabel("Welcome to MEDCARE Medical Appointment! We are dedicated to revolutionizing the way you manage");
        comment.setBounds(150, 200, 600, 150);
        comment.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment.setFont(new Font("Dialog", Font.BOLD, 12));
        comment.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment);

        JLabel comment1 = new JLabel("your healthcare appointments. Our platform is designed to provide seamless scheduling, ensuring you");
        comment1.setBounds(153, 220,600 , 150);
        comment1.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment1.setFont(new Font("Dialog", Font.BOLD, 12));
        comment1.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment1);

        JLabel comment2 = new JLabel("can access medical care conveniently and efficiently.");
        comment2.setBounds(115, 240, 400, 150);
        comment2.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment2.setFont(new Font("Dialog", Font.BOLD, 12));
        comment2.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment2);

        JLabel text1 = new JLabel("Our Mission");
        text1.setBounds(100, 310, 400, 100);
        text1.setForeground(commonconstant.TEXT_COLOR.brighter());
        text1.setFont(new Font("Dialog", Font.BOLD, 40));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        add(text1);

        JLabel comment3 = new JLabel("At MEDCARE Medical Appointment, our mission is to empower individuals to take control");
        comment3.setBounds(110, 320, 600, 150);
        comment3.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment3.setFont(new Font("Dialog", Font.BOLD, 12));
        comment3.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment3);

        JLabel comment4 = new JLabel("of their health by simplifying the appointment booking process. We aim to bridge the gap ");
        comment4.setBounds(110, 340, 600, 150);
        comment4.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment4.setFont(new Font("Dialog", Font.BOLD, 12));
        comment4.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment4);

        JLabel text2 = new JLabel("Our Team");
        text2.setBounds(80, 410, 400, 100);
        text2.setForeground(commonconstant.TEXT_COLOR.brighter());
        text2.setFont(new Font("Dialog", Font.BOLD, 40));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        add(text2);

        JLabel comment5 = new JLabel("Behind MEDCARE Medical Appointment is a dedicated team of healthcare professionals,");
        comment5.setBounds(109, 420, 600, 150);
        comment5.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment5.setFont(new Font("Dialog", Font.BOLD, 12));
        comment5.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment5);

        JLabel comment6 = new JLabel("technologists, and customer service experts. We are passionate about leveraging technology to   ");
        comment6.setBounds(137, 440, 600, 150);
        comment6.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment6.setFont(new Font("Dialog", Font.BOLD, 12));
        comment6.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment6);


        JLabel comment7 = new JLabel("enhance the patient experience and improve healthcare outcomes.  ");
        comment7.setBounds(52, 460, 600, 150);
        comment7.setForeground(commonconstant.TEXT_COLOR.brighter());
        comment7.setFont(new Font("Dialog", Font.BOLD, 12));
        comment7.setHorizontalAlignment(SwingConstants.CENTER);
        add(comment7);


        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel();
        panel1.add(panelLabel, BorderLayout.CENTER);
        panel1.setBackground(commonconstant.HOME_BG1_GRAY);
        // Set the size and location of the panel
        panel1.setBounds(0, 180, 1300, 440);
        // Add the panel to the main container
        add(panel1);







        JPanel panel2 = new JPanel();

        panel2.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel2.add(panelLabel1, BorderLayout.CENTER);
        panel2.setBackground(new Color (255, 255, 255, 120));
        // Set the size and location of the panel
        panel2.setBounds( 0, 0, 1500, 700);

        // Add the panel to the main container
        add(panel2);


        ImageIcon logoIcon3= new ImageIcon("appoinment/src/image/Background.jpg"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel4 = new JLabel(logoIcon3);
        logoLabel4.setBounds(0, 0, 1250, 800); // Adjust the position and size as needed
        add(logoLabel4);



    }
}
