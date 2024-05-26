package gui;
import javax.swing.*;
import java.awt.*;

public class FamilyMed extends DoctorpageComponents{
    public FamilyMed(){
        super("FAMILY DOCTOR's PAGE");

            addGUIDoctor();
            FamMed();
    }
    private void FamMed (){

        //doctors name
        JLabel famMedDR = new JLabel("WELCOME DR. CATRIONA GRAY");
        famMedDR.setFont(new Font("Times New Roman", Font.BOLD, 35));
        famMedDR.setBounds(90,20,700,35);

        add(famMedDR);




    }
}
