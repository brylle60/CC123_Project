package gui;

import adminpage.AdminHome;
import constant.commonconstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class GuestPage extends GuestPageExtends {
    private JComboBox<String> combox;

    public GuestPage() {
        super("Medcare Guest Page");
        addGuiComponents();

    }

    private void addGuiComponents() {

        ImageIcon logoIcon = new ImageIcon("appoinment/src/image/logo.png"); // Replace "path_to_your_logo_image_file.jpg" with the actual path to your image file
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(35, -35, 300, 300); // Adjust the position and size as needed
        add(logoLabel);


        //Our Service
        JLabel Ours = new JLabel("M E D C A R E  S E R V I C E S ");
        Ours.setBounds(500, 30, 830, 80);
        Ours.setForeground(new Color(255,255,255));
        Ours.setFont(new Font("Georgia",Font.BOLD, 50));
        add(Ours);


        //OG label
        JLabel ObygynLabel = new JLabel("Obstetrics and Gynaecology");
        ObygynLabel.setBounds(565, 160, 400, 40);
        ObygynLabel.setForeground(commonconstant.SECONDARY_COLOR);
        ObygynLabel.setFont(new Font("Georgia",Font.BOLD, 20));
        add(ObygynLabel);

        //OG description
        JLabel ogDescription = new JLabel("Our team provides personalized care to ");
        ogDescription.setBounds(400, 200, 600, 40);
        ogDescription.setForeground(commonconstant.SECONDARY_COLOR);
        ogDescription.setFont(new Font("Calibre", Font.ITALIC, 15));
        ogDescription.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel ogDescription1 = new JLabel("women throughout all stages of their lives");
        ogDescription1.setBounds(400, 230, 600, 40);
        ogDescription1.setForeground(commonconstant.SECONDARY_COLOR);
        ogDescription1.setFont(new Font("Calibre", Font.ITALIC, 15));
        ogDescription1.setHorizontalAlignment(SwingConstants.CENTER);
        add(ogDescription);
        add(ogDescription1);

        JLabel OGdoc = new JLabel("-Dr. Sherilyn Sanchez");
        OGdoc.setBounds(465, 290, 600, 40);
        OGdoc.setForeground(commonconstant.SECONDARY_COLOR);
        OGdoc.setFont(new Font("Calibre", Font.PLAIN, 15));
        OGdoc.setHorizontalAlignment(SwingConstants.CENTER);
        add(OGdoc);

        //Obgyn logo
        ImageIcon Obgyn = new ImageIcon("appoinment/src/image/02Obygn.png");
        JLabel OG = new JLabel(Obgyn);
        OG.setBounds(395, 135, 180, 180);
        add(OG);



        //Pedia Label
        JLabel PediaLabel = new JLabel("Pediatrics");
        PediaLabel.setBounds(1115, 160, 400, 40);
        PediaLabel.setForeground(commonconstant.SECONDARY_COLOR);
        PediaLabel.setFont(new Font("Georgia",Font.BOLD, 23));
        add(PediaLabel);

        //Pedia description
        JLabel pediaDescription = new JLabel("We ensure your child receives comprehensive ");
        pediaDescription.setBounds(880, 200, 600, 40);
        pediaDescription.setForeground(commonconstant.SECONDARY_COLOR);
        pediaDescription.setFont(new Font("Calibre", Font.ITALIC, 15));
        pediaDescription.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel pediaDescription1 = new JLabel("care, fostering their development");
        pediaDescription1.setBounds(900, 230, 600, 40);
        pediaDescription1.setForeground(commonconstant.SECONDARY_COLOR);
        pediaDescription1.setFont(new Font("Calibre", Font.ITALIC, 15));
        pediaDescription1.setHorizontalAlignment(SwingConstants.CENTER);
        add(pediaDescription);
        add(pediaDescription1);

        JLabel Pediadoc = new JLabel("-Dr. Chelsie Faith Maranga");
        Pediadoc.setBounds(920, 290, 600, 40);
        Pediadoc.setForeground(commonconstant.SECONDARY_COLOR);
        Pediadoc.setFont(new Font("Calibre", Font.PLAIN, 15));
        Pediadoc.setHorizontalAlignment(SwingConstants.CENTER);
        add(Pediadoc);

        //Pedia logo
        ImageIcon Pediatrics = new ImageIcon("appoinment/src/image/03pedia.png");
        JLabel Pedia = new JLabel(Pediatrics);
        Pedia.setBounds(875, 170, 180, 180);
        add(Pedia);



        //Ophthal label
        JLabel OphthalLabel = new JLabel("Ophthalmology");
        OphthalLabel.setBounds(620, 395, 400, 40);
        OphthalLabel.setForeground(commonconstant.SECONDARY_COLOR);
        OphthalLabel.setFont(new Font("Georgia",Font.BOLD, 23));
        add(OphthalLabel);

        //Ophthal description
        JLabel ophDescription = new JLabel("We offers advanced diagnostic and ");
        ophDescription.setBounds(415, 450, 600, 40);
        ophDescription.setForeground(commonconstant.SECONDARY_COLOR);
        ophDescription.setFont(new Font("Calibre", Font.ITALIC, 15));
        ophDescription.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel ophDescription1 = new JLabel("treatment solutions, restoring vision clarity");
        ophDescription1.setBounds(415, 470, 600, 40);
        ophDescription1.setForeground(commonconstant.SECONDARY_COLOR);
        ophDescription1.setFont(new Font("Calibre", Font.ITALIC, 15));
        ophDescription1.setHorizontalAlignment(SwingConstants.CENTER);
        add(ophDescription);
        add(ophDescription1);

        JLabel Ophdoc = new JLabel("-Dr. Khen Lloyd Baylon");
        Ophdoc.setBounds(450, 505, 600, 40);
        Ophdoc.setForeground(commonconstant.SECONDARY_COLOR);
        Ophdoc.setFont(new Font("Calibre", Font.PLAIN, 15));
        Ophdoc.setHorizontalAlignment(SwingConstants.CENTER);
        add(Ophdoc);

        //Ophthal logo
        ImageIcon Ophthalmology = new ImageIcon("appoinment/src/image/04ophthal.png");
        JLabel Ophthal = new JLabel(Ophthalmology);
        Ophthal.setBounds(400, 385,180,180);
        add(Ophthal);


        //Fam Med Label
        JLabel FamMedLabel = new JLabel("Family Medicine");
        FamMedLabel.setBounds(1100, 390, 400, 40);
        FamMedLabel.setForeground(commonconstant.SECONDARY_COLOR);
        FamMedLabel.setFont(new Font("Georgia", Font.BOLD, 23));
        add(FamMedLabel);

        //Fam Med description
        JLabel famDescription = new JLabel("Our practitioners value the well-being for ");
        famDescription.setBounds(880, 440, 600, 40);
        famDescription.setForeground(commonconstant.SECONDARY_COLOR);
        famDescription.setFont(new Font("Calibre", Font.ITALIC, 15));
        famDescription.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel famDescription1 = new JLabel("every member of your family");
        famDescription1.setBounds(900, 460, 600, 40);
        famDescription1.setForeground(commonconstant.SECONDARY_COLOR);
        famDescription1.setFont(new Font("Calibre", Font.ITALIC, 15));
        famDescription1.setHorizontalAlignment(SwingConstants.CENTER);
        add(famDescription);
        add(famDescription1);

        JLabel Famdoc = new JLabel("-Dr. John Brylle Crodua");
        Famdoc.setBounds(920, 510, 600, 40);
        Famdoc.setForeground(commonconstant.SECONDARY_COLOR);
        Famdoc.setFont(new Font("Calibre", Font.PLAIN, 15));
        Famdoc.setHorizontalAlignment(SwingConstants.CENTER);
        add(Famdoc);

        //Fam Med logo
        ImageIcon FamMed = new ImageIcon("appoinment/src/image/01FamMed.png");
        JLabel Family = new JLabel(FamMed);
        Family.setBounds(890, 400, 180, 180);
        add(Family);

        //nothing button
        JButton nothing= new JButton("");
        nothing.setBounds(-1000000, -129380, 0, 0);
        nothing.setForeground(new Color(0,0,0,0));
        nothing.setBackground(new Color(0,0,0,0));
        nothing.setFont(new Font("Dialog", Font.BOLD, 0));

        nothing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //set mouse listener
        nothing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }
        });
        add(nothing);

        //Consult BUTTON
        JButton Consult = new JButton("LOG-IN");
        Consult.setFont(new Font("Dialog", Font.BOLD, 20));
        Consult.setBounds(1000, 620, 280, 60);
        Consult.setBackground(commonconstant.TEAL_REGISTER);
        Consult.setForeground(commonconstant.SECONDARY_COLOR);

        Consult.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Consult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                GuestPage.this.dispose();

                new loginpage().setVisible(true);

            }
        });
        add(Consult);

        //Panel Transparent  Ob
        JPanel panelob = new JPanel();
        panelob.setLayout(new BorderLayout());
        JLabel panelLabelob = new JLabel();
        panelob.add(panelLabelob, BorderLayout.CENTER);
        panelob.setBackground(new Color(0, 0, 0, 80));
        panelob.setBounds(400, 145, 460, 200);
        panelob.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelob.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuestPage.this.dispose();

                new ObygnDescription().setVisible(true);
            }
        });
        add(panelob);

        //Panel Transparent pedia
        JPanel panelpedia = new JPanel();
        panelpedia.setLayout(new BorderLayout());
        JLabel panelLabelpedia = new JLabel();
        panelpedia.add(panelLabelpedia, BorderLayout.CENTER);
        panelpedia.setBackground(new Color(0, 0, 0, 80));
        panelpedia.setBounds(880, 145, 460, 200);
        panelpedia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelpedia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuestPage.this.dispose();

                new PediatresDescription().setVisible(true);
            }
        });
        add(panelpedia);

        //Panel Transparent  Ophthalmology
        JPanel Ophthalmology1 = new JPanel();
        Ophthalmology1.setLayout(new BorderLayout());
        JLabel panelLabelop = new JLabel();
        Ophthalmology1.add(panelLabelop, BorderLayout.CENTER);
        Ophthalmology1.setBackground(new Color(0, 0, 0, 80));
        Ophthalmology1.setBounds(400, 375, 460, 200);
        Ophthalmology1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Ophthalmology1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuestPage.this.dispose();

                new OphthalmologyDescription().setVisible(true);
            }
        });
        add(Ophthalmology1);

        //Panel Transparent familymedicine
        JPanel panelfammed = new JPanel();
        panelfammed.setLayout(new BorderLayout());
        JLabel panelLabelfammed1 = new JLabel();
        panelfammed.add(panelLabelfammed1, BorderLayout.CENTER);
        panelfammed.setBackground(new Color(0, 0, 0, 80));
        panelfammed.setBounds(880, 375, 460, 200);
        panelfammed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelfammed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuestPage.this.dispose();

                new MedFamDescription().setVisible(true);
            }
        });
        add(panelfammed);


        //Panel Transparent white
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel panelLabel1 = new JLabel();
        panel1.add(panelLabel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(255, 255, 255, 120));
        panel1.setBounds(375, 0, 1000, 780);
        add(panel1);



        //blue background picture
        ImageIcon image = new ImageIcon("appoinment/src/image/hex4.png");
        JLabel image2 = new JLabel(image);
        image2.setBounds(375, 0, 1000, 780);
        add(image2); // right bg picture



        //MEDCARE Medical Appointment!
        JLabel description1label = new JLabel("Welcome to ");
        description1label.setBounds(30, 295, 400, 25);
        description1label.setForeground(commonconstant.DARKERBLUE_REG);
        description1label.setFont(new Font("Georgia",Font.PLAIN, 16));
        add(description1label);

        JLabel description1Alabel = new JLabel("MEDCARE");
        description1Alabel.setBounds(118, 295, 400, 25);
        description1Alabel.setForeground(commonconstant.DARKTEAL_REGISTER);
        description1Alabel.setFont(new Font("Georgia",Font.BOLD, 20));
        add(description1Alabel);

        JLabel description1Blabel = new JLabel("Medical Appointment!");
        description1Blabel.setBounds(118, 325, 400, 25);
        description1Blabel.setForeground(commonconstant.TEAL_REGISTER);
        description1Blabel.setFont(new Font("Times New Roman",Font.BOLD, 21));
        add(description1Blabel);

        //add description
        JLabel description2label = new JLabel("We are dedicated to revolutionizing ");
        description2label.setBounds(58, 400, 500, 25);
        description2label.setForeground(commonconstant.HOME_BG1_BLUE);
        description2label.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2label);

        JLabel description2Alabel = new JLabel("the way you manage your healthcare appointments. ");
        description2Alabel.setBounds(30, 425, 500, 25);
        description2Alabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Alabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Alabel);

        JLabel description2Blabel = new JLabel("Our platform is designed to provide seamless ");
        description2Blabel.setBounds(54, 450, 500, 25);
        description2Blabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Blabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Blabel);

        JLabel description2Clabel = new JLabel("scheduling, ensuring you can access ");
        description2Clabel.setBounds(43, 475, 500, 25);
        description2Clabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Clabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Clabel);

        JLabel description2Dlabel = new JLabel("medical care conveniently and efficiently.");
        description2Dlabel.setBounds(52, 500, 500, 25);
        description2Dlabel.setForeground(commonconstant.HOME_BG1_BLUE);
        description2Dlabel.setFont(new Font("Dialog",Font.PLAIN, 14));
        add(description2Dlabel);


        //abstract background picture
        ImageIcon imageA = new ImageIcon("appoinment/src/image/abstractreg.png");
        JLabel image3 = new JLabel(imageA);
        image3.setBounds(-50, 0, 700, 780); // Adjust the position and size as needed
        add(image3); // left bg picture

    }
}





