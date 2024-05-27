package gui;


import doctors.DoctorTypeAppointment;


import javax.swing.*;

public class launcher {
    private static String loggedInLastName;
    private static String loggedInFirstName;
    private static String loggedInMiddleName;
    private static int id;
    private static int age;
    private static long number;
    private static String address;
    private static String sex;
    private static String email;

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //TimeSlotManager.loadBookedTimeSlots();




//                Appoinment appoinment = new Appoinment(loggedInLastName, loggedInFirstName, loggedInMiddleName);
//                appoinment.setVisible(true);
                //new UserProfile(id).setVisible(true);
                //new AdminHome().setVisible(true);


//new typeAppointment().setVisible(true);
                //new loginpage().setVisible(true);
//new AdminHome().setVisible(true);

              //new AppointmentList().setVisible(true);
              //  new loginpage().setVisible(true);
//new typeAppointment().setVisible(true);
  //  new home(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address ).setVisible(true);
//new HowToAppointment().setVisible(true);
             new DoctorTypeAppointment().setVisible(true);
              //  new ContactUs().setVisible(true);

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