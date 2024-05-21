package gui;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HowToAppointment extends homepage {
    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    public HowToAppointment() {
        super("AppointmentTutorial");
        addTutorialGUI();
    }

    private void addTutorialGUI() {
        JPanel tutorialPanel = new JPanel();
        tutorialPanel.setLayout(null);
        tutorialPanel.setBounds(0,0, 1300, 900);

        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file

        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(-10, 45, 180, 100); // Adjust the position and size as needed

        add(logoLabel);

        JLabel menulabel = new JLabel("Health");

        menulabel.setBounds(0, 53, 400, 100);
        menulabel.setForeground(commonconstant.HOME_BG1_BLUE);

        menulabel.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel menulabel2 = new JLabel("Appointment");

        menulabel2.setBounds(91, 53, 400, 100);
        menulabel2.setForeground(commonconstant.TEXT_COLOR);

        menulabel2.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel2.setHorizontalAlignment(SwingConstants.CENTER);



        //new time menu for the time selection mode

        JLabel home = new JLabel("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 20));


        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.TEXT_COLOR);
        home.setBounds(670, 91, 100,25);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HowToAppointment.this.dispose();
                new home(loggedInLastName, loggedInFirstName, loggedInMiddleName).setVisible(true);
            }
        });

        //reserved space for database


        JLabel about= new JLabel("About Us");
        about.setFont(new Font("Dialog", Font.BOLD, 20));

        about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        about.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HowToAppointment.this.dispose();
                new About().setVisible(true);
            }

        });

        about.setBounds(755, 91, 160,25);

        JLabel ContactUs= new JLabel("Contact Us");
        ContactUs.setFont(new Font("Dialog", Font.BOLD, 20));

        ContactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ContactUs.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        ContactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                HowToAppointment.this.dispose();
                new ContactUs().setVisible(true);

            }
        });

        ContactUs.setBounds(860, 91, 200,25);

        // new edit nothing button

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
                HowToAppointment.this.dispose();

                new loginpage().setVisible(true);

            }
        });


        JButton signin= new JButton("Logout");
        signin.setFont(new Font("Dialog", Font.BOLD, 18));

        signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signin.setForeground(commonconstant.SECONDARY_COLOR);
        signin.setBackground(commonconstant.HOME_BG1_BLUE);
        signin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HowToAppointment.this.dispose();
                new loginpage().setVisible(true);
            }
        });

        signin.setBounds(1000, 81, 150,42);


        add(nothing); // new edit
        add(menulabel);
        add(menulabel2);
        add(signin);
        add(about);
        add(home);
        add(ContactUs);

        JLabel txtHow = new JLabel("HOW TO SCHEDULE AN APPOINTMENT");
        txtHow.setFont(new Font("Dialogs", Font.BOLD, 30));
        txtHow.setBounds(300, 230, 700, 50);
        txtHow.setForeground(commonconstant.TEXT_COLOR);

        JPanel BGlightblue = new JPanel(null);
        BGlightblue.setBounds(100,190,1000,550);
        BGlightblue.setBackground(commonconstant.HOME_BG1_GRAY);



        ImageIcon T1 = new ImageIcon ("appoinment/src/image/t1.png");
        JLabel step1 = new JLabel(T1);
        step1.setBounds(0, 50, 300, 300);

        JLabel txtT1 = new JLabel("After logging in, click \"Book now\"");
        txtT1.setFont(new Font("Dialogs", Font.BOLD, 17));
        txtT1.setBounds(25, 280, 700, 50);
        txtT1.setForeground(commonconstant.TEXT_COLOR);


        ImageIcon bgBlue = new ImageIcon ("appoinment/src/image/BGlikodIMG.jpg");
        JLabel bgBluePic = new JLabel(bgBlue);
        bgBluePic.setBounds(0, 165, 1300, 650);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel();
        panel1.add(panelLabel, BorderLayout.CENTER);
        panel1.setBounds(0, 0, 1300, 150);



        add(panel1); // white panel above
        BGlightblue.add(txtT1);
        BGlightblue.add(step1);
        tutorialPanel.add(txtHow);
        tutorialPanel.add(BGlightblue);
        tutorialPanel.add(bgBluePic);
        add(tutorialPanel);







    }


    }
