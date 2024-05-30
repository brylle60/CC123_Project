package doctors;

import constant.commonconstant;
import javax.swing.*;

public class doctors extends JFrame {
    public doctors (String title) {
        //The main gui panel
        super(title);
        setSize(1250, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);



        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(commonconstant.BUTTON_COLOR);

    }
}
