import java.util.ArrayList;
import java.util.UUID;
import java.util.*;

public class RegisteredUser extends User{
    protected ArrayList<Child> children;
    protected UUID id;
    
    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = UUID.randomUUID();
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
    }

    public void changeInfo(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter email:"
        
                            



        
        
        );
        String infoChange = in.nextLine();
        


    }

    public ArrayList<Activity> viewSchedule(Child child) {
        return null;
    }

    public void registerChild(String firstName, String lastName, int age, String medicalInfo, Camp camp) {

    }

    public void removeChild(String firstName, String lastName) {

    }

    public ArrayList<String> viewChildNotes(String firstName, String lastName) {
        return null;
    }

    public void cancelRegistration(Child child) {
        
    }







    
    
}
