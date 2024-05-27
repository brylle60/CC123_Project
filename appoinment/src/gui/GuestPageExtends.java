package gui;

import constant.commonconstant;

import javax.swing.*;
public class GuestPageExtends extends JFrame {
    public  GuestPageExtends (String title){
        //The main gui panel
        super(title);
        setSize(1480, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
//

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BLUE_COLOR);

    }

}
