package doctors;

import constant.commonconstant;

import javax.swing.*;
import java.awt.*;

public class doctorhomepage extends doctors{
    public doctorhomepage(String title) {
        super("Health Apoointment");
        addDoctorComponents();

    }

    private void addDoctorComponents() {


        JLabel text = new JLabel("We're bridging the gap between Doctors and Patients");
        text.setBounds(16, 80, 600, 400);
        text.setForeground(commonconstant.TEXT_COLOR.brighter());
        text.setFont(new Font("Dialog", Font.BOLD, 60));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel text1 = new JLabel("You'll never miss another Doctor's appointment!");
        text1.setBounds(16, 80, 600, 400);
        text1.setForeground(commonconstant.TEXT_COLOR.brighter());
        text1.setFont(new Font("Dialog", Font.BOLD, 60));
        text1.setHorizontalAlignment(SwingConstants.CENTER);

        add(text);
        add(text1);

        JPanel doctorpanel1 = new JPanel();
        doctorpanel1.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel1.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel1.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel1);

        JPanel doctorpanel2 = new JPanel();
        doctorpanel2.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel2.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel2.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel2);

        JPanel doctorpanel3 = new JPanel();
        doctorpanel3.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel3.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel3.setBackground(new Color(1, 122, 194, 100));
        add(doctorpanel3);

        JPanel doctorpanel4 = new JPanel();
        doctorpanel4.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel4.setBounds(670, 165, 520, 170); // Set the bounds of the panel
        doctorpanel4.setBackground(new Color(1, 122, 194, 100));

        add(doctorpanel1);
        add(doctorpanel2);
        add(doctorpanel3);
        add(doctorpanel4);
    }
}
