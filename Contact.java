public class Contact {

private String firstName;
private String lastName;
private String phoneNumber;
private String relationship;

public Contact(String firstName, String lastName, String phoneNumber, String relationship) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.relationship = relationship;
}

public Contact getContact() {
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

    public String getRelationship() {
        return relationship;
    }

    public String toString(){
        String ret = "Emergency Contact: ";
        ret += "\n\tName: " + firstName + " " + lastName;
        ret += "\n\tRelationship: " + relationship;
        ret += "\n\tPhone Number: " + phoneNumber;
        return ret;
    }
}
