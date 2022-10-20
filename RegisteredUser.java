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
        System.out.println("Enter email:");
        
        
        String infoChange = in.nextLine();
    }

    public String viewSchedule(int cabin) {
        return Group.getSchedule;
    }

    public void registerChild(String firstName, String lastName, int age, String medicalInfo, Camp camp) {
        children.add(firstName, lastName, age, medicalInfo, camp);
    }

    public void removeChild(String firstName, String lastName) {
        children.remove(firstName,lastName);
    }

    public String viewChildNotes(String firstName, String lastName) {
        return "child's notes";
    }

    public void cancelRegistration(Child child) {

    }

    public String toString() {
        return "RegisteredUser [children=" + children + ", id=" + id + "]";
    }
    
}
