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


}
