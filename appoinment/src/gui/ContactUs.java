package gui;

import constant.commonconstant;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ContactUs extends homepage {


    public ContactUs(){
        super("ContactUs");
        addContactGUI();

    }

private void addContactGUI(){

    JPanel contactPanel = new JPanel();
    contactPanel.setLayout(null);
    contactPanel.setBounds(0,0, 1300, 900);

    ImageIcon logoIcon = new ImageIcon("appoinment/src/image/434024649_1363976920953749_3166889348485858378_n.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file


    // Create a JLabel to display the logo image
    JLabel logoLabel = new JLabel(logoIcon);
    logoLabel.setBounds(-10, 45, 180, 100); // Adjust the position and size as needed

    add(logoLabel);

    JLabel menulabel = new JLabel("Health");

    menulabel.setBounds(0, 53, 400, 100);
    menulabel.setForeground(commonconstant.HOME_BG1_BLUE);

    menulabel.setFont(new Font("Dialog", Font.BOLD, 20));

    menulabel.setHorizontalAlignment(SwingConstants.CENTER);


    JLabel menulabel2 = new JLabel("Appointment");

    menulabel2.setBounds(91, 53, 400, 100);
    menulabel2.setForeground(commonconstant.TEXT_COLOR);

    menulabel2.setFont(new Font("Dialog", Font.BOLD, 20));

    menulabel2.setHorizontalAlignment(SwingConstants.CENTER);



    //new time menu for the time selection mode

    JLabel home = new JLabel("Home");
    home.setFont(new Font("Dialog", Font.BOLD, 20));


    home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    home.setForeground(commonconstant.TEXT_COLOR);
    home.setBounds(670, 91, 100,25);


    home.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            ContactUs.this.dispose();
            new home().setVisible(true);
        }
    });

    //reserved space for database


    JLabel about= new JLabel("About Us");
    about.setFont(new Font("Dialog", Font.BOLD, 20));

    about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    about.setForeground(commonconstant.TEXT_COLOR);
    //set mouse listener
    about.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            ContactUs.this.dispose();
            new About().setVisible(true);
        }

    });

    about.setBounds(755, 91, 160,25);

    JLabel ContactUs= new JLabel("Contact Us");
    ContactUs.setFont(new Font("Dialog", Font.BOLD, 20));

    ContactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    ContactUs.setForeground(commonconstant.TEXT_COLOR);
    //set mouse listener
    ContactUs.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            ContactUs.this.dispose();
            new ContactUs().setVisible(true);

        }
    });

    ContactUs.setBounds(860, 91, 200,25);


    JButton signin= new JButton("Logout");
    signin.setFont(new Font("Dialog", Font.BOLD, 18));

    signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    signin.setForeground(commonconstant.SECONDARY_COLOR);
    signin.setBackground(commonconstant.HOME_BG1_BLUE);
    signin.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            ContactUs.this.dispose();
            new loginpage().setVisible(true);
        }
    });

    signin.setBounds(1000, 81, 150,42);

    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());

    JLabel panelLabel = new JLabel();
    panel1.add(panelLabel, BorderLayout.CENTER);
    panel1.setBounds(0, 0, 1300, 150);

    add(panel1);
    add(menulabel);
    add(menulabel2);
    add(signin);
    add(about);
    add(home);
    add(ContactUs);


    JPanel BGlightblue = new JPanel(null);
    BGlightblue.setBounds(100,190,1000,550);
    BGlightblue.setBackground(commonconstant.HOME_BG1_GRAY);

    ImageIcon bgBlue = new ImageIcon ("appoinment/src/image/BGlikodIMG.jpg");
    JLabel bgBluePic = new JLabel(bgBlue);
    bgBluePic.setBounds(0, 165, 1300, 650);


    ImageIcon telephonePic = new ImageIcon("appoinment/src/image/telephoneImgSmall.png");
    JLabel telImgSmall = new JLabel(telephonePic);
    telImgSmall.setBounds(5,55, 30, 25);


    JLabel txttelNum = new JLabel("TEL. NO.");
    txttelNum.setForeground(commonconstant.SECONDARY_COLOR);
    txttelNum.setFont(new Font("Dialog", Font.BOLD, 23));
    txttelNum.setBounds(40,45, 200, 50);

    JLabel telNum = new JLabel("<html><u> 0234-567-890</u></html>");
    telNum.setForeground(commonconstant.TEXT_COLOR);
    telNum.setFont(new Font("Dialog", Font.BOLD, 17));
    telNum.setBounds(15,75, 300, 50);


    ImageIcon gmailPicSmall  = new ImageIcon("appoinment/src/image/gmaiLogoSmall.png");
    JLabel gmailImg = new JLabel(gmailPicSmall);
    gmailImg.setBounds(170,55, 30, 25);

    JLabel txtEmail = new JLabel("E-MAIL:");
    txtEmail.setForeground(commonconstant.SECONDARY_COLOR);
    txtEmail.setFont(new Font("Dialog", Font.BOLD, 23));
    txtEmail.setBounds(205,45, 300, 50);

    JLabel email = new JLabel("<html><u> MedCare.cebu.ph@gmail.com</u></html>");
    email.setFont(new Font("Dialog", Font.BOLD, 17));
    email.setForeground(commonconstant.TEXT_COLOR);
    email.setBounds(180,75, 300, 50);


    add(BGlightblue);
    add(bgBluePic);

}
}
