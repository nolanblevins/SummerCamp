/*
 * This class creates the Pediatrician object
 */
public class Pediatrician {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String business;

    /**
     * Constructor for the Pediatrician
     * 
     * @param firstName   is the first name of the pediatrician
     * @param lastName    is the last name of the pediatrician
     * @param phoneNumber is the phone number of the pediatrician
     * @param business    is the business of the pediatrician
     */
    public Pediatrician(String firstName, String lastName, String phoneNumber, String business) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.business = business;
    }

    /**
     * Accessor for pediatrician
     * 
     * @return instance of a pediatrician
     */
    public Pediatrician getPediatrician() {
        return this;
    }

    /**
     * Accessor for first name
     * 
     * @return first name of pediatrician
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor for last name
     * 
     * @return last name of pediatrician
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accessor for phone number
     * 
     * @return phone number of pediatrician
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Accessor for business
     * 
     * @return business of pediatrician
     */
    public String getBusiness() {
        return business;
    }

    /**
     * This method returns all of the parameters for pediatrician in the form of a
     * string
     * 
     * @return a concatenate string of the pediatrician properties
     */
    public String toString() {
        String ret = "Pediatrician: ";
        ret += "\n\tName: " + firstName + " " + lastName;
        ret += "\n\tBusiness: " + business;
        ret += "\n\tPhone Number: " + phoneNumber;
        return ret;
    }
}
