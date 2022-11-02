import java.util.UUID;

public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected String password;
    protected UserType userType;
    protected UUID uuid;

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
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * Constructs the user with all parameters including UUID
     * 
     * @param uuid        The UUID of the user
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param email       The email of the user
     * @param phoneNumber The phone number of the user
     * @param password    The password of the user
     */
    public User(UUID uuid, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * This method returns all of the parameters for user in the form of a
     * string
     * 
     * @return a concatenate string of the user properties
     */
    public String toString() {
        String ret = "Name: " + firstName + " " + lastName;
        ret += "\n\t\tEmail: " + email;
        ret += "\n\t\tPhone Number: " + phoneNumber;
        ret += "\n\t\tPassword: " + password;
        return ret;
    }

    /**
     * Accessor for email
     * 
     * @return email for user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Accessor for firstName
     * 
     * @return firstName for user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor for lastName
     * 
     * @return lastName for user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accessor for phoneNumber
     * 
     * @return phoneNumber for user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Accessor for password
     * 
     * @return password for user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Accessor for userType
     * 
     * @return userType for user
     */
    public UserType getUserType() {
        return this.userType;
    }

    /**
     * Accessor for UUID
     * 
     * @return UUID for user
     */
    public UUID getID() {
        return this.uuid;
    }

    /**
     * This method makes sure that each parameter is not null and fills it in with
     * the right variable
     * 
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param email       The email of the user
     * @param phoneNumber The phone number of the user
     * @param password    The password of the user
     */
    public void changeInfo(String firstName, String lastName, String phoneNumber,
            String email, String password) {
        if (firstName != null) {
            this.firstName = firstName;
        }
        if (lastName != null) {
            this.lastName = lastName;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
        if (email != null) {
            this.email = email;
        }
        if (password != null) {
            this.password = password;
        }
    }

}