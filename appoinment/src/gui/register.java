package gui;

import constant.commonconstant;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class register extends form {
    public register() {
        super("MedCare Appointment System");
        addGuiComponents();

    }

    private void addGuiComponents() {
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logo.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);

        logoLabel.setBounds(42, -10, 300, 300); // Adjust the position and size as needed
        add(logoLabel);




        JLabel registerlabel = new JLabel("MEDCare");
        registerlabel .setBounds(470, 40, 520, 100);
        registerlabel.setForeground(commonconstant.BUTTON_COLOR);
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 30));

        add(registerlabel);
//
        JLabel registerlabel2 = new JLabel("Registration");
        registerlabel2 .setBounds(610, 40, 520, 100);
        registerlabel2.setForeground(commonconstant.HOME_BG1_GRAY);
        registerlabel2.setFont(new Font("Dialog", Font.BOLD, 30));
        add(registerlabel2);


        //MEDCARE Medical Appointment!
        JLabel description1label = new JLabel("Welcome to ");
        description1label.setBounds(45, 295, 400, 25);
        description1label.setForeground(commonconstant.DARKERBLUE_REG);
        description1label.setFont(new Font("Georgia",Font.PLAIN, 16));

        add(description1label);
        //
        JLabel description1Alabel = new JLabel("MEDCARE");
        description1Alabel.setBounds(135, 295, 400, 25);
        description1Alabel.setForeground(commonconstant.DARKTEAL_REGISTER);
        description1Alabel.setFont(new Font("Georgia",Font.BOLD, 20));
        add(description1Alabel);
//
        JLabel description1Blabel = new JLabel("Medical Appointment!");
        description1Blabel.setBounds(135, 325, 400, 25);
        description1Blabel.setForeground(commonconstant.TEAL_REGISTER);
        description1Blabel.setFont(new Font("Times New Roman",Font.BOLD, 21));
        add(description1Blabel);

//add description
        JLabel description2label = new JLabel("We are dedicated to revolutionizing ");
        description2label.setBounds(85, 400, 500, 25);
        description2label.setForeground(commonconstant.HOME_BG1_BLUE);
        description2label.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2label);

        JLabel description2Alabel = new JLabel("the way you manage your healthcare appointments. ");
        description2Alabel.setBounds(33, 425, 500, 25);
        description2Alabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Alabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Alabel);

        JLabel description2Blabel = new JLabel("Our platform is designed to provide seamless ");
        description2Blabel.setBounds(51, 450, 500, 25);
        description2Blabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Blabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Blabel);

        JLabel description2Clabel = new JLabel("scheduling, ensuring you can access ");
        description2Clabel.setBounds(77, 475, 500, 25);
        description2Clabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Clabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Clabel);

        JLabel description2Dlabel = new JLabel("medical care conveniently and efficiently.");
        description2Dlabel.setBounds(62, 500, 500, 25);
        description2Dlabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Dlabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Dlabel);

        // add new username label

        JLabel namelabel = new JLabel("Username:");
        namelabel.setBounds(450, 155, 400, 25);
        namelabel.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField = new JTextField();
        nameField.setBounds(450, 190, 350, 35);
        nameField.setBackground(commonconstant.SECONDARY_COLOR);
        nameField.setForeground(commonconstant.TEXT_COLOR);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(namelabel);
        add(nameField);


        // add email label
        JLabel email = new JLabel("E-mail Address:");
        email.setBounds(450, 240, 400, 25);
        email.setForeground(commonconstant.SECONDARY_COLOR);
        email.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField emailField = new JTextField();

        emailField.setBounds(450, 270, 350, 35);
        emailField.setBackground(commonconstant.SECONDARY_COLOR);
        emailField.setForeground(commonconstant.TEXT_COLOR);

        add(email);
        add(emailField);

        //password label
        JLabel passwordlabel = new JLabel("Password:");

        passwordlabel.setBounds(450, 315, 400, 25);
        passwordlabel.setFont(new Font("Dialog",Font.PLAIN, 18));
        passwordlabel.setForeground(commonconstant.SECONDARY_COLOR);

        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(450, 340, 350, 35);
        passwordField.setBackground(commonconstant.SECONDARY_COLOR);
        passwordField.setForeground(commonconstant.TEXT_COLOR);

        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwordlabel);
        add(passwordField);

        //confirm password
        JLabel rePassword = new JLabel("Confirm Password:");
        rePassword.setBounds(450, 390, 400, 25);
        rePassword.setFont(new Font("Dialog",Font.PLAIN, 18));
        rePassword.setForeground(commonconstant.SECONDARY_COLOR);

        JPasswordField repasswordField = new JPasswordField();

        //confirm password
        repasswordField.setBounds(450, 415, 350, 35);
        repasswordField.setBackground(commonconstant.SECONDARY_COLOR);
        repasswordField.setForeground(commonconstant.TEXT_COLOR);
        repasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(rePassword);
        add(repasswordField);


        //registration button
        JButton regiserButton = new JButton("Register");
        regiserButton.setForeground(commonconstant.SECONDARY_COLOR);

        regiserButton.setFont(new Font("Dialog", Font.BOLD, 18));

        regiserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regiserButton.setBackground(commonconstant.BUTTON_COLOR);

        regiserButton.setBounds(500, 500, 250,50);
        regiserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //database validation for users
                String username = nameField.getText();
                String passsword = new String(passwordField.getPassword());
                String rePassword = new String(repasswordField.getPassword());
                String email = new String(emailField.getText());
                Boolean logg = true;

                if(validateuserinput(username, passsword, rePassword, email)){
                    if(MyJDBC.register(username,email, passsword, logg)){
                        register.this.dispose();
                        loginpage login = new loginpage();
                        login.setVisible(true);
                        JOptionPane.showMessageDialog(login, "Registered Account Successfully");

                    }else {  JOptionPane.showMessageDialog(register.this, "Error: Username is already taken");
                    }
                }else{JOptionPane.showMessageDialog(register.this, "Error. Username must contain 6 characters\n"+"and/or password must match in confirm password\n"+"and/or email is missing");
                }
            }
        });
        add(regiserButton);

        JLabel loginLabel2 = new JLabel("Have already an account?");
        loginLabel2.setForeground(commonconstant.SECONDARY_COLOR);
        loginLabel2.setBounds(513, 575, 250, 30);
        add(loginLabel2);

        JLabel loginLabel = new JLabel("<html><u>LOGIN HERE!</u></html>");
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        loginLabel.setForeground(commonconstant.DARKERBLUE_REG);
        // if the user have already an account or have an existing account

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register.this.dispose();

                new loginpage().setVisible(true);
            }
        });

        loginLabel.setBounds(663, 575, 250, 30);
        add(loginLabel);

        //Panel Transparent
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (0, 0, 0, 80));
        // Set the size and location of the panel
        panel1.setBounds( 400, 0, 700, 700);



        // Add the panel to the main container
        add(panel1);


        //stethoscope background picture
        ImageIcon image = new ImageIcon("appoinment/src/image/scope1.png");
        JLabel image2 = new JLabel(image);
        image2.setBounds(400, 0, 450, 700); // Adjust the position and size as needed
        add(image2);


        //abstract background picture
        ImageIcon imageA = new ImageIcon("appoinment/src/image/abstract(2.png");
        JLabel image3 = new JLabel(imageA);
        image3.setBounds(-50, 0, 450, 700); // Adjust the position and size as needed
        add(image3);

    }
    private boolean validateuserinput( String username, String password, String rePassword, String email){
        //database
        if (username.length()==0 || password.length()==0||rePassword.length()==0 || email.length() ==0) return false;

        if (username.length()<6)return  false;

        if (!password.equals(rePassword)) return false;
        if(email.isBlank())   return false;

        return true;


    }
    }


