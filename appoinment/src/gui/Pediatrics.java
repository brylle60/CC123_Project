package gui;

import javax.swing.*;
import java.awt.*;

public class Pediatrics extends DoctorpageComponents{
    public Pediatrics(){
        super("PEDIATRICS DOCTOR's PAGE");
        addGUIDoctor();
        addGUIPediatrics();

    }
    private void addGUIPediatrics(){
        //doctors name
        JLabel PediaTxt = new JLabel("WELCOME DR. SINETCH ITEY");
        PediaTxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
        PediaTxt.setBounds(90,20,700,35);

        add(PediaTxt);
    }

}
