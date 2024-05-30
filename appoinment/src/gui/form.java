package gui;

import constant.commonconstant;

import javax.swing.*;
public class form extends JFrame {
    public  form (String title){
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
