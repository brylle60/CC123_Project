package gui;

import adminpage.AdminPageController;
import adminpage.ScheduleTable;
import db.userDb;

import javax.swing.*;

public class launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //new calendar().setVisible(true);
//new AppointmentScheduler().setVisible(true);
//               new register().setVisible(true);
//                new Appoinment().setVisible(true);
//new Features().setVisible(true);
          // new home().setVisible(true);
//                new loginpage().setVisible(true);
//new menu().setVisible(true);
            //new typeAppointment().setVisible(true);
                new ScheduleTable().setVisible(true);




               //new loginpage().setVisible(true);
                //new Appoinment().setVisible(true);
                //new AdminPageController().setVisible(true);
//new Features().setVisible(true);

//new home().setVisible(true);


           new home().setVisible(true);

               new register().setVisible(true);
                //new Appoinment().setVisible(true);
//new Features().setVisible(true);
            //new home().setVisible(true);

              // System.out.println(MyJDBC.checkuser("username1234"));
               //System.out.println(MyJDBC.register("username1234", "password"));
               // System.out.println(MyJDBC.validatelogin("username1234", "password"));
               //System.out.println(userDb.checkuser(Integer.parseInt("1234")));
              // System.out.println(userDb.validateuser(Integer.parseInt("123"), "admin", "admin","admin", "4:20:30"));
                //System.out.println(userDb.menu(Integer.parseInt("123"), "admin", "admin","admin", "4:20:30"));

            }
        });
    }
}