package gui;

import javax.swing.*;
import java.awt.*;

public class Opthalmologist extends DoctorpageComponents{
    public Opthalmologist(){
        super("OPTHALMOLOGIST DOCTOR's PAGE");
    addGUIDoctor();
    addGUIOptal();

    }
private void addGUIOptal(){
    //doctors name
    JLabel OptalTxt = new JLabel("WELCOME DR. SINETCH ITEY");
    OptalTxt.setFont(new Font("Times New Roman", Font.BOLD, 35));
    OptalTxt.setBounds(90,20,700,35);

    add(OptalTxt);
}

}
