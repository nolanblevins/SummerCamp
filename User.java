public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected String password;
    protected UserType userType;

    /**
     * Constructs the user with all required parameters
     * 
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param email       The email of the user
     * @param phoneNumber The phone number of the user
     * @param password    The password of the user
     */
    public User(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
                + phoneNumber + ", password=" + password + "]";
    }

}
