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


        JLabel description = new JLabel("Our Obstetrician-Gynecologist team provides specialized medical care to ");
        description.setBounds(300, 150, 900, 40);
        description.setForeground(commonconstant.HOME_BG1_BLUE);
        description.setFont(new Font("Georgia", Font.PLAIN, 15));
        add(description);

        JLabel description1 = new JLabel("women throughout all stages of life. We offer a range of obstetric");
        description1.setBounds(300, 170, 900, 40);
        description1.setForeground(commonconstant.SECONDARY_COLOR);
        description1.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description1);

        JLabel description2 = new JLabel("and gynecological services focused on diagnosing and treating conditions.");
        description2.setBounds(300, 190, 900, 40);
        description2.setForeground(commonconstant.SECONDARY_COLOR);
        description2.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description2);

        JLabel description3 = new JLabel("Obstetric Services");
        description3.setBounds(300, 220, 900, 40);
        description3.setForeground(commonconstant.SECONDARY_COLOR);
        description3.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description3);

        JLabel description4 = new JLabel("• Complete prenatal care");
        description4.setBounds(300, 240, 900, 40);
        description4.setForeground(commonconstant.SECONDARY_COLOR);
        description4.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description4);

        JLabel description5 = new JLabel("•Labor and delivery services");
        description5.setBounds(300, 255, 900, 40);
        description5.setForeground(commonconstant.SECONDARY_COLOR);
        description5.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description5);

        JLabel description6 = new JLabel("");
        description6.setBounds(300, 260, 900, 40);
        description6.setForeground(commonconstant.SECONDARY_COLOR);
        description6.setFont(new Font("Georgia",Font.PLAIN, 15));
        add(description6);



        //nothing button
        JButton nothing= new JButton("");
        nothing.setBounds(0, 0, 0, 0);
        nothing.setForeground(new Color(0,0,0,0));
        nothing.setBackground(new Color(0,0,0,0));
        nothing.setFont(new Font("Dialog", Font.BOLD, 0));

        nothing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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


        //Panel Transparent
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        JLabel panelLabel4 = new JLabel();
        panel4.add(panelLabel4, BorderLayout.CENTER);
        panel4.setBackground(new Color(0, 0, 0, 110));
        // Set the size and location of the panel
        panel4.setBounds(220, 450, 400, 150);
        // Add the panel to the main container
        add(panel4);


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


