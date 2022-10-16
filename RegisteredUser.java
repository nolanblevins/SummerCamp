import java.util.ArrayList;

public class RegisteredUser extends User{
    protected ArrayList<Child> children;
    
    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
    }


    
    
}
