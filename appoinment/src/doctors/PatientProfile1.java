package doctors;

import constant.TimeSlotManager;
import constant.commonconstant;
import gui.UserProfile;
import gui.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.MalformedParametersException;
import java.time.LocalTime;

public class PatientProfile1 extends doctors{

    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age;
    private int number;
    private String address;
    private int id;
    private String sex;
    private String email;


    public PatientProfile1(){
        super("Health Appointment");
        addDoctorComponents();

    }

    private void addDoctorComponents() {
        JPanel Patient3Panel = new JPanel();
        Patient3Panel.setLayout(null);

        Patient3Panel.setBounds(0, 0, 400, 700);

        ImageIcon losIcon = new ImageIcon("appoinment/src/image/img.png");
        JLabel losLabel = new JLabel(losIcon);
        losLabel.setBounds(400,0,1000,700);

        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 0, 180, 100); // Adjust the position and size as needed

        ImageIcon patientIcon = new ImageIcon("appoinment/src/image/DR KHEN.png");
        JLabel patientLabel = new JLabel(patientIcon);
        patientLabel.setBounds(105, 154, 170, 170); // Adjust the position and size as needed

        JLabel doctorn3= new JLabel("Dr. Khen Lloyed Baylon");
        doctorn3.setBounds(-5, 300, 400, 100);
        doctorn3.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn3.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen3= new JLabel("OPHTHALMOLOGIST");
        servicen3.setBounds(-3, 330, 400, 100);
        servicen3.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen3.setFont(new Font("Arial", Font.BOLD, 15));
        servicen3.setHorizontalAlignment(SwingConstants.CENTER);

        add(servicen3);
        add(doctorn3);
        add(logoLabel);
        add(patientLabel);

        JButton submit = new JButton("SUBMIT");
        submit.setFont(new Font("DIALOG", Font.BOLD, 18));
        submit.setForeground(commonconstant.SECONDARY_COLOR);
        submit.setBackground(commonconstant.DARK_BLUE);
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                PatientProfile1.this.dispose();
                new home(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);
            }
        });
        submit.setBounds(770,530,200,50);
       add(submit);





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

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(650, 345, 200, 25);
        genderLabel.setForeground(commonconstant.TEXT_COLOR);
        genderLabel.setFont(new Font("Dialog", Font.PLAIN, 18));


        String[] genderType={
                "Male",
                "Female",
        };

        JComboBox<String> comboBox = new JComboBox<>(genderType);
        comboBox.setFont(new Font("Dialog", Font.PLAIN,20));
        comboBox.setForeground(commonconstant.TEXT_COLOR);
        comboBox.setBounds(650, 372, 100, 25);



        JTextField genderflield = new JTextField();
        genderflield.setBounds(450, 470, 150, 25);
        genderflield.setForeground(commonconstant.TEXT_COLOR);
        genderflield.setFont(new Font("Dialog",Font.PLAIN, 24));


        JLabel Address = new JLabel("Address");
        Address.setBounds(450, 395,300, 25);
        Address.setForeground(commonconstant.TEXT_COLOR);
        Address.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Addressfield = new JTextField();
        Addressfield.setBounds(450, 420, 350, 25);
        Addressfield.setForeground(commonconstant.TEXT_COLOR);
        Addressfield.setFont(new Font("Dialog",Font.PLAIN, 24));

        JLabel number = new JLabel("Mobile Number");
        number.setBounds(450, 445,300, 25);
        number.setForeground(commonconstant.TEXT_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField numberfield = new JTextField();
        numberfield.setBounds(450, 472, 350, 25);
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
        add(genderLabel);
        add(comboBox);
        add(Address);
        add(Addressfield);
        add(number);
        add(numberfield);
        add(losLabel);
        add(Patient3Panel);

    }
}