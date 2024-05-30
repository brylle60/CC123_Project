package doctors;
import TIMESLOTS.TimeSlots;
import constant.commonconstant;
import gui.form2Register;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class DoctorpageComponents extends form2Register {
    public DoctorpageComponents(String title){
        super(title);
        addGUIDoctor();
    }

    public void addGUIDoctor(){

        //background
        JPanel bg1 = new JPanel(null);
        bg1.setBackground(commonconstant.BUTTON_COLOR);
        bg1.setBounds(90,80, 1000, 600);


        //buttons for directions

        //change time if when the doc is avail
        JButton availabletime = new JButton("Time Available");
        availabletime.setForeground(commonconstant.TEXT_COLOR);
        availabletime.setBackground(commonconstant.SECONDARY_COLOR);
        availabletime.setBounds(200,100,150,60);

        JLabel timeLabel = new JLabel("Time Available from: ");
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
        add(timeLabel);
        add(timeComboBox1);

        JLabel timeLabel2 = new JLabel("Time Available from: ");
        timeLabel2.setBounds(460, 190, 200, 25);
        timeLabel2.setForeground(commonconstant.TEXT_COLOR);
        timeLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));

//
        JComboBox<LocalTime> timeComboBox2 = new JComboBox<>();
        timeComboBox2.setBounds(660, 220, 150, 25);
        timeComboBox2.setBackground(commonconstant.SECONDARY_COLOR);
        timeComboBox2.setForeground(commonconstant.TEXT_COLOR);
        timeComboBox2.setFont(new Font("Dialog", Font.PLAIN, 14));

        // Add available time slots to the combo box

        add(timeLabel2);
        add(timeComboBox2);


            //requests table
        JButton requestForAppointment= new JButton("Requests");
        requestForAppointment.setForeground(commonconstant.TEXT_COLOR);
        requestForAppointment.setBackground(commonconstant.SECONDARY_COLOR);
        requestForAppointment.setBounds(200,200,100,60);



        //confimed table
        JButton confirmedAppointments = new JButton("Confirmed Appointments");
        confirmedAppointments.setForeground(commonconstant.TEXT_COLOR);
        confirmedAppointments.setBackground(commonconstant.SECONDARY_COLOR);
        confirmedAppointments.setBounds(200,300,200,60);

        //todays appointment table
        JButton todaysAppointment = new JButton("Today's Appointments");
        todaysAppointment.setForeground(commonconstant.TEXT_COLOR);
        todaysAppointment.setBackground(commonconstant.SECONDARY_COLOR);
        todaysAppointment.setBounds(200,300,200,60);


        //finished appointment table
        JButton finishedAppointment= new JButton("Finished Appointments");
        finishedAppointment.setForeground(commonconstant.TEXT_COLOR);
        finishedAppointment.setBackground(commonconstant.SECONDARY_COLOR);
        finishedAppointment.setBounds(200,400,200,60);

        //back button
        JButton backButton= new JButton("Back");
        backButton.setForeground(commonconstant.TEXT_COLOR);
        backButton.setBackground(commonconstant.SECONDARY_COLOR);
        backButton.setBounds(200,1000,200,60);


        // cancel button for confirmed appointments
        JButton cancelButton= new JButton("Cancel");
        cancelButton.setForeground(commonconstant.TEXT_COLOR);
        cancelButton.setBackground(commonconstant.SECONDARY_COLOR);
        cancelButton.setBounds(200,1000,200,60);

        //finish button for confirmed appointments
        JButton finishedButton= new JButton("Finished");
        finishedButton.setForeground(commonconstant.TEXT_COLOR);
        finishedButton.setBackground(commonconstant.SECONDARY_COLOR);
        finishedButton.setBounds(200,400,200,60);

        JButton clearButton= new JButton("Clear");
        clearButton.setForeground(commonconstant.TEXT_COLOR);
        clearButton.setBackground(commonconstant.SECONDARY_COLOR);
        clearButton.setBounds(200,400,200,60);





        //add(clearButton);
        //add(finishedButton);
//        add(cancelButton);
        add(backButton);
        add(finishedAppointment);
        add(todaysAppointment);
        add(confirmedAppointments);
        add(requestForAppointment);
        add(availabletime);




    }
}
