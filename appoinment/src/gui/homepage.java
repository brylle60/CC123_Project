package gui;

import constant.TimeSlotManager;
import constant.commonconstant;
import javax.swing.*;

public class homepage extends JFrame {
    public homepage (String title) {
        //The main gui panel
        super(title);
        setSize(1250, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        TimeSlotManager.saveBookedTimeSlots();


        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BUTTON_COLOR);

        }
    }
