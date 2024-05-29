package gui;

import constant.TimeSlotManager;
import constant.commonconstant;

import javax.swing.*;
public class DescriptionPage extends JFrame {
    public  DescriptionPage (String title){
        //The main gui panel
        super(title);
        setSize(850, 686);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

//
        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BLUE_COLOR);

    }

}
