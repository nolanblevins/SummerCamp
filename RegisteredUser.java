import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RegisteredUser extends User {
    protected ArrayList<Child> children;

    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = new ArrayList<>();
    }

    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.userType = UserType.REGISTERED_USER;
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.REGISTERED_USER;
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.userType = UserType.REGISTERED_USER;
    }

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

    public Child removeChild(int input) {
        return children.remove(input - 1);
    }

    public String viewChildNotes(String firstName, String lastName) {
        return "child's notes";
    }

    public ArrayList<Child> getChildren() {
        return this.children;
    }

    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
                "Email: " + this.email + "\n" +
                "Phone Number: " + this.phoneNumber + "\n" +
                "Children: \n" + this.getChildrenStrings();
    }

    private String getChildrenStrings() {
        String childString = "";
        for (Child c : this.children) {
            childString += "\t" + c.toString() + "\n";
        }
        return childString;
    }

}
