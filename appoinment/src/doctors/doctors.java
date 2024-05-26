package doctors;

import constant.TimeSlotManager;
import constant.commonconstant;
import javax.swing.*;

public class doctors extends JFrame {
    public doctors (String title) {
        //The main gui panel
        super(title);
        setSize(1250, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        TimeSlotManager.saveBookedTimeSlots();


        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BUTTON_COLOR);

    }
}
