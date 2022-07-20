package africa.semicolon.contact_management.data.models;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact:" +
                "\nId: " + id +
                "\nFirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nPhoneNumber: " + phoneNumber +
                "\nEmail: " + email ;


    }
}
