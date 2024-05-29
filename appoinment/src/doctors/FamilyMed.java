package doctors;
import constant.TimeSlotManager;
import constant.commonconstant;
import doctors.DoctorpageComponents;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class FamilyMed extends DoctorpageComponents {
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

        JLabel timeLabel = new JLabel("Select Time Slot:");
        timeLabel.setBounds(460, 190, 200, 25);
        timeLabel.setForeground(commonconstant.TEXT_COLOR);
        timeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

//
        JComboBox<LocalTime> timeComboBox1 = new JComboBox<>();
        timeComboBox1.setBounds(460, 220, 150, 25);
        timeComboBox1.setBackground(commonconstant.SECONDARY_COLOR);
        timeComboBox1.setForeground(commonconstant.TEXT_COLOR);
        timeComboBox1.setFont(new Font("Dialog", Font.PLAIN, 14));

        // Add available time slots to the combo box
        for (LocalTime time : TimeSlotManager.timeSlots.keySet()) {
            timeComboBox1.addItem(time);
        }



        add(timeLabel);
        add(timeComboBox1);





        add(famMedDR);




    }
}
