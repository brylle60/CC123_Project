package gui;

import constant.commonconstant;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JComboBox;

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
        registerlabel .setBounds(470, 5, 520, 100);
        registerlabel.setForeground(commonconstant.BUTTON_COLOR);
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 30));

        add(registerlabel);
//
        JLabel registerlabel2 = new JLabel("Registration");
        registerlabel2 .setBounds(610, 5, 520, 100);
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


        //last name
        JLabel namelabel1 = new JLabel("Last Name:");
        namelabel1.setBounds(450, 125, 400, 25);
        namelabel1.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel1.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField1 = new JTextField();
        nameField1.setBounds(450, 150, 350, 30);
        nameField1.setBackground(commonconstant.SECONDARY_COLOR);
        nameField1.setForeground(commonconstant.TEXT_COLOR);
        nameField1.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(namelabel1);
        add(nameField1);

        //first name
        JLabel namelabel2 = new JLabel("First Name:");
        namelabel2.setBounds(450, 170, 400, 25);
        namelabel2.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel2.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField2 = new JTextField();
        nameField2.setBounds(450, 190, 350, 30);
        nameField2.setBackground(commonconstant.SECONDARY_COLOR);
        nameField2.setForeground(commonconstant.TEXT_COLOR);
        nameField2.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(namelabel2);
        add(nameField2);

        //middle name
        JLabel namelabel3 = new JLabel("Middle Name:");
        namelabel3.setBounds(450, 225, 400, 25);
        namelabel3.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel3.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField3 = new JTextField();
        nameField3.setBounds(450, 190, 350, 35);
        nameField3.setBackground(commonconstant.SECONDARY_COLOR);
        nameField3.setForeground(commonconstant.TEXT_COLOR);
        nameField3.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(namelabel3);
        add(nameField3);

        //Sex
        String[] appointmentType = {
                "Male", "Female"
        };
        JComboBox<String> comboBox = new JComboBox<>(appointmentType);
        comboBox.setFont(new Font("Dialog", Font.PLAIN,18));
        comboBox.setForeground(commonconstant.TEXT_COLOR);
        comboBox.setBounds(230, 300, 100, 30);
        add(comboBox);

        //birthdate
        String[] birthdate = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};


        JComboBox<String> Birthdate = new JComboBox<>(birthdate);
        Birthdate.setFont(new Font("Dialog", Font.PLAIN,18));
        Birthdate.setForeground(commonconstant.TEXT_COLOR);
        Birthdate.setBounds(230, 400, 100, 30);
        add(Birthdate);

        //birthdate
        String[] birthdate1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> Birthdate1 = new JComboBox<>(birthdate1);
        Birthdate1.setFont(new Font("Dialog", Font.PLAIN,18));
        Birthdate1.setForeground(commonconstant.TEXT_COLOR);
        Birthdate1.setBounds(350, 400, 100, 30);
        add(Birthdate1);

        //birthdate
        String[] birthdate2 = {"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017",
                "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009",
                "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001",
                "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993",
                "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985",
                "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977",
                "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969",
                "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961",
                "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953",
                "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945",
                "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937",
                "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929",
                "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921",
                "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913",
                "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905",
                "1904", "1903", "1902", "1901", "1900"};

        JComboBox<String> Birthdate2 = new JComboBox<>(birthdate2);
        Birthdate2.setFont(new Font("Dialog", Font.PLAIN,18));
        Birthdate2.setForeground(commonconstant.TEXT_COLOR);
        Birthdate2.setBounds(350, 500, 100, 30);
        add(Birthdate2);

        //Age
        JLabel age = new JLabel("Age:");
        age.setBounds(450, 155, 400, 25);
        age.setForeground(commonconstant.SECONDARY_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField age1 = new JTextField();
        age1.setBounds(450, 190, 350, 35);
        age1.setBackground(commonconstant.SECONDARY_COLOR);
        age1.setForeground(commonconstant.TEXT_COLOR);
        age1.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(age);
        add(age1);
        //Address
        JLabel address1 = new JLabel("Address:");
        address1.setBounds(450, 155, 400, 25);
        address1.setForeground(commonconstant.SECONDARY_COLOR);
        address1.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField address2 = new JTextField();
        address2.setBounds(450, 190, 350, 35);
        address2.setBackground(commonconstant.SECONDARY_COLOR);
        address2.setForeground(commonconstant.TEXT_COLOR);
        address2.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(address1);
        add(address2);


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
                String LastName = nameField1.getText();
                String FirstName = nameField2.getText();
                String MiddleName = nameField3.getText();
                String sex = "";
                String passsword = new String(passwordField.getPassword());
                String rePassword = new String(repasswordField.getPassword());
                int number = 0;//Integer.parseInt(numberfield.getText());
                int age = Integer.parseInt(age1.getText());
                String email = new String(emailField.getText());
                String address = new String(address2.getText());

                LocalDate birthdate = null;
                Boolean logg = true;

                if(validateuserinput(LastName , FirstName , MiddleName , passsword, rePassword, email)){
                    if(MyJDBC.register(LastName, FirstName, MiddleName, sex, age, number, email , passsword, address, birthdate, logg)){
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
    private boolean validateuserinput(String username, String password, String rePassword, String email, String s, String string){
        //database
        if (username.length()==0 || password.length()==0||rePassword.length()==0 || email.length() ==0) return false;

        if (username.length()<6)return  false;

        if (!password.equals(rePassword)) return false;
        if(email.isBlank())   return false;

        return true;


    }
    }


