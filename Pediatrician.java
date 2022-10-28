public class Pediatrician {

private String firstName;
private String lastName;
private String phoneNumber;
private String business;

public Pediatrician(String firstName, String lastName, String phoneNumber, String business) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.business = business;
}
public Pediatrician getPediatrician() {
    return this;
}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBusiness() {
        return business;
    }
}
