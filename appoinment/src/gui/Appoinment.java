
package gui;

import com.sun.tools.attach.AgentInitializationException;
import constant.commonconstant;
import db.userDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.Enumeration;

import static db.userDb.book;
import static db.userDb.validateuser;


public class Appoinment extends homepage {

    private LocalTime time;
    private ButtonGroup appointmentTypeGroup;
    private JRadioButton selectedAppointmentType;

    private LocalTime getCurrentTime() {
        return LocalTime.now();
    }
    public Appoinment(){
        super("Appointment Booking");
        addGuiComponents();

    }

    private void addGuiComponents() {
      time = getCurrentTime();

        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(50, 100, 300, 25);
        lastName .setForeground(commonconstant.TEXT_COLOR);
        lastName .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField lastNamefield = new JTextField();
        lastNamefield.setBounds(50, 130, 250, 25);
        lastNamefield.setBackground(commonconstant.SECONDARY_COLOR);
        lastNamefield.setForeground(commonconstant.TEXT_COLOR);
        lastNamefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(lastName);
        add(lastNamefield);

        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(50, 160, 300, 25);
        firstname .setForeground(commonconstant.TEXT_COLOR);
        firstname .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField firstnamefield = new JTextField();
        firstnamefield.setBounds(50, 190, 250, 25);
        firstnamefield.setBackground(commonconstant.SECONDARY_COLOR);
        firstnamefield.setForeground(commonconstant.TEXT_COLOR);
        firstnamefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(firstname);
        add(firstnamefield);

        JLabel MI = new JLabel("Middle Name");
        MI.setBounds(50, 210, 300, 25);
        MI.setForeground(commonconstant.TEXT_COLOR);
        MI.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField Mifield = new JTextField();
        Mifield.setBounds(50, 240, 250, 25);
        Mifield.setBackground(commonconstant.SECONDARY_COLOR);
        Mifield.setForeground(commonconstant.TEXT_COLOR);
        Mifield.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel age = new JLabel("Age");
        age.setBounds(50, 270, 300, 25);
        age.setForeground(commonconstant.TEXT_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField agefield = new JTextField();
        agefield.setBounds(50, 300, 150, 25);
        agefield.setBackground(commonconstant.SECONDARY_COLOR);
        agefield.setForeground(commonconstant.TEXT_COLOR);
        agefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(MI);
        add(Mifield);
        add(age);
        add(agefield);

        JLabel id = new JLabel("ID");
        id .setBounds(50, 330, 300, 25);
        id .setForeground(commonconstant.TEXT_COLOR);
        id .setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField IdField = new JTextField();
        IdField.setBounds(50, 360, 150, 25);
        IdField.setBackground(commonconstant.SECONDARY_COLOR);
        IdField.setForeground(commonconstant.TEXT_COLOR);
        IdField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(id);
        add(IdField);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 390, 200, 25);
        gender.setForeground(commonconstant.TEXT_COLOR);
        gender.setFont(new Font("Dialog",Font.PLAIN, 24));

        JTextField genderflield = new JTextField();
        genderflield.setBounds(50, 415, 150, 25);
        genderflield.setForeground(commonconstant.TEXT_COLOR);
        genderflield.setFont(new Font("Dialog",Font.PLAIN, 24));

        add(gender);
        add(genderflield);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50, 440,300, 25);
        Address.setForeground(commonconstant.TEXT_COLOR);
        Address.setFont(new Font("Dialog",Font.PLAIN, 24));

        JTextField Addressfield = new JTextField();
        Addressfield.setBounds(50, 470, 350, 25);
        Addressfield.setForeground(commonconstant.TEXT_COLOR);
        Addressfield.setFont(new Font("Dialog",Font.PLAIN, 24));


        add(Address);
        add(Addressfield);


        JLabel number = new JLabel("Mobile Number");
        number.setBounds(50, 500,300, 25);
        number.setForeground(commonconstant.TEXT_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 24));

        JTextField numberfield = new JTextField();
        numberfield.setBounds(50, 530, 350, 25);
        numberfield.setForeground(commonconstant.TEXT_COLOR);
        numberfield.setFont(new Font("Dialog",Font.PLAIN, 24));


        add(number);
        add(numberfield);


        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel();
        panel.add(panelLabel, BorderLayout.CENTER);
        panel.setBackground(new Color (255, 255, 255, 50));
        // Set the size and location of the panel
        panel.setBounds( 30, 85, 500, 600);

        // Add the panel to the main container
        add(panel);



        JPanel appointmentTypePanel = new JPanel();
        appointmentTypePanel.setBackground(commonconstant.BUTTON_COLOR);
        appointmentTypePanel.setLayout(new GridLayout(0, 1, 10, 10)); // Set layout for vertical arrangement
        appointmentTypePanel.setBounds(500, 200, 300, 200); // Set the position and size of the panel
        appointmentTypePanel.setVisible(false); // Initially make it invisible

        // Create radio buttons for different appointment types
        JRadioButton generalCheckup = new JRadioButton("General Checkup");
        JRadioButton dentalCheckup = new JRadioButton("Dental Checkup");
        JRadioButton eyeCheckup = new JRadioButton("Eye Checkup");
// Add more radio buttons as needed

// Add radio buttons to a ButtonGroup to ensure only one selection
        appointmentTypeGroup = new ButtonGroup();
        appointmentTypeGroup.add(generalCheckup);
        appointmentTypeGroup.add(dentalCheckup);
        appointmentTypeGroup.add(eyeCheckup);

// Add radio buttons to the panel
        appointmentTypePanel.add(generalCheckup);
        appointmentTypePanel.add(dentalCheckup);
        appointmentTypePanel.add(eyeCheckup);

        add(appointmentTypePanel); // Add the panel to the main container
        //reserved space for database

        JButton submitButton = new JButton("Book Appointment");
        submitButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {


                Appoinment.this.dispose();
                new home().setVisible(true);
            }

        });
//        submitButton.addActionListener(e -> submitAppointment());
        submitButton.addActionListener(e -> submitAppointment());// Add the button to the appointment type panel

        appointmentTypePanel.add(submitButton);

        JButton Booknow = new JButton("Register");
        Booknow.setForeground(commonconstant.TEXT_COLOR);
        Booknow.setFont(new Font("Dialog", Font.BOLD, 18));
        Booknow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Booknow.setBackground(commonconstant.BUTTON_COLOR);
        Booknow.setBounds(200, 600, 250,50);
        Booknow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //database validation for users
               int Id = Integer.parseInt(IdField.getText());
                String LastName = lastNamefield.getText();
                String firstname = firstnamefield.getText();
                String MI = Mifield.getText();
                String gender = genderflield.getText();
                String Address = Addressfield.getText();
                int number = Integer.parseInt(numberfield.getText());
                appointmentTypePanel.setVisible(true);
                String appointment = null;

                if (selectedAppointmentType != null) {


                    appointment = selectedAppointmentType.getText();
                } else {
                    JOptionPane.showMessageDialog(Appoinment.this, "Please select an appointment type");
                    return; // Exit the method if no appointment type is selected
                }




                if(validateuserinput(Id, LastName, firstname, MI, gender, Address, number, appointment)){
                    if(book(Id,LastName, firstname, MI, time,gender, Address, number, appointment)){


                        home home = new home();
                        Appoinment.this.dispose();
                        new home().setVisible(true);


                        JOptionPane.showMessageDialog(home, "Booked account successfully");


                    }else {
                        JOptionPane.showMessageDialog(Appoinment.this, "Error: Name already taken");
                    }
                }else{
                    JOptionPane.showMessageDialog(Appoinment.this, "Error. Name and id must contain words and/or value\n");
                }
            }
        });

        add(Booknow);











    }
    private boolean validateuserinput( int id, String lastName, String firstname, String middle_name, String Gender, String Address, int number, String appointment ) {
        //database
        if (id == 0 || lastName.length() == 0 || firstname.length() == 0 || middle_name.length() == 0 || Gender.length() == 0 || Address.length() == 0 || number == 0 || appointment.length() == 0)
            return false;

        if (id < 6 || false) return false;
        if(lastName.isBlank()) return false;
        if(firstname.isBlank()) return false;
        if (middle_name.isBlank()) return false;
        if(Gender.length() > 2) return false;
        if(number == 12)  return false;


        return true;
    }
    // Add this method
    private void submitAppointment() {
        ButtonModel selectedModel = appointmentTypeGroup.getSelection();
        if (selectedModel != null) {
            for (Enumeration<AbstractButton> buttons = appointmentTypeGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.getModel() == selectedModel) {
                    selectedAppointmentType = (JRadioButton) button;
                    String selectedAppointment = selectedAppointmentType.getText();
                    JOptionPane.showMessageDialog(Appoinment.this,"Selected appointment type: " + selectedAppointment);
                    // Do something with the selected appointment type
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(Appoinment.this,"No appointment type selected.");
        }
    }
} 