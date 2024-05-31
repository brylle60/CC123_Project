package doctors;

import java.time.LocalDate;

public class doctorConstructor {
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialization;
    private String sex;
    private String address;
    private long contactNumber;
    private int age;
    private String email;
    private String password;
    private LocalDate birthdate;
    // Default constructor

    public doctorConstructor() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
        this.specialization = "";
        this.birthdate = LocalDate.parse("");
    }

    // Parameterized constructor
    public doctorConstructor(String lastName, String firstName, String middleName, String specialization, String sex, long contactNumber, int age, String password, String email, LocalDate birthdate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.specialization = specialization;
        this.sex = sex;
        this.address = address;
        this.contactNumber = contactNumber;
        this.age = age;
        this.email= email;
        this.password = password;
        this.birthdate= birthdate ;
    }

    // Getters and setters


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getEmail() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  String getPassword(){return  password;}

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {

        this.birthdate= birthdate;
    }
}
