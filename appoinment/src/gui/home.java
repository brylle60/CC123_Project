package gui;
import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class home extends homepage {
    public home(){
        super("HealthAppointment");
        addGuiComponents();

    }






    private void addGuiComponents() {
        JLabel menulabel = new JLabel("Health");

        menulabel.setBounds(0, 20, 400, 100);
        menulabel.setForeground(commonconstant.HOME_BG1_BLUE);

        menulabel.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(menulabel);

        JLabel menulabel2 = new JLabel("Appointment");

        menulabel2.setBounds(91, 20, 400, 100);
        menulabel2.setForeground(commonconstant.TEXT_COLOR);

        menulabel2.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel2.setHorizontalAlignment(SwingConstants.CENTER);

        add(menulabel2);


        //new time menu for the time selection mode

        JButton home = new JButton("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 18));


        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setForeground(commonconstant.TEXT_COLOR);
        home.setBounds(610, 150, 100,25);
        //reserved space for database

        JButton features= new JButton("Features");
        features.setFont(new Font("Dialog", Font.BOLD, 18));

        features.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        features.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        features.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.this.dispose();

                new Features().setVisible(true);
            }
        });

        features.setBounds(700, 150, 150,25);

        JButton about= new JButton("About Us");
        about.setFont(new Font("Dialog", Font.BOLD, 18));

        about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        about.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.this.dispose();

                new About().setVisible(true);
            }
        });

        about.setBounds(850, 150, 160,25);

        JButton signin= new JButton("Logout");
        signin.setFont(new Font("Dialog", Font.BOLD, 18));

        signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signin.setForeground(commonconstant.TEXT_COLOR);
        signin.setBackground(commonconstant.BUTTON_COLOR);
        signin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.this.dispose();

                new loginpage().setVisible(true);
            }
        });
        signin.setBounds(1000, 150, 150,25);


        add(signin);
        add(about);
        add(features);
        add(home);


        JLabel text = new JLabel("Consult your health");
        text.setBounds(16, 80, 600, 400);
        text.setForeground(commonconstant.TEXT_COLOR.brighter());


        text.setFont(new Font("Dialog", Font.BOLD, 60));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label = new JLabel("with our doctor");
        label.setBounds(5, 100, 600, 500);
        label.setForeground(commonconstant.TEXT_COLOR.brighter());

        label.setFont(new Font("Dialog", Font.BOLD, 60));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel = new JLabel("anytime, anywhere.");
        newlabel.setBounds(16, 110, 600, 600);
        newlabel.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel.setFont(new Font("Dialog", Font.BOLD, 60));
        newlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel2 = new JLabel("Talking to your doctor regularly is really important for staying healthy. Being able to");
        newlabel2.setBounds(16, 200, 600, 600);
        newlabel2.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel2.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel3 = new JLabel("chat with them whenever and wherever makes it easier to catch and handle health");
        newlabel3.setBounds(16, 215, 600, 600);
        newlabel3.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel3.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel4 = new JLabel("problems early. This helps you stay in control of your health and feel good. Book");
        newlabel4.setBounds(16, 230, 600, 600);
        newlabel4.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel4.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel4.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel5 = new JLabel("your appointment now. With Medicare, your health is our priority. Accessible        ");
        newlabel5.setBounds(16, 245, 600, 600);
        newlabel5.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel5.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel5.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel6 = new JLabel("consultations mean we're here whenever you need us, wherever you are. It's        ");
        newlabel6.setBounds(16, 260, 600, 600);
        newlabel6.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel6.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel6.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel newlabel7 = new JLabel("about proactive care, catching issues early, and keeping you feeling your best.     ");
        newlabel7.setBounds(16, 275, 600, 600);
        newlabel7.setForeground(commonconstant.TEXT_COLOR.brighter());

        newlabel7.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 15));
        newlabel7.setHorizontalAlignment(SwingConstants.CENTER);





        add(newlabel7);
        add(newlabel6);
        add(newlabel5);
        add(newlabel4);
        add(newlabel3);
        add(newlabel2);
        add(newlabel);
        add(label);
        add(text);

        JLabel Appoinment = new JLabel("Appointment");
        Appoinment.setBounds(600, 20, 400, 400);
        Appoinment.setForeground(commonconstant.TEXT_COLOR);

        Appoinment.setFont(new Font("Dialog", Font.BOLD, 30));
        Appoinment.setHorizontalAlignment(SwingConstants.CENTER);




        add(Appoinment);

        JButton book = new JButton("Book Now");
        book.setFont(new Font("Dialog", Font.BOLD, 10));

        book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        book.setForeground(commonconstant.TEXT_COLOR);
        //set mouse listener
        book.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.this.dispose();

                new Appoinment().setVisible(true);
            }
        });

        book.setBounds(450, 600, 100,20);

        add(book);


        JLabel hours = new JLabel("Opening Hours");
        hours.setBounds(700, 150, 400, 400);
        hours.setForeground(commonconstant.TEXT_COLOR);
        hours.setBackground(commonconstant.BLUE_COLOR);

        hours.setFont(new Font("Dialog", Font.BOLD, 30));
        hours.setHorizontalAlignment(SwingConstants.CENTER);

        JButton time = new JButton("8:00am - 11:00am");
        time.setFont(new Font("Dialog", Font.BOLD, 10));

        time.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        time.setForeground(commonconstant.TEXT_COLOR);
        time.setBounds(700, 400, 140,20);

        JButton time2 = new JButton("1:00pm - 5:00pm");
        time2.setFont(new Font("Dialog", Font.BOLD, 10));

        time2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        time2.setForeground(commonconstant.TEXT_COLOR);
        time2.setBounds(700, 400, 140,20);

        add(time2);
        add(time);
        add(hours);

        JLabel contact = new JLabel("Emergency Service");
        contact.setBounds(700, 300, 400, 400);
        contact.setBackground(commonconstant.BLUE_COLOR);
        contact.setForeground(commonconstant.TEXT_COLOR);

        contact.setFont(new Font("Dialog", Font.BOLD, 30));
        contact.setHorizontalAlignment(SwingConstants.CENTER);

        JButton emergency = new JButton("Contact Us");
        emergency.setFont(new Font("Dialog", Font.BOLD, 10));

        emergency.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        emergency.setForeground(commonconstant.TEXT_COLOR);
        emergency.setBounds(650, 600, 140,20);

        add(emergency);
        add(contact);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel();
        panel1.add(panelLabel, BorderLayout.CENTER);

        // Set the size and location of the panel
        panel1.setBounds(0, 0, 1300, 200);

        // Add the panel to the main container
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel2.add(panelLabel, BorderLayout.CENTER);
        panel2.setBackground(commonconstant.HOME_BG1_GRAY);
        // Set the size and location of the panel
        panel2.setBounds(0, 200, 630, 600);

        // Add the panel to the main container
        add(panel2);

        JPanel panel3 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panelLabel3 = new JLabel();
        panel3.add(panelLabel, BorderLayout.CENTER);
        panel3.setBackground(commonconstant.HOME_BG1_BLUE);
        // Set the size and location of the panel
        panel3.setBounds(600, 200, 650, 600);

        // Add the panel to the main container
        add(panel3);
    }




}






















