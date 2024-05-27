package gui;

import javax.swing.*;
import java.awt.*;

public class OBGYN extends DoctorpageComponents{
    public OBGYN(){
        super("OBGYN DOCTOR's PAGE");
        addGUIDoctor();
        addGUIOBGYN();
    }
private void addGUIOBGYN(){
    //doctors name
    JLabel OBGYNtxt = new JLabel("WELCOME DR. ANGEL BABY");
    OBGYNtxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
    OBGYNtxt.setBounds(90,20,700,35);

    add(OBGYNtxt);




    }
}
