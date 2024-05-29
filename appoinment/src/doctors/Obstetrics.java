package doctors;

import constant.commonconstant;
import db.pedia;
import gui.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Obstetrics extends doctors{

    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private String address1;
    private String sex1;
    private String email;
    private int number1;
    private int age1;
    private int id1;



    public Obstetrics(){
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

        ImageIcon patientIcon = new ImageIcon("appoinment/src/image/DR SHER.png");
        JLabel patientLabel = new JLabel(patientIcon);
        patientLabel.setBounds(105, 154, 170, 170); // Adjust the position and size as needed

        JLabel doctorn3= new JLabel("Dr. Sherilyn Sanchez");
        doctorn3.setBounds(-5, 300, 400, 100);
        doctorn3.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn3.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen3= new JLabel("OBSTETRICS GYNECOLOGY");
        servicen3.setBounds(-3, 330, 400, 100);
        servicen3.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen3.setFont(new Font("Arial", Font.BOLD, 15));
        servicen3.setHorizontalAlignment(SwingConstants.CENTER);

        add(servicen3);
        add(doctorn3);
        add(logoLabel);
        add(patientLabel);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Dialog", Font.BOLD,18));
        back.setForeground(commonconstant.SECONDARY_COLOR);
        back.setBackground(commonconstant.DARK_BLUE);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Obstetrics.this.dispose();
                new DoctorTypeAppointment(id1,loggedInLastName, loggedInFirstName, loggedInMiddleName, sex1, age1, number1, email, address1).setVisible(true);
            }
        });
        back.setBounds(1020,100,130,30);



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


        JLabel select = new JLabel("Select Appointment Date");
        select.setBounds(450,510,200,30);
        select.setForeground(commonconstant.TEXT_COLOR);
        select.setFont(new Font("Dialog",Font.PLAIN,18));

        JLabel birthdatetxtformat = new JLabel("mm/dd/year:");
        birthdatetxtformat.setBounds(450,535,130,30);
        birthdatetxtformat.setForeground(commonconstant.TEXT_COLOR);
        birthdatetxtformat.setFont(new Font("Dialog",Font.PLAIN,18));

        String [] birthdate = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        JComboBox<String> Birthdate = new JComboBox<>(birthdate);
        Birthdate.setFont(new Font("Dialog",Font.PLAIN,18));
        Birthdate.setForeground(commonconstant.TEXT_COLOR);
        Birthdate.setBounds(450,570,130,30);

        String [] Birthdate1={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        JComboBox<String>birthdate1 = new JComboBox<>(Birthdate1);
        birthdate1.setFont(new Font("Dialog",Font.PLAIN,18));
        birthdate1.setForeground(commonconstant.TEXT_COLOR);
        birthdate1.setBounds(585,570,130,30);

        String [] Birthdate2= {"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017",
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

        JComboBox<String> birthdate2 = new JComboBox<>(Birthdate2);
        birthdate2.setFont(new Font("Dialog",Font.PLAIN,18));
        birthdate2.setForeground(commonconstant.TEXT_COLOR);
        birthdate2.setBounds(720,570,130,30);



        JButton submit = new JButton("SUBMIT");
        submit.setFont(new Font("DIALOG", Font.BOLD, 18));
        submit.setForeground(commonconstant.SECONDARY_COLOR);
        submit.setBackground(commonconstant.DARK_BLUE);
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String last_name = lNamefield.getText();
                String first_name = fNamefield.getText();
                String middle_name = Mifield.getText();
                String ageString = agefield.getText().trim();
                String sex = (String) comboBox.getSelectedItem();
                String address = Addressfield.getText();
                String numberString = numberfield.getText().trim();

                // Check if any of the required fields are empty
                if (last_name.isEmpty() || first_name.isEmpty() || middle_name.isEmpty() || ageString.isEmpty() || sex.isEmpty() || address.isEmpty() || numberString.isEmpty()) {
                    JOptionPane.showMessageDialog(Obstetrics.this, "Please fill in all the required fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                int age = 0;
                long number = 0;

                try {
                    age = Integer.parseInt(ageString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Obstetrics.this, "Invalid age. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                try {
                    number = Long.parseLong(numberString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Obstetrics.this, "Invalid mobile number. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without proceeding further
                }

                if (validateUser(last_name, first_name, middle_name, sex, age, number, address)) {
                    if (pedia.register(last_name, first_name, middle_name, sex, age, number, address)) {
                        Obstetrics.this.dispose();

                        home home = new home(id1, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex1, age1, number1, email, address1);
                        home.setVisible(true);
                        JOptionPane.showMessageDialog(home, " Appointment Sent Successfully\n" + "wait for confirmation");
                    }
                } else {
                    JOptionPane.showMessageDialog(Obstetrics.this, " Incorrect Input");
                }
            }
        });
        submit.setBounds(950,650,200,50);
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
        add(birthdatetxtformat);
        add(select);
        add(Birthdate);
        add(birthdate1);
        add(birthdate2);
        add(Address);
        add(Addressfield);
        add(number);
        add(numberfield);
        add(back);
        add(losLabel);
        add(Patient3Panel);

    }
    private boolean validateUser( String Last_name, String first_name, String middle_name, String sex, int age, long number, String address){
        if ( Last_name.length() == 0 || first_name.length() == 0 || middle_name.length() == 0 || sex.length()==0 || age == 0 || number == 0 || address.length()==0) return false;

        return true;
    }

}