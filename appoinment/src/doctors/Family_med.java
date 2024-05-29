package doctors;

import constant.commonconstant;
import db.fam_medDb;
import db.pedia;
import gui.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Family_med extends doctors{

    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age1;
    private String sex1;
    private String address1;
    private String email;
    private int number1;
    private int id1;



    public Family_med(){
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

        ImageIcon patientIcon = new ImageIcon("appoinment/src/image/DR BRYLL.png");
        JLabel patientLabel = new JLabel(patientIcon);
        patientLabel.setBounds(105, 154, 170, 170); // Adjust the position and size as needed

        JLabel doctorn3= new JLabel("Dr. John Brylle Crodua");
        doctorn3.setBounds(-5, 300, 400, 100);
        doctorn3.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn3.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen3= new JLabel("FAMILY MEDICINE");
        servicen3.setBounds(-3, 330, 400, 100);
        servicen3.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen3.setFont(new Font("Arial", Font.BOLD, 15));
        servicen3.setHorizontalAlignment(SwingConstants.CENTER);

        add(servicen3);
        add(doctorn3);
        add(logoLabel);
        add(patientLabel);

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


        JButton submit = new JButton("SUBMIT");
        submit.setFont(new Font("DIALOG", Font.BOLD, 18));
        submit.setForeground(commonconstant.SECONDARY_COLOR);
        submit.setBackground(commonconstant.DARK_BLUE);
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String last_name = lNamefield.getText();
                String first_name = fNamefield.getText();
                String middle_name = Mifield.getText();
                String ageString = agefield.getText().trim();
                String sex = (String) comboBox.getSelectedItem();
                String address = Addressfield.getText();
                String numberString = numberfield.getText().trim();

                // Check if any of the required fields are empty
                if (last_name.isEmpty() || first_name.isEmpty() || middle_name.isEmpty() || ageString.isEmpty() || sex.isEmpty() || address.isEmpty() || numberString.isEmpty()) {
                    JOptionPane.showMessageDialog(Family_med.this, "Please fill in all the required fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                int age = 0;
                long number = 0;

                try {
                    age = Integer.parseInt(ageString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Family_med.this, "Invalid age. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                try {
                    number = Long.parseLong(numberString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Family_med.this, "Invalid mobile number. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                if (validateUser(last_name, first_name, middle_name, sex, age, number, address)) {
                    if (fam_medDb.register(last_name, first_name, middle_name, sex, age, number, address)) {
                        home home = new home(id1, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex1, age1, number1, email, address1);
                        Family_med.this.dispose();
                        home.setVisible(true);
                        JOptionPane.showMessageDialog(home, " Appointment Sent Successfully\n" + "wait for confirmation");
                    }
                } else {
                    JOptionPane.showMessageDialog(Family_med.this, " Incorrect Input");
                }
            }
        });
        submit.setBounds(770,530,200,50);
        add(submit);




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
    private boolean validateUser( String Last_name, String first_name, String middle_name, String sex, int age, long number, String address){
        if ( Last_name.length() == 0 || first_name.length() == 0 || middle_name.length() == 0 || sex.length()==0 || age == 0 || number == 0 || address.length()==0) return false;

        return true;
    }

}