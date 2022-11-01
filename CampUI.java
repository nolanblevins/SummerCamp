import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;
import java.sql.Date;
import java.util.concurrent.TimeUnit;


public class CampUI {

    static CampSystemFacade campSystem = new CampSystemFacade(null, null, null);

    public static void main(String[] args) {

        //DataReader dataReader = new DataReader();

        loadingScreen();

        menuSelect();

        DataWriter.saveChildren();
    }

    private static void loadingScreen() {

        System.out.println("           (                 ,&&&.");
        System.out.println("            )                .,.&&");
        System.out.println("           (  (              \\=__/");
        System.out.println("               )             ,'-'.");
        System.out.println("         (    (  ,,      _.__|/ /|");
        System.out.println("          ) /\\ -((------((_|___/ |");
        System.out.println("        (  // | (`'      ((  `'--|");
        System.out.println("      _ -.;_/ \\\\--._      \\\\ \\-._/.");
        System.out.println("     (_;-// | \\ \\-'.\\    <_,\\_\\`--'|");
        System.out.println("     ( `.__ _  ___,')      <_,-'__,'");
        System.out.println("      `'(_ )_)(_)_)'");
        for (int i = 0; i < 100; i++) {
            System.out.print((i + 1) + "%");
            sleep(24);
            System.out.print("\b\b\b\b\b");
        }

        System.out.println("LOADED");
        sleep(224);
        clearScreen();
    }

    private static void menuSelect() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to GoofyGobbler Summercamp!\n\n************ Main Menu ************");
        String[] menuOptions = {"Create an account", "Login", "Information on our camp", "FAQ", "Exit"};
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }

        int menuSelection;

        boolean invalidInput = false;

        do {

            if (invalidInput) {
                System.out.println("Menu option not valid, choose again...");
            }

            menuSelection = keyboard.nextInt();
            keyboard.nextLine();

            if (menuSelection == 1) {
                createAccountMenu();
            } else if (menuSelection == 2) {
                loginPortal();

            } else if (menuSelection == 3) {
                campInfo();
            } else if (menuSelection == 4) {
                displayFAQ();
            } else if (menuSelection == 5) {
                break;
            } else {

            }


        } while (menuSelection > (menuOptions.length) || menuSelection < 1);

    }

    private static void createAccountMenu() {

        Scanner keyboard = new Scanner(System.in);

        boolean errorMessage = false;

        do {

            clearScreen();

            errorMessage = false;

            System.out.println("************ Account Registration ************\n");
            System.out.println("Please enter the following information: ");
            System.out.print("First name: ");
            String firstname = keyboard.nextLine();
            System.out.print("Last name: ");
            String lastname = keyboard.nextLine();
            System.out.print("Email: ");
            String emailInput = keyboard.nextLine();
            System.out.print("Phone number (###-###-####) : ");
            String phoneNumber = keyboard.nextLine();
            System.out.print("Password: ");
            String password = keyboard.nextLine();

            if (campSystem.isValidPassword(password) && campSystem.isEmailValid(emailInput) && campSystem.isPhoneValid(phoneNumber)) {
                errorMessage = true;
                campSystem.createAccount(firstname, lastname, phoneNumber, emailInput, password);
                System.out.println("You have succesfully created an account");
            }
            errorMessage = false;

        } while (errorMessage);

    }


    private static void loginPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        clearScreen();
        System.out.println("***** Log in *****");

        boolean validLoginOption = false;

        int loginChoice;

        do {

            System.out.println("1. Counselor login");
            System.out.println("2. Director login");
            System.out.println("3. Camper login");
            System.out.println("4. Go back to previous page");

            loginChoice = keyboard.nextInt();
            keyboard.nextLine();

            if (loginChoice > 4 || loginChoice < 1) {
                validLoginOption = false;
            } else {
                validLoginOption = true;
            }

        } while (!validLoginOption);

        clearScreen();
        String emailInput;
        String passwordInput;

        if (loginChoice == 1) {
            System.out.println("***** Counselor Login Portal *****");
            System.out.print("Email: ");
            emailInput = keyboard.nextLine();
            System.out.print("Password: ");
            passwordInput = keyboard.nextLine();

            if (!campSystem.loginCounselor(emailInput, passwordInput)) {
                clearScreen();
                System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
                sleep(2000);
                loginPortal();
            } else {
                clearScreen();
                conselorPortal();
            }
        } else if (loginChoice == 2) {
            System.out.println("***** Director Login Portal *****");
            System.out.print("Email: ");
            emailInput = keyboard.nextLine();
            System.out.print("Password: ");
            passwordInput = keyboard.nextLine();

            if (!campSystem.loginDirector(emailInput, passwordInput)) {
                clearScreen();
                System.out.println("Invalid Email, Password, or Usertype\nReturning to login portal...");
                sleep(2000);
                loginPortal();
            } else {
                clearScreen();
                directorPortal();
            }
        } else if (loginChoice == 3) {
            System.out.println("***** Camper Login Portal *****");
            System.out.print("Email: ");
            emailInput = keyboard.nextLine();
            System.out.print("Password: ");
            passwordInput = keyboard.nextLine();

            if (!campSystem.loginRegisteredUser(emailInput, passwordInput)) {
                clearScreen();
                System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
                sleep(2000);
                loginPortal();
            } else {
                clearScreen();
                camperPortal();
            }
        } else if (loginChoice == 4) {
            menuSelect();
        }
    }

    private static void campInfo() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("***** Information on Our Camp *****");
        //	show camp info from JSON

        System.out.println("Enter 1 to go back to main menu");

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
        menuSelect();

    }

    private static void displayFAQ() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("***** Frequently Asked Questions *****");
        //	show camp FAQs from JSON

        System.out.println("Enter 1 to go back to main menu");

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
        menuSelect();

    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("timer error");
        }
    }

    private static void conselorPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        int option;
        boolean validOption = false;

        do {

            System.out.println("1. View Group");
            System.out.println("2. Edit Medical Info");
            System.out.println("3. View Schedule");
            System.out.println("4. Edit User Information");
            System.out.println("5. Log out");

            option = keyboard.nextInt();
            keyboard.nextLine();

            if (option > 5 || option < 1) {
                validOption = false;
            } else {
                validOption = true;
            }

        } while (!validOption);

        if (option == 1) {
            // view group
            System.out.println(campSystem.viewGroup());
        } else if (option == 2) {
            // edit med info
        } else if (option == 3) {
            //view schedule
            campSystem.viewSchedule();

            // option to print out
            System.out.println("Do you want to print this schedule out?");
            System.out.println("1. Yes \n 2. No");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                // convert to txt method
            } else if (choice == 2) {
                conselorPortal();
            }
            System.out.println("Invalid input, please try again");


        } else if (option == 4) {
            campSystem.changeInfo(null, null, null, null, null);
        }
        campSystem.logOff();
    }

    private static void directorPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        int option;
        boolean validOption = false;

        do {

            System.out.println("1. Add new Activity");
            System.out.println("2. Generate New Schedule");
            System.out.println("3. Add new FAQ");
            System.out.println("4. Edit User Information");
            System.out.println("5. Create new Camp");
            System.out.println("6. Log out");
            option = keyboard.nextInt();
            keyboard.nextLine();

            if (option > 6 || option < 1) {
                validOption = false;
            } else {
                validOption = true;
            }

        } while (!validOption);

        if (option == 1) {

            //todo error checking
            System.out.println("****** Adding New Activity ******");
            System.out.println("Please enter the following information: ");
            System.out.print("Title: ");
            String Title = keyboard.nextLine();
            System.out.print("Duration (minutes): ");
            int Duration = keyboard.nextInt();
            System.out.print("Description ");
            String Description = keyboard.nextLine();
            System.out.print("Location : ");
            String Location = keyboard.nextLine();
            campSystem.addActivity(Title, Duration, Description, Location);


            System.out.println("You have succesfully added an activity");
        } else if (option == 2) {
            // generate schedule

        } else if (option == 3) {

            System.out.println("****** Adding new FAQ ******");

            System.out.print("Enter question:");
            String FAQquestion = keyboard.nextLine();
            System.out.print("Enter answer:");
            String FAQanswer = keyboard.nextLine();

            // campSystem.addToFAQ(FAQquestion, FAQanswer);
        } else if (option == 4) {
            campSystem.changeInfo(null, null, null, null, null);
        }


        // create new theme scenerio
        else if (option == 5) {
            System.out.println("****** Create-a-camp ******");

            System.out.println("Date");
            Date date = null;
            System.out.print("Price");
            int Price = keyboard.nextInt();
            System.out.println("Information on Camp:");
            String CampInfo = keyboard.nextLine();
            System.out.println("Theme");
            String theme = keyboard.nextLine();

            campSystem.intializeCamp(date, Price, CampInfo, theme);
        } else if (option == 6) {
            campSystem.logOff();
        }

    }

    private static void camperPortal() {
        Scanner keyboard = new Scanner(System.in);

        int option;
        boolean validOption = false;

        do {
            clearScreen();
            System.out.println();

            System.out.println("****** User Portal ******");
            System.out.println("1. View Camper Registration Info");
            System.out.println("2. View Camper Medical Info");
            System.out.println("3. Register Camper");
            System.out.println("4. Remove Camper");
            System.out.println("5. Log Out");

            option = getValidInput(5);

            if (option == 1) {
                clearScreen();
                System.out.println("****** Camper Registration Info ******");
                System.out.println(campSystem.viewCamperRegistration());
                System.out.println("Hit Enter to return to User Portal");
                keyboard.nextLine();
            } else if (option == 2) {
                clearScreen();
                System.out.println("****** Camper Medical Info ******");
                System.out.println(campSystem.viewCamperMedInfo());
                System.out.println("Hit Enter to return to User Portal");
                keyboard.nextLine();
            } else if (option == 3) {
                clearScreen();
                System.out.println("****** Register a Camper ******\n" +
                        "\nTo continue, hit enter");
                keyboard.nextLine();
                Child child = getChildInput();
                Camp camp = getCampPreference(child);
                if(camp == null){
                    clearScreen();
                    System.out.println("****** Child Not Registered ******\n" +
                            "\nHit enter to return to User Portal");
                    keyboard.nextLine();
                    continue;
                }
                campSystem.registerChild(child, camp);
                clearScreen();
                System.out.println("****** Registration Complete ******\n" +
                        "\nHit enter to return to User Portal");
                keyboard.nextLine();
            } else if (option == 4) {
                clearScreen();
                System.out.println("****** Removing a Camper ******");
                System.out.print(campSystem.viewCamperRegistration());
                int numChildren = campSystem.getNumChildren();
                System.out.println((numChildren + 1) + " - Remove no child");
                int input = getValidInput(numChildren + 1);
                if(input == numChildren + 1){
                    continue;
                }
                campSystem.removeChild(input);
            } else if (option == 5) {
                campSystem.logOff();
                break;
            }
        } while (true);


//        if (option == 1) {
//            clearScreen();
//            System.out.println("****** Camper Registration Info ******");
//            System.out.println(campSystem.viewCamperRegistration());
//            keyboard.nextLine();
//            camperPortal();
//        } else if (option == 2) {
//            System.out.println("****** Camper Medical Info ******");
//            System.out.println(campSystem.viewCamperMedInfo());
//            keyboard.nextLine();
//            camperPortal();
//        } else if (option == 3) {
//            System.out.println("****** Register a Camper ******");
//            campSystem.registerChild(null, null, null, null);
//        } else if (option == 4) {
//            // unregister camper
//        } else if (option == 5) {
//            // remove camper
//        } else if (option == 6) {
//            // go back to login portal
//            loginPortal();
//        }
    }

    private static Child getChildInput() {
        clearScreen();
        System.out.println("****** Child Information ******");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter child's first name:");
        String fName = in.nextLine();
        System.out.println("Enter child's last name:");
        String lName = in.nextLine();
        System.out.println("Enter child's birthday (MM/DD/YYYY):");
        java.util.Date bday = null;
        boolean next = true;
        while (next) {
            try {
                bday = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
                next = false;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Incorrect format or date");
            }
        }
        ArrayList<Contact> emergencyContact = new ArrayList<Contact>();
        boolean yes = true;
        while (yes) {
            System.out.println("Would you like to add an emergency contact? (y/n)");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("y")) {
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
            } else if (answer.equalsIgnoreCase("n"))
                yes = false;
            else
                System.out.println("Invalid response, try again");
        }

        System.out.println("Enter child's address:");
        String address = in.nextLine();
        boolean add = true;
        ArrayList<String> allergies = new ArrayList<String>();
        while (add) {
            System.out.println("Add allergies for child, once done enter 'done'");
            String allergy = in.nextLine();
            if (allergy.equalsIgnoreCase("done")) {
                add = false;
            }
            else {
                allergies.add(allergy);
            }
        }

        add = true;
        ArrayList<String> conditions = new ArrayList<String>();
        while (add) {
            System.out.println("Add conditions and medical notes for child, once done enter 'done'");
            String condition = in.nextLine();
            if (condition.equalsIgnoreCase("done"))
                add = false;
            else
                conditions.add(condition);
        }
        System.out.println("Enter child's pediatrician first name:");
        String pFirstName = in.nextLine();
        System.out.println("Enter child's pediatrician last name:");
        String pLastName = in.nextLine();
        System.out.println("Enter child's pediatrician phone number (XXX-XXX-XXXX):");
        String pPhoneNumber = in.nextLine();
        System.out.println("Enter child's pediatrician business:");
        String pBusiness = in.nextLine();
        Pediatrician childPediatrician = new Pediatrician(pFirstName, pLastName, pPhoneNumber, pBusiness);

        MedicalInfo mInfo = new MedicalInfo(emergencyContact, address, allergies, conditions, childPediatrician);

        return new Child(fName, lName, mInfo, bday);
    }

    private static Camp getCampPreference(Child child){
        clearScreen();
        System.out.println("****** Camp Preference ******");
        ArrayList<Camp> camps = campSystem.getCamps();
        ArrayList<Camp> validCamps = new ArrayList<>();
        int count = 1;
        for(Camp c : camps){
            if(c.hasOpening(child)) {
                System.out.println(count + " - " + c);
                validCamps.add(c);
                count++;
            }
        }
        System.out.println((count) + " - None of these options work for you/No options available");
        int input = getValidInput(validCamps.size() + 1);
        if(input == count){
            return null;
        }
        return validCamps.get(input - 1);
    }

    private static int getValidInput(int num) {
        Scanner keyboard = new Scanner(System.in);
        int input = -1;
        while (input < 1 || input > num) {
            // Could be rephrased
            System.out.print("Please enter the number representing your choice: ");
            try {
                input = keyboard.nextInt();
                keyboard.nextLine();
            } catch (Exception e) {
                keyboard.nextLine();
                System.out.println("Invalid input...");
            }
        }
        return input;
    }
}







