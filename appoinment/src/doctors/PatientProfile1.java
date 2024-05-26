package doctors;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;

public class PatientProfile1 extends doctors{
    public PatientProfile1(){
        super("Health Appointment");
        addDoctorComponents();

    }

    private void addDoctorComponents() {

        JLabel text1 = new JLabel("Patient Data");
        text1.setBounds(300, -50, 600, 400);
        text1.setForeground(commonconstant.BLUE_COLOR);
        text1.setFont(new Font("Dialog", Font.BOLD,30));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        add(text1);

        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(150, 190, 300, 25);
        lastName .setForeground(commonconstant.TEXT_COLOR);
        lastName .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField lastNamefield = new JTextField();
        lastNamefield.setBounds(150, 220, 250, 25);
        lastNamefield.setBackground(commonconstant.SECONDARY_COLOR);
        lastNamefield.setForeground(commonconstant.TEXT_COLOR);
        lastNamefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(150, 245, 300, 25);
        firstname .setForeground(commonconstant.TEXT_COLOR);
        firstname .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField firstnamefield = new JTextField();
        firstnamefield.setBounds(150, 270, 250, 25);
        firstnamefield.setBackground(commonconstant.SECONDARY_COLOR);
        firstnamefield.setForeground(commonconstant.TEXT_COLOR);
        firstnamefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel MI = new JLabel("Middle Name");
        MI.setBounds(150, 295, 300, 25);
        MI.setForeground(commonconstant.TEXT_COLOR);
        MI.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Mifield = new JTextField();
        Mifield.setBounds(150, 322, 250, 25);
        Mifield.setBackground(commonconstant.SECONDARY_COLOR);
        Mifield.setForeground(commonconstant.TEXT_COLOR);
        Mifield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel age = new JLabel("Age");
        age.setBounds(150, 345, 300, 25);
        age.setForeground(commonconstant.TEXT_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField agefield = new JTextField();
        agefield.setBounds(150, 372, 150, 25);
        agefield.setBackground(commonconstant.SECONDARY_COLOR);
        agefield.setForeground(commonconstant.TEXT_COLOR);
        agefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel gender = new JLabel("Gender");
        gender.setBounds(150, 445, 200, 25);
        gender.setForeground(commonconstant.TEXT_COLOR);
        gender.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField genderflield = new JTextField();
        genderflield.setBounds(150, 470, 150, 25);
        genderflield.setForeground(commonconstant.TEXT_COLOR);
        genderflield.setFont(new Font("Dialog",Font.PLAIN, 24));


        JLabel Address = new JLabel("Address");
        Address.setBounds(150, 495,300, 25);
        Address.setForeground(commonconstant.TEXT_COLOR);
        Address.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Addressfield = new JTextField();
        Addressfield.setBounds(150, 520, 350, 25);
        Addressfield.setForeground(commonconstant.TEXT_COLOR);
        Addressfield.setFont(new Font("Dialog",Font.PLAIN, 24));

        JLabel number = new JLabel("Mobile Number");
        number.setBounds(150, 545,300, 25);
        number.setForeground(commonconstant.TEXT_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField numberfield = new JTextField();
        numberfield.setBounds(150, 572, 350, 25);
        numberfield.setForeground(commonconstant.TEXT_COLOR);
        numberfield.setFont(new Font("Dialog",Font.PLAIN, 24));


        add(lastName);
        add(lastNamefield);
        add(firstname);
        add(firstnamefield);
        add(MI);
        add(Mifield);
        add(age);
        add(agefield);
        add(gender);
        add(genderflield);
        add(Address);
        add(Addressfield);
        add(number);
        add(numberfield);


    }
}
