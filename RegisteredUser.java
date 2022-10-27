import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RegisteredUser extends User{
    protected ArrayList<Child> children;
    protected UUID id;
    
    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.userType = UserType.REGISTERED_USER;
    }

    public RegisteredUser(String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.id = UUID.randomUUID();
        this.userType = UserType.REGISTERED_USER;
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
        this.userType = UserType.REGISTERED_USER;
    }

    public RegisteredUser(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
                          ArrayList<Child> children) {
        super(firstName, lastName, email, phoneNumber, password);
        this.children = children;
        this.id = id;
        this.userType = UserType.REGISTERED_USER;
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
        while(userPass != this.password) {
            System.out.println("Password is incorrect");
            System.out.println("Enter password:");
            userPass = in.nextLine();
        }
        boolean next = true;
        while(next) {
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
        else {
            System.out.println("Invalid input, enter again");
            continue;
        }
        System.out.println("Would you like to change any other information? (y/n)");
        String answer = in.nextLine();
        if(answer.equalsIgnoreCase("y"))
            continue;
        else
            next = false;
    }
        
    }

    public String getSchedule(int cabin, ArrayList<Activity> activity, WeekDay day) {
        ArrayList<Schedule> schedule = new ArrayList<>();
        Schedule sc = new Schedule(activity, day);
        schedule = sc.generateSchedule();
        for(int i = 0; i < schedule.size(); i++) {
            
        }
        return null;
        //return Group.getSchedule();
    }

    public void registerChild(String firstName, String lastName, Date birthday, String medicalInfo, Camp camp) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter child's first name:");
        String fName = in.nextLine();
        System.out.println("Enter child's last name:");
        String lName = in.nextLine();
        System.out.println("Enter child's birthday (MM/DD/YYYY):");
        Date bday = null;
        boolean next = true;
        while(next) {
            try {
            bday = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
            next = false;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Incorrect format or date");
            }
        }
        ArrayList<Contact> emergencyContact = new ArrayList<Contact>();
        boolean yes = true;
        while(yes) {
        System.out.println("Would you like to add an emergency contact? (y/n)");
        String answer = in.nextLine();
        if(answer.equalsIgnoreCase("y"))
        {
        System.out.println("Enter child's emergency contact first name:");
        String eFirstName = in.nextLine();
        System.out.println("Enter child's emergency contact last name:");
        String eLastName = in.nextLine();
        System.out.println("Enter child's emergency contact phone number (XXX-XXX-XXXX):");
        String ePhoneNumber = in.nextLine();
        System.out.println("Enter child's emergency contact relationship:");
        String eRelationship = in.nextLine();
        Contact childContact = new Contact(eFirstName, eLastName, ePhoneNumber, eRelationship);
        emergencyContact.add(childContact);
        }
        else if(answer.equalsIgnoreCase("n"))
            yes = false;
        else
            System.out.println("Invalid response, try again");
        }

        System.out.println("Enter child's address:");
        String address = in.nextLine();
        boolean add = true;
        ArrayList<String> allergies = new ArrayList<String>();
        while(add) {
        System.out.println("Add allergies for child, once done enter 'done'");
        String allergy = in.nextLine();
        if(allergy.equalsIgnoreCase("done"))
            add = false;
        else
            allergies.add(allergy);
        }

        add = true;
        ArrayList<String> conditions = new ArrayList<String>();
        while(add) {
        System.out.println("Add allergies for child, once done enter 'done'");
        String condition = in.nextLine();
        if(condition.equalsIgnoreCase("done"))
            add = false;
        else
            conditions.add(condition);
        }

        MedicalInfo mInfo = new MedicalInfo(emergencyContact, address, allergies, conditions);

        System.out.println("Enter what camp child will be in:");
        //TODO enter what camps are available

        Child newChild = new Child(fName, lName, mInfo, bday);
        ChildList childList = ChildList.getInstance();
        //TODO make add child
        //ChildList.addChild(newChild);
    }

    public void removeChild(String firstName, String lastName) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter child's first name:");
        String fName = in.nextLine();
        System.out.println("Enter child's last name:");
        String lName = in.nextLine();
        //children.remove(firstName,lastName);
    }

    public String viewChildNotes(String firstName, String lastName) {
        return "child's notes";
    }

    public void cancelRegistration(Child child) {

    }

    public UUID getID(){
        return this.id;
    }

    public ArrayList<Child> getChildren(){
        return this.children;
    }
    public String toString() {
        return "RegisteredUser [children=" + children + ", id=" + id + "]";
    }

}
