package gui;
import constant.commonconstant;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.server.RemoteCall;
import javax.swing.*;

public class UserProfile extends homepage {
    public UserProfile(){
        super("User Profile");
        addUserProfile();
    }

    private void addUserProfile(){

        JPanel BGwhite = new JPanel(null);
        BGwhite.setBounds(0,0,1300,150);
        BGwhite.setBackground(commonconstant.HOME_BG1_GRAY);

        JPanel BGwhite2 = new JPanel(null);
        BGwhite2.setBounds(0,0,250,900);
        BGwhite2.setBackground(commonconstant.HOME_BG1_GRAY);

        ImageIcon bgBlue = new ImageIcon ("appoinment/src/image/BGuser.png");
        JLabel bgBluePic = new JLabel(bgBlue);
        bgBluePic.setBounds(-62, 150, 1300, 650);

//        add(BGwhite2);
        add(bgBluePic);
        add(BGwhite);


    }


}
