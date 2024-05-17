package adminpage;

import java.time.LocalDate;
import java.time.LocalTime;

public class schedules {
    private int id;
    private String last_name;
    private String first_name;
    private String midlle_name;
    LocalTime time;
    LocalDate date;
    private String gender;
    private String adress;
    private int number;
    private String Appointmet;


    public schedules() {
        // Default constructor

        this.last_name = "";
        this.first_name = "";
        midlle_name = "";

    }

    public schedules(int id, String last_name, String first_name, String midlle_name, LocalTime time, LocalDate date, String gender, String adress, int number, String appointment) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.midlle_name = midlle_name;
        this.time = time;
        this.date = date;
        this.gender = gender;
        this.adress = adress;
        this.number = number;
        this.Appointmet = appointment;

    }

    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMidlle_name() {
        return midlle_name;
    }

    public void setMidlle_name(String midlle_name) {
        this.midlle_name = midlle_name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;

    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAppointmet() {
        return Appointmet;
    }

    public void setAppointmet(String appointmet) {
        Appointmet = appointmet;
    }
}



