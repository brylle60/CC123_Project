package gui;


import adminpage.AdminHome;
import adminpage.regDoctor;
import doctors.OphthalDocPage;
import doctors.DoctorTypeAppointment;
import doctors.DoctorpageComponents;
import doctors.OPHTHALMOLOGIST;
import doctors.doctorhomepage;


import javax.swing.*;

public class launcher {
    private static String loggedInLastName;
    private static String loggedInFirstName;
    private static String loggedInMiddleName;
    private static int id;
    private static int age;
    private static String sex;
    private static int number;
    private static String email;
    private static String address;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {


        @Override
            public void run() {
            new GuestPage().setVisible(true);

            }
        });
    }
}