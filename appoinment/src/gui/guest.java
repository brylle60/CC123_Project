package gui;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;

public class guest extends homepage {
    public guest() {
        super("Guest");
        addguestGUI();
    }

    private void addguestGUI() {
        JPanel GuestPanel = new JPanel();
        GuestPanel.setLayout(null);

        GuestPanel.setBounds(0, 0, 1300, 900);

        JPanel BGblack = new JPanel(null);
        BGblack.setBackground(commonconstant.TEXT_COLOR);
        BGblack.setBounds(0,0,1250,800);

        JPanel BGwhite = new JPanel(null);
        BGwhite.setBackground(commonconstant.SECONDARY_COLOR);
        BGwhite.setBounds(420,0,850,700);

        ImageIcon docIcon = new ImageIcon("appoinment/src/image/img_1.png");
        ImageIcon obgynIcon = new ImageIcon("appoinment/src/image/obgyn.png");
        ImageIcon pediatricIcon = new ImageIcon("appoinment/src/image/pediatric.png");
        ImageIcon opthalIcon = new ImageIcon("appoinment/src/image/ophtalmologist.png");
        ImageIcon famMedIcon = new ImageIcon("appoinment/src/image/familyMedicine.png");

        //image display
        JLabel obgynLabel = new JLabel(obgynIcon);
        obgynLabel.setBounds(450, 100, 100,95);

        JLabel pediatricLabel = new JLabel(pediatricIcon);
        pediatricLabel.setBounds(650, 100, 100,120);

        JLabel ophtalLabel = new JLabel(opthalIcon);
        ophtalLabel.setBounds(850, 100, 100,100);

        JLabel famMedLabel = new JLabel(famMedIcon);
        famMedLabel.setBounds(1050, 100, 100,100);

        JLabel docLabel = new JLabel(docIcon);
        docLabel.setBounds(0,50,408,602);
        add(docLabel);
        add(obgynLabel);
        add(pediatricLabel);
        add(ophtalLabel);
        add(famMedLabel);

        //services menu
        JLabel obMenu = new JLabel("Obgyn");
        obMenu.setBounds(476, 130, 550, 150);
        obMenu.setForeground(commonconstant.DARK_BLUE);
        obMenu.setFont(new Font("Serif", Font.BOLD, 18));
        add(obMenu);


        JLabel Services = new JLabel("Available Services");
        Services.setBounds(745, 5, 550, 150);
        Services.setForeground(commonconstant.TEXT_COLOR);
        Services.setFont(new Font("Serif", Font.BOLD, 18));
        add(Services);
        JLabel Available = new JLabel("Doctors Available (TODAY)");
        Available.setBounds(725, 320, 550, 150);
        Available.setForeground(commonconstant.TEXT_COLOR);
        Available.setFont(new Font("Serif", Font.BOLD, 18));
        add(Available);

        //Services available menu



        add(BGwhite);
        add(BGblack);
    }

}



