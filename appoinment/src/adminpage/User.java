package adminpage;


import java.time.LocalDate;

public class User {
    private String last_name;
    private String first_name;
    private String middle_name;
    private  int age;
    private long number;
    private String email;
    private String password;
    private boolean isLoggedIn;
    private int id;
    private LocalDate birthdate;
    private String address;

    public User() {
        // Default constructor
        last_name ="";
        password = "";
        isLoggedIn = false;

    }

    public User(int id, String last_name, String first_name, String middle_name, int age, long number, String email, String password, String address, LocalDate birthdate, boolean isLoggedIn) {
       this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.age = age;
        this.number = number;
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String username) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}