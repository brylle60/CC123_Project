package gui;

import constant.commonconstant;
import javax.swing.*;

public class homepage extends JFrame {
    public homepage (String title) {
        //The main doctors panel
        super(title);
        setSize(1250, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);



        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BUTTON_COLOR);

        }
    }
