package gui;


import adminpage.AdminHome;
import adminpage.ScheduleTable;
import adminpage.User;
import db.userDb;


import javax.swing.*;

public class launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


//new HowToAppointment().setVisible(true);
//new UserProfile().setVisible(true);
//                new ContactUs().setVisible(true);
//new About().setVisible(true);
//new loginpage().setVisible(true);
                new home().setVisible(true);

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