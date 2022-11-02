import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RegisteredUser extends User {
    protected ArrayList<Child> children;


       /**
     * This method is a constructor for RegisteredUser
     * 
     * @param firstName      Users First Name
     * @param lastName       Users Last Name
     * @param email          Users Email
     * @param phoneNumber    Users Phone Number
     * @param password       Users Password
        */

    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.REGISTERED_USER;
        this.children = new ArrayList<>();
    }

       /**
     * This method is a constructor for RegisteredUser including Children associated with the account
     * 
     * @param firstName      Users First Name
     * @param lastName       Users Last Name
     * @param email          Users Email
     * @param phoneNumber    Users Phone Number
     * @param password       Users Password
     * @param children
     */
    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.userType = UserType.REGISTERED_USER;
    }
       
        /**
     * This method is a constructor for RegisteredUser including UUID
     * @param id
     * @param firstName      Users First Name
     * @param lastName       Users Last Name
     * @param email          Users Email
     * @param phoneNumber    Users Phone Number
     * @param password       Users Password
     */
    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.REGISTERED_USER;
    }

        /**
     * This method is a constructor for RegisteredUser including UUID and Children associated with the account
     * @param id
     * @param firstName      Users First Name
     * @param lastName       Users Last Name
     * @param email          Users Email
     * @param phoneNumber    Users Phone Number
     * @param password       Users Password
     * @param children
     */
    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.userType = UserType.REGISTERED_USER;
    }

        /**
     * Allow user to change their info
     * @param username      Username
        */
    public void changeInfo(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter email:");
        String userEmail = in.nextLine();
        while (userEmail != this.email) {
            System.out.println("Email is incorrect");
            System.out.println("Enter email:");
            userEmail = in.nextLine();
        }
        System.out.println("Enter password:");
        String userPass = in.nextLine();
        while (userPass != this.password) {
            System.out.println("Password is incorrect");
            System.out.println("Enter password:");
            userPass = in.nextLine();
        }
        boolean next = true;
        while (next) {
            System.out.println("What information would you like to change?" +
                    "\n" + "\t" + "First Name(0)" +
                    "\n" + "\t" + "Last Name(1)" +
                    "\n" + "\t" + "Email(2)" +
                    "\n" + "\t" + "Username(3)" +
                    "\n" + "\t" + "Password(4)");
            int userChoice = in.nextInt();
            ;
            if (userChoice == 0) {
                System.out.println("Enter new first name:");
                String newFirstName = in.nextLine();
                new RegisteredUser(newFirstName, lastName, email, username, password);
            } else if (userChoice == 1) {
                System.out.println("Enter new last name:");
                String newLastName = in.nextLine();
                new RegisteredUser(firstName, newLastName, email, username, password);
            } else if (userChoice == 2) {
                System.out.println("Enter new email:");
                String newEmail = in.nextLine();
                new RegisteredUser(firstName, lastName, newEmail, username, password);
            } else if (userChoice == 3) {
                System.out.println("Enter new username:");
                String newUsername = in.nextLine();
                new RegisteredUser(firstName, lastName, email, newUsername, password);
            } else if (userChoice == 4) {
                System.out.println("Enter new password:");
                String newPassword = in.nextLine();
                new RegisteredUser(firstName, lastName, email, username, newPassword);
            } else {
                System.out.println("Invalid input, enter again");
                continue;
            }
            System.out.println("Would you like to change any other information? (y/n)");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("y"))
                continue;
            else
                next = false;
        }

    }
       /**
     * Accessor for Schedule for a weekday
     * 
     * @param cabin         cabin number
     * @param activity      activity during the day
     * @param day           day of the week
        */

    public String getSchedule(int cabin, ArrayList<Activity> activity, WeekDay day) {
        ArrayList<Schedule> schedule = new ArrayList<>();
        Schedule sc = new Schedule(activity, day);
        schedule = sc.generateSchedule();
        for (int i = 0; i < schedule.size(); i++) {

        }
        return null;
        //return Group.getSchedule();
    }

    // TODO Move the prints to the UI
    public void registerChild(Child child) {
        children.add(child);
    }
       /**
     * Remove Child from Users Account
     * 
     * @param input      users input to choose which child to delete
        */

    public Child removeChild(int input) {
        return children.remove(input - 1);
    }
       /**
     * Allow users to view child note
     * 
     * @param firstName      Users First Name
     * @return "child's note"
        */

    public String viewChildNotes(String firstName, String lastName) {
        return "child's notes";
    }
       /**
     * Accessor for Children
     * @return Child associated with User
        */

    public ArrayList<Child> getChildren() {
        return this.children;
    }
    
        /**
     * Returns Account Information and Child info
     * 
     * @return String       summarized of users and child Info
        */

    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
                "Email: " + this.email + "\n" +
                "Phone Number: " + this.phoneNumber + "\n" +
                "Children: \n" + this.getChildrenStrings();
    }

        /**
     * Return all Child Info
     * 
     * @return childString      : child's Information
        */

    private String getChildrenStrings() {
        String childString = "";
        for (Child c : this.children) {
            childString += "\t" + c.toString() + "\n";
        }
        return childString;
    }

}
