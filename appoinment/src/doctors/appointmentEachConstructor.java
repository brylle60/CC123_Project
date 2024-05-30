package doctors;

public class appointmentEachConstructor {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialization;
    private String sex;
    private String address;
    private long contactNumber;
    private int age;
    private String email;
    private int birthdate;

    // Default constructor
    public appointmentEachConstructor() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
        this.specialization = "";
    }

    // Parameterized constructor
    public appointmentEachConstructor(int id, String lastName, String firstName, String middleName, String specialization, String gender, String address, long contactNumber, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.specialization = specialization;
        this.sex = sex;
        this.address = address;
        this.contactNumber = contactNumber;
        this.age = age;
        this.email= email;
        this.birthdate= birthdate ;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    public int getBirthdate(int birthdate) {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate= birthdate;
    }
}
