package gui;

import adminpage.*;
import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PediatresDescription extends DescriptionPage {

    public PediatresDescription() {
        super("MedCare (Pediatrics Description)");
        GuestPageExtends();

    }
    private void GuestPageExtends() {


        JLabel description = new JLabel("Our Pediatrics services focus on the healthcare needs of infants ");
        description.setBounds(300, 150, 900, 40);
        description.setForeground(commonconstant.SECONDARY_COLOR);
        description.setFont(new Font("Georgia", Font.PLAIN, 15));
        add(description);

        JLabel description1 = new JLabel("children, and adolescents, providing comprehensive care tailored ");
        description1.setBounds(300, 170, 900, 40);
        description1.setForeground(commonconstant.SECONDARY_COLOR);
        description1.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description1);

        JLabel description2 = new JLabel("to their unique developmental stages and medical requirements.");
        description2.setBounds(300, 190, 900, 40);
        description2.setForeground(commonconstant.SECONDARY_COLOR);
        description2.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description2);

        JLabel description3 = new JLabel("Services: ");
        description3.setBounds(300, 220, 900, 40);
        description3.setForeground(commonconstant.SECONDARY_COLOR);
        description3.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description3);

        JLabel description4 = new JLabel("•Routine check-ups");
        description4.setBounds(300, 245, 900, 40);
        description4.setForeground(commonconstant.SECONDARY_COLOR);
        description4.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description4);

        JLabel description5 = new JLabel("•Vaccinations");
        description5.setBounds(300, 265, 900, 40);
        description5.setForeground(commonconstant.SECONDARY_COLOR);
        description5.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description5);

        JLabel description6 = new JLabel("•Treatment of illnesses like colds and flu");
        description6.setBounds(300, 285, 900, 40);
        description6.setForeground(commonconstant.SECONDARY_COLOR);
        description6.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description6);

        JLabel description7 = new JLabel("•Management of chronic conditions such as asthma and diabetes");
        description7.setBounds(300, 305, 900, 40);
        description7.setForeground(commonconstant.SECONDARY_COLOR);
        description7.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description7);

        JLabel description8 = new JLabel("•Developmental screenings");
        description8.setBounds(300, 325, 900, 40);
        description8.setForeground(commonconstant.SECONDARY_COLOR);
        description8.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description8);

        JLabel description9 = new JLabel("•Counseling on child behavior and nutrition");
        description9.setBounds(300, 345, 900, 40);
        description9.setForeground(commonconstant.SECONDARY_COLOR);
        description9.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description9);


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

        //account table button
        JButton accountButton= new JButton("H O M E");
        accountButton.setBounds(630, 40, 170, 40);
        accountButton.setForeground(commonconstant.SECONDARY_COLOR);
        accountButton.setBackground(commonconstant.HOME_BG1_BLUE);;
        accountButton.setFont(new Font("Dialog", Font.BOLD, 15));

        accountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        accountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PediatresDescription.this.dispose();
                new GuestPage().setVisible(true);
            }
        });
        add(accountButton);

        //service image
        ImageIcon ob = new ImageIcon("appoinment/src/image/file.png");
        JLabel obygn = new JLabel(ob);
        obygn.setBounds(20, 150, 250, 265); // Adjust the position and size as needed
        add(obygn);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JLabel panelLabel2 = new JLabel();
        panel.add(panelLabel2, BorderLayout.CENTER);
        panel.setBackground(new Color(0, 0, 0, 110));
        // Set the size and location of the panel
        panel.setBounds(295, 150, 520, 265);
        add(panel);


        //logo
        ImageIcon image4 = new ImageIcon("appoinment/src/image/logotransparent.png");
        JLabel Logo = new JLabel(image4);
        Logo.setBounds(-25, -70, 250, 250); // Adjust the position and size as needed
        add(Logo);

        JLabel menulabel = new JLabel("Health");

        menulabel.setBounds(8, 9, 400, 100);
        menulabel.setForeground(commonconstant.HOME_BG1_BLUE);

        menulabel.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(menulabel);

        JLabel menulabel2 = new JLabel("Appointment");

        menulabel2.setBounds(98, 9, 400, 100);
        menulabel2.setForeground(commonconstant.TEXT_COLOR);

        menulabel2.setFont(new Font("Dialog", Font.BOLD, 20));

        menulabel2.setHorizontalAlignment(SwingConstants.CENTER);

        add(menulabel2);


        //Panel Transparent
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(255, 255, 255, 110));
        // Set the size and location of the panel
        panel1.setBounds(0, 0, 980, 120);
        // Add the panel to the main container
        add(panel1);

        //OG label
        JLabel ObygynLabel = new JLabel("Pediatrics");
        ObygynLabel.setBounds(436, 454, 280, 50);
        ObygynLabel.setForeground(commonconstant.SECONDARY_COLOR);
        ObygynLabel.setFont(new Font("Georgia",Font.BOLD, 18));
        add(ObygynLabel);

        JLabel OGdoc = new JLabel("- Dr. Chelsie Faith Maranga");
        OGdoc.setBounds(377, 494, 200, 30);
        OGdoc.setForeground(commonconstant.SECONDARY_COLOR);
        OGdoc.setFont(new Font("Calibre", Font.PLAIN, 15));
        OGdoc.setHorizontalAlignment(SwingConstants.CENTER);
        add(OGdoc);
        //Consult BUTTON
        JButton Consult = new JButton("Consult Now");
        Consult.setFont(new Font("Dialog", Font.BOLD, 16));
        Consult.setBounds(379, 534, 200, 30);
        Consult.setBackground(commonconstant.HOME_BG1_BLUE);
        Consult.setForeground(commonconstant.SECONDARY_COLOR);

        Consult.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Consult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                PediatresDescription.this.dispose();

                new loginpage().setVisible(true);

            }
        });
        add(Consult);

        //doctor profile image
        ImageIcon image6 = new ImageIcon("appoinment/src/image/faith.png");
        JLabel imageL1 = new JLabel(image6);
        imageL1.setBounds(225, 465, 130, 125); // Adjust the position and size as needed
        add(imageL1);

        //Panel Transparent
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JLabel panelLabel3 = new JLabel();
        panel2.add(panelLabel3, BorderLayout.CENTER);
        panel2.setBackground(new Color(0, 0, 0, 110));
        // Set the size and location of the panel
        panel2.setBounds(220, 450, 400, 150);
        // Add the panel to the main container
        add(panel2);



        //left image
        ImageIcon image5 = new ImageIcon("appoinment/src/image/whiteBGupper.png");
        JLabel imageL = new JLabel(image5);
        imageL.setBounds(0, 0, 980, 120); // Adjust the position and size as needed
        add(imageL);

        //background
        ImageIcon image = new ImageIcon("appoinment/src/image/hex4.png");
        JLabel logo = new JLabel(image);
        logo.setBounds(0, 120, 850, 560); // Adjust the position and size as needed
        add(logo);

    }
}


