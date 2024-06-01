package gui;


import adminpage.AdminHome;
import adminpage.regDoctor;
import doctors.DoctorHomePage;
import doctors.DoctorTypeAppointment;
import doctors.DoctorpageComponents;
import doctors.OPHTHALMOLOGIST;



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
    private static String specialization;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {


        @Override
            public void run() {
//            new DoctorHomePage(loggedInLastName,loggedInFirstName, loggedInMiddleName, sex, age, number, specialization).setVisible(true);
            new GuestPage().setVisible(true);

            }
        });
    }
}