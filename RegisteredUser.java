import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class RegisteredUser extends User{
    protected ArrayList<Child> children;
    protected UUID id;
    
    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.id = UUID.randomUUID();
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.id = id;
    }

    public void changeInfo(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter email:");
        String userEmail = in.nextLine();
        while(userEmail != this.email) {
           System.out.println("Email is incorrect");
           System.out.println("Enter email:");
           userEmail = in.nextLine();
        }
        System.out.println("Enter password:");
        String userPass = in.nextLine();
        if(userPass != this.password) {
            System.out.println("Password is incorrect");
            System.out.println("Enter password:");
            userPass = in.nextLine();
        }

        System.out.println("What information would you like to change?"+
                            "\n"+"\t"+"First Name(0)"+
                            "\n"+"\t"+"Last Name(1)"+
                            "\n"+"\t"+"Email(2)"+
                            "\n"+"\t"+"Username(3)"+
                            "\n"+"\t"+"Password(4)");
        int userChoice = in.nextInt();;
        if(userChoice == 0) {
            System.out.println("Enter new first name:");
            String newFirstName = in.nextLine();
            new RegisteredUser(newFirstName, lastName, email, username, password);
        }
        else if(userChoice == 1) {
            System.out.println("Enter new last name:");
            String newLastName = in.nextLine();
            new RegisteredUser(firstName, newLastName, email, username, password);
        }
        else if(userChoice == 2) {
            System.out.println("Enter new email:");
            String newEmail = in.nextLine();
            new RegisteredUser(firstName, lastName, newEmail, username, password);
        }
        else if(userChoice == 3) {
            System.out.println("Enter new username:");
            String newUsername = in.nextLine();
            new RegisteredUser(firstName, lastName, email, newUsername, password);
        }
        else if(userChoice == 4) {
            System.out.println("Enter new password:");
            String newPassword = in.nextLine();
            new RegisteredUser(firstName, lastName, email, username, newPassword);
        }
        
    }

    public String viewSchedule(int cabin) {
        return null;
        //return Group.getSchedule();
    }

    public void registerChild(String firstName, String lastName, Date birthday, String medicalInfo, Camp camp) {
        // prompt for information
        // Create child
        // Add child
        //children.add(firstName, lastName, birthday, medicalInfo, camp);
    }

    public void removeChild(String firstName, String lastName) {
        // prompt child's name
        //children.remove(firstName,lastName);
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
