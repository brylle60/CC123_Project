package doctors;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;

public class PatientProfile4 extends doctors{
    public PatientProfile4(){
        super("Health Appointment");
        addDoctorComponents();

    }

    private void addDoctorComponents() {
        JPanel Patient4Panel = new JPanel();
        Patient4Panel.setLayout(null);

        Patient4Panel.setBounds(0, 0, 400, 700);

        ImageIcon logIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png");
        JLabel logLabel = new JLabel(logIcon);
        logLabel.setBounds(-18, -10, 180, 100); // Adjust the position and size as needed

        add(logLabel);

        JLabel text1 = new JLabel("Patient Details");
        text1.setBounds(250, -100, 600, 400);
        text1.setForeground(commonconstant.TEXT_COLOR);
        text1.setFont(new Font("Dialog", Font.BOLD,30));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        add(text1);
        JLabel text2 = new JLabel("Patient Details are required for your medical record. Please fill all the details below.");
        text2.setBounds(391, 28, 600, 200);
        text2.setForeground(commonconstant.TEXT_COLOR);
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        add(text2);

        JLabel fName = new JLabel("First Name");
        fName.setBounds(450, 170, 300, 25);
        fName.setForeground(commonconstant.TEXT_COLOR);
        fName.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField fNamefield = new JTextField();
        fNamefield.setBounds(450, 200, 450, 25);
        fNamefield.setBackground(commonconstant.SECONDARY_COLOR);
        fNamefield.setForeground(commonconstant.TEXT_COLOR);
        fNamefield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel midName = new JLabel("Middle Name");
        midName.setBounds(450, 240, 300, 25);
        midName.setForeground(commonconstant.TEXT_COLOR);
        midName.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Mifield = new JTextField();
        Mifield.setBounds(450, 265, 450, 25);
        Mifield.setBackground(commonconstant.SECONDARY_COLOR);
        Mifield.setForeground(commonconstant.TEXT_COLOR);
        Mifield.setFont(new Font("Dialog", Font.PLAIN, 24));


        JLabel lName= new JLabel("Last Name");
        lName.setBounds(450, 295, 300, 25);
        lName.setForeground(commonconstant.TEXT_COLOR);
        lName.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField lNamefield = new JTextField();
        lNamefield.setBounds(450, 322, 450, 25);
        lNamefield.setBackground(commonconstant.SECONDARY_COLOR);
        lNamefield.setForeground(commonconstant.TEXT_COLOR);
        lNamefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel age = new JLabel("Age");
        age.setBounds(450, 345, 300, 25);
        age.setForeground(commonconstant.TEXT_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField agefield = new JTextField();
        agefield.setBounds(450, 372, 150, 25);
        agefield.setBackground(commonconstant.SECONDARY_COLOR);
        agefield.setForeground(commonconstant.TEXT_COLOR);
        agefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel gender = new JLabel("Gender");
        gender.setBounds(450, 445, 200, 25);
        gender.setForeground(commonconstant.TEXT_COLOR);
        gender.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField genderflield = new JTextField();
        genderflield.setBounds(450, 470, 150, 25);
        genderflield.setForeground(commonconstant.TEXT_COLOR);
        genderflield.setFont(new Font("Dialog",Font.PLAIN, 24));


        JLabel Address = new JLabel("Address");
        Address.setBounds(450, 495,300, 25);
        Address.setForeground(commonconstant.TEXT_COLOR);
        Address.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Addressfield = new JTextField();
        Addressfield.setBounds(450, 520, 350, 25);
        Addressfield.setForeground(commonconstant.TEXT_COLOR);
        Addressfield.setFont(new Font("Dialog",Font.PLAIN, 24));

        JLabel number = new JLabel("Mobile Number");
        number.setBounds(450, 545,300, 25);
        number.setForeground(commonconstant.TEXT_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField numberfield = new JTextField();
        numberfield.setBounds(450, 572, 350, 25);
        numberfield.setForeground(commonconstant.TEXT_COLOR);
        numberfield.setFont(new Font("Dialog",Font.PLAIN, 24));


        add(lName);
        add(lNamefield);
        add(fName);
        add(fNamefield);
        add(midName);
        add(Mifield);
        add(age);
        add(agefield);
        add(gender);
        add(genderflield);
        add(Address);
        add(Addressfield);
        add(number);
        add(numberfield);
        add(Patient4Panel);

    }
}