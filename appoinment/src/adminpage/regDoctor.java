package adminpage;

import db.doctorDb;
import constant.commonconstant;
import gui.form2Register;
import doctors.loginpageDoc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JComboBox;


public class regDoctor extends form2Register{
    private  static  int id;
  public static  String[] specializations = {
            "", "Cardiology", "Dermatology", "Endocrinology", "Gastroenterology",
            "Neurology", "Oncology", "Pediatrics", "Psychiatry", "Radiology",
            "Surgery", "Urology"
    };
    private JComboBox<String> combox;
    public regDoctor() {
        super("Doctor Register");
        addGuiComponents();

    }

    private void addGuiComponents() {
        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logo.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        // Create a JLabel to display the logo image
        JLabel logoLabel = new JLabel(logoIcon);

        logoLabel.setBounds(90, -10, 300, 300); // Adjust the position and size as needed
        add(logoLabel);




        JLabel registerlabel = new JLabel("MEDCare");
        registerlabel .setBounds(725, 5, 520, 100);
        registerlabel.setForeground(commonconstant.BUTTON_COLOR);
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 30));

        add(registerlabel);
//
        JLabel registerlabel2 = new JLabel("Registration ");
        registerlabel2 .setBounds(870, 5, 520, 100);
        registerlabel2.setForeground(commonconstant.HOME_BG1_GRAY);
        registerlabel2.setFont(new Font("Dialog", Font.BOLD, 30));
        add(registerlabel2);

 JLabel registerlabel3 = new JLabel("For Doctors ");
        registerlabel3 .setBounds(800, 40, 520, 100);
        registerlabel3.setForeground(commonconstant.HOME_BG1_GRAY);
        registerlabel3.setFont(new Font("Dialog", Font.BOLD, 30));
        add(registerlabel3);


        //MEDCARE Medical Appointment!
        JLabel description1label = new JLabel("Welcome to ");
        description1label.setBounds(95, 295, 400, 25);
        description1label.setForeground(commonconstant.DARKERBLUE_REG);
        description1label.setFont(new Font("Georgia",Font.PLAIN, 16));

        add(description1label);
        //
        JLabel description1Alabel = new JLabel("MEDCARE");
        description1Alabel.setBounds(185, 295, 400, 25);
        description1Alabel.setForeground(commonconstant.DARKTEAL_REGISTER);
        description1Alabel.setFont(new Font("Georgia",Font.BOLD, 20));
        add(description1Alabel);
//
        JLabel description1Blabel = new JLabel("Medical Appointment!");
        description1Blabel.setBounds(185, 325, 400, 25);
        description1Blabel.setForeground(commonconstant.TEAL_REGISTER);
        description1Blabel.setFont(new Font("Times New Roman",Font.BOLD, 21));
        add(description1Blabel);

//add description
        JLabel description2label = new JLabel("We are dedicated to revolutionizing ");
        description2label.setBounds(135, 400, 500, 25);
        description2label.setForeground(commonconstant.HOME_BG1_BLUE);
        description2label.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2label);

        JLabel description2Alabel = new JLabel("the way you manage your healthcare appointments. ");
        description2Alabel.setBounds(88, 425, 500, 25);
        description2Alabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Alabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Alabel);

        JLabel description2Blabel = new JLabel("Our platform is designed to provide seamless ");
        description2Blabel.setBounds(101, 450, 500, 25);
        description2Blabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Blabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Blabel);

        JLabel description2Clabel = new JLabel("scheduling, ensuring you can access ");
        description2Clabel.setBounds(127, 475, 500, 25);
        description2Clabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Clabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Clabel);

        JLabel description2Dlabel = new JLabel("medical care conveniently and efficiently.");
        description2Dlabel.setBounds(112, 500, 500, 25);
        description2Dlabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Dlabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Dlabel);


        //last name
        JLabel namelabel1 = new JLabel("Last Name:");
        namelabel1.setBounds(620, 125, 400, 25);
        namelabel1.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel1.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField1 = new JTextField();
        nameField1.setBounds(720, 125, 350, 30);
        nameField1.setBackground(commonconstant.SECONDARY_COLOR);
        nameField1.setForeground(commonconstant.TEXT_COLOR);
        nameField1.setFont(new Font("Dialog", Font.PLAIN, 15));

        add(namelabel1); //lastname
        add(nameField1); //LN txtfield

        //first name
        JLabel namelabel2 = new JLabel("First Name:");
        namelabel2.setBounds(620, 175, 400, 25);
        namelabel2.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel2.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField2 = new JTextField();
        nameField2.setBounds(720, 175, 350, 30);
        nameField2.setBackground(commonconstant.SECONDARY_COLOR);
        nameField2.setForeground(commonconstant.TEXT_COLOR);
        nameField2.setFont(new Font("Dialog", Font.PLAIN, 15));

        add(namelabel2);
        add(nameField2);

        //middle name
        JLabel namelabel3 = new JLabel("Middle Name:");
        namelabel3.setBounds(605, 225, 400, 25);
        namelabel3.setForeground(commonconstant.SECONDARY_COLOR);
        namelabel3.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField nameField3 = new JTextField();
        nameField3.setBounds(720, 225, 350, 35);
        nameField3.setBackground(commonconstant.SECONDARY_COLOR);
        nameField3.setForeground(commonconstant.TEXT_COLOR);
        nameField3.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(namelabel3);
        add(nameField3);

        //Sex

        JLabel sex = new JLabel("Sex:");
        sex.setBounds(860, 278, 400, 25);
        sex.setForeground(commonconstant.SECONDARY_COLOR);
        sex.setFont(new Font("Dialog",Font.PLAIN, 18));

        add(sex);

        String[] appointmentType = {
                "Male", "Female"
        };
        JComboBox<String> comboBox = new JComboBox<>(appointmentType);
        comboBox.setFont(new Font("Dialog", Font.PLAIN,18));
        comboBox.setForeground(commonconstant.TEXT_COLOR);
        comboBox.setBounds(900, 275, 100, 30);
        add(comboBox);

        JLabel birthdatetxt = new JLabel("Birth Date:");
        birthdatetxt.setBounds(620, 325, 400, 25);
        birthdatetxt.setForeground(commonconstant.SECONDARY_COLOR);
        birthdatetxt.setFont(new Font("Dialog",Font.PLAIN, 18));

        JLabel birthdatetxtformat = new JLabel("(mm-dd-yyyy)");
        birthdatetxtformat.setBounds(610, 345, 400, 25);
        birthdatetxtformat.setForeground(commonconstant.SECONDARY_COLOR);
        birthdatetxtformat.setFont(new Font("Dialog",Font.ITALIC, 15));


        add(birthdatetxt);
        add(birthdatetxtformat);
        //birthdate
        String[] birthdate = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};


        JComboBox<String> Birthdate = new JComboBox<>(birthdate);
        Birthdate.setFont(new Font("Dialog", Font.PLAIN,18));
        Birthdate.setForeground(commonconstant.TEXT_COLOR);
        Birthdate.setBounds(720, 325, 100, 30);
        add(Birthdate);

        //birthdate
        String[] birthdate1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> Birthdate1 = new JComboBox<>(birthdate1);
        Birthdate1.setFont(new Font("Dialog", Font.PLAIN,18));
        Birthdate1.setForeground(commonconstant.TEXT_COLOR);
        Birthdate1.setBounds(835, 325, 100, 30);
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
        Birthdate2.setBounds(950, 325, 100, 30);
        add(Birthdate2);

        //Age
        JLabel age = new JLabel("Age:");
        age.setBounds(620, 275, 400, 25);
        age.setForeground(commonconstant.SECONDARY_COLOR);
        age.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField age1 = new JTextField();
        age1.setBounds(720, 275, 80, 35);
        age1.setBackground(commonconstant.SECONDARY_COLOR);
        age1.setForeground(commonconstant.TEXT_COLOR);
        age1.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(age);
        add(age1);




        //Specialization
        JLabel specializationlabel = new JLabel("Specialization: ");
        specializationlabel.setBounds(590, 375, 400, 25);
        specializationlabel.setForeground(commonconstant.SECONDARY_COLOR);
        specializationlabel.setFont(new Font("Dialog",Font.PLAIN, 18));

        comboBox = new JComboBox<>(specializations);
        comboBox.setFont(new Font("Dialog", Font.PLAIN,18));
comboBox.setForeground(commonconstant.TEXT_COLOR);
        comboBox.setBounds(750, 375, 200, 30);

        add(comboBox);
        add(specializationlabel);

        JLabel address1 = new JLabel("Address:");
        address1.setBounds(620, 425, 400, 25);
        address1.setForeground(commonconstant.SECONDARY_COLOR);
        address1.setFont(new Font("Dialog",Font.PLAIN, 18));


        JTextField address2 = new JTextField();
        address2.setBounds(720, 425, 350, 35);
        address2.setBackground(commonconstant.SECONDARY_COLOR);
        address2.setForeground(commonconstant.TEXT_COLOR);
        address2.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(address1);
        add(address2);


        // add email label
        JLabel email = new JLabel("E-mail Address:");
        email.setBounds(580, 475, 400, 25);
        email.setForeground(commonconstant.SECONDARY_COLOR);
        email.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField emailField = new JTextField();

        emailField.setBounds(720, 475, 350, 35);
        emailField.setBackground(commonconstant.SECONDARY_COLOR);
        emailField.setForeground(commonconstant.TEXT_COLOR);

        add(email);
        add(emailField);

        JLabel number = new JLabel("Mobile Number: ");
        number.setBounds(580, 525, 400, 25);
        number.setForeground(commonconstant.SECONDARY_COLOR);
        number.setFont(new Font("Dialog",Font.PLAIN, 18));

        JTextField numberField = new JTextField();

        numberField.setBounds(720, 525, 350, 35);
        numberField.setBackground(commonconstant.SECONDARY_COLOR);
        numberField.setForeground(commonconstant.TEXT_COLOR);

        add(number);
        add(numberField);





        //password label
        JLabel passwordlabel = new JLabel("Password:");

        passwordlabel.setBounds(620, 575, 400, 25);
        passwordlabel.setFont(new Font("Dialog",Font.PLAIN, 18));
        passwordlabel.setForeground(commonconstant.SECONDARY_COLOR);

        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(720, 575, 350, 35);
        passwordField.setBackground(commonconstant.SECONDARY_COLOR);
        passwordField.setForeground(commonconstant.TEXT_COLOR);

        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwordlabel);
        add(passwordField);

        //confirm password
        JLabel rePassword = new JLabel("Confirm Password:");
        rePassword.setBounds(555, 625, 400, 25);
        rePassword.setFont(new Font("Dialog",Font.PLAIN, 18));
        rePassword.setForeground(commonconstant.SECONDARY_COLOR);

        JPasswordField repasswordField = new JPasswordField();

        //confirm password
        repasswordField.setBounds(720, 625, 350, 35);
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

        regiserButton.setBounds(770, 700, 250,50);
        JComboBox<String> finalComboBox = comboBox;
        regiserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String specialization = null;
                String LastName = null;
                String FirstName = null;
                String MiddleName = null;
                String sex = null;
                String passsword = null;
                String rePassword = null;
                long number = 0;
                int age = 0;
                String email = null;
                String address = null;
                String numberString = numberField.getText().trim(); // Trim any leading/trailing whitespace

                if (numberString.isEmpty()) {
                    // Handle the case where the numberField is empty
                    number = 0; // or any other default value you want to assign
                } else {
                    try {
                        number = Long.parseLong(numberString);
                    } catch (NumberFormatException ex) {
                        // Handle the case where the numberField contains an invalid value
                        JOptionPane.showMessageDialog(regDoctor.this, "Invalid mobile number. Please enter a valid number.");
                        return; // Exit the method without proceeding further
                    }
                }

                try {
                    //database validation for users
                    LastName = nameField1.getText();
                    FirstName = nameField2.getText();
                    MiddleName = nameField3.getText();
                    sex = (String) finalComboBox.getSelectedItem();
                    passsword = new String(passwordField.getPassword());
                    rePassword = new String(repasswordField.getPassword());
                    age = Integer.parseInt(age1.getText());
                    email = emailField.getText();
                    address= address2.getText();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(regDoctor.this, "Error: Invalid input. Please enter valid values.");
                    return;
                }
/// Get the selected value from the combo box
                String selectedMonth = (String) Birthdate.getSelectedItem();
                String selectedDay = (String) Birthdate1.getSelectedItem();
                String selectedYear = (String) Birthdate2.getSelectedItem();

// Convert the selected values to integers
                int month = Integer.parseInt(selectedMonth);
                int day = Integer.parseInt(selectedDay);
                int year = Integer.parseInt(selectedYear);

                 specialization = (String) finalComboBox.getSelectedItem();

// Create a LocalDate object from the selected values
                LocalDate birthdate = LocalDate.of(year, month, day);
                Boolean logg = true;


                if (validateuserinput(LastName,  FirstName,  MiddleName,  sex,  age,  number,  passsword,  rePassword,  email, birthdate , specialization)) {
                    if (doctorDb.book( LastName, FirstName,MiddleName, age, sex,passsword, number, birthdate,specialization, email, passsword )) {
                        regDoctor.this.dispose();
                        loginpageDoc login = new loginpageDoc();
                        login.setVisible(true);
                        JOptionPane.showMessageDialog(login, "Registered Account Successfully");
                    } else {
                        JOptionPane.showMessageDialog(regDoctor.this, "Error: Email already exists");
                    }
                } else {
                    JOptionPane.showMessageDialog(regDoctor.this, "Error. Username must contain 6 characters\n" + "and/or password must match in confirm password\n" + "and/or email is missing");
                }
            }
        });
        add(regiserButton);



        //Panel Transparent brown
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color (0, 0, 0, 80));
        // Set the size and location of the panel
        panel1.setBounds( 550, 0, 850, 780);



        // Add the panel to the main container
        add(panel1);


        //stethoscope background picture
        ImageIcon image = new ImageIcon("appoinment/src/image/scope1reg .png");
        JLabel image2 = new JLabel(image);
        image2.setBounds(550, 0, 725, 1000); // Adjust the position and size as needed
        add(image2); // right bg picture


        //abstract background picture
        ImageIcon imageA = new ImageIcon("appoinment/src/image/abstractreg.png");
        JLabel image3 = new JLabel(imageA);
        image3.setBounds(-50, 0, 725, 1000); // Adjust the position and size as needed
        add(image3); // left bg picture

    }
    private boolean validateuserinput(String LastName, String FirstName, String MiddleName, String sex, int age, long number, String password, String rePassword, String email, LocalDate birthdate, String specialization){
        //database
        if ( specialization.length() == 0 || password.length()==0||rePassword.length()==0 || email.length() == 0|| LastName.isBlank() || FirstName.isBlank() || MiddleName.isBlank() || sex.isBlank() || age == 0 || number == 0) return false;

        if (!password.equals(rePassword)) return false;
        if(email.isBlank())   return false;
        if(LastName.isEmpty()) return false;
        if (FirstName.isEmpty()) return false;
        if(MiddleName.isEmpty()) return false;
        if(sex.isEmpty()) return false;
        if (age < 0) return false;
        if (number < 0) return false;
        if (specialization.isBlank()) return false;

            return true;


    }
}




