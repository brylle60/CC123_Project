package adminpage;

import constant.commonconstant;

import javax.swing.*;

public class adminform extends JFrame {
    public adminform(String title){
        //The main gui panel
        super(title);
        setSize(850, 686);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.SECONDARY_COLOR);

    }
}
