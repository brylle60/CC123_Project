package gui;

import constant.commonconstant;

import javax.swing.*;
public class form2Register extends JFrame {
    public  form2Register (String title){
        //The main gui panel
        super(title);
        setSize(1250, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BLUE_COLOR);

    }

}
