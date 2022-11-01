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

    public User(UUID uuid, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.uuid = uuid;
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

    public String getEmail() {
        return email;
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

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public UUID getID(){
        return this.uuid;
    }

    public void changeInfo(String firstName, String lastName, String phoneNumber,
                           String email, String password){
        if(firstName != null){
            this.firstName = firstName;
        }
        if(lastName != null){
            this.lastName = lastName;
        }
        if(phoneNumber != null){
            this.phoneNumber = phoneNumber;
        }
        if(email != null){
            this.email = email;
        }
        if(password != null){
            this.password = password;
        }
    }

}