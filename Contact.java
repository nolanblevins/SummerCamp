/*
 * This class creates the Contact object
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String relationship;

    /**
     * Constructor for the Contact
     * 
     * @param firstName   is the first name of the contact
     * @param lastName    is the last name of the conatact
     * @param phoneNumber is the phone number of the contact
     * @param business    is the business of the contact
     */
    public Contact(String firstName, String lastName, String phoneNumber, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
    }

    /**
     * Accessor for contact
     * 
     * @return instance of a contact
     */
    public Contact getContact() {
        return this;
    }

    /**
     * Accessor for first name
     * 
     * @return instance of a first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor for last name
     * 
     * @return instance of a last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accessor for phone number
     * 
     * @return instance of a phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Accessor for relationship
     * 
     * @return instance of a relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * This method returns all of the parameters for contact in the form of a
     * string
     * 
     * @return a concatenate string of the contact properties
     */
    public String toString() {
        String ret = "Emergency Contact: ";
        ret += "\n\t\tName: " + firstName + " " + lastName;
        ret += "\n\t\tRelationship: " + relationship;
        ret += "\n\t\tPhone Number: " + phoneNumber;
        return ret;
    }
}
