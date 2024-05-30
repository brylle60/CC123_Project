package adminpage;

import constant.commonconstant;
import javax.swing.*;

public class DoctorRegistrationExtends extends JFrame{
    public DoctorRegistrationExtends(String title){
        super(title);
        setSize(900,730);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(commonconstant.BLUE_COLOR);
    }
}
