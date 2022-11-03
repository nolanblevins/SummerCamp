import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CampUI {

    static CampSystemFacade campSystem = new CampSystemFacade(null, null, null);

    public static void main(String[] args) {

        // DataReader dataReader = new DataReader();

        loadingScreen();

        menuSelect();

        campSystem.saveInformation();
    }

    /**
     *
     * Loading Screen while the app is loading in
     *
     */
    private static void loadingScreen() {
        clearScreen();
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

    /**
     * The starting menu that will be displayed when no user is logged on
     */
    private static void menuSelect() {

        Scanner keyboard = new Scanner(System.in);

        do {
            clearScreen();
            System.out.println("Welcome to GoofyGobbler Summercamp!\n");
            System.out.println("************ Main Menu ************");
            String[] menuOptions = {"Create an account", "Login", "Information on our camp", "FAQ", "Exit"};
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println((i + 1) + ". " + menuOptions[i]);
            }
            int option = getValidInput(menuOptions.length);
            if (option == 1) {
                createAccountMenu();
            } else if (option == 2) {
                loginPortal();
            } else if (option == 3) {
                campInfo();
            } else if (option == 4) {
                displayFAQ();
            } else if (option == 5) {
                clearScreen();
                System.out.println("   ____    U  ___ u   U  ___ u  ____          ____   __   __U _____ u ");
                System.out.println("U /'___|u   \\/'_ \\/    \\/'_ \\/ |  _'\\      U | __')u \\ \\ / /\\| ___'|/ ");
                System.out.println("\\| |  _ /   | | | |    | | | |/| | | |      \\|  _ \\/  \\ V /  |  _|'   ");
                System.out.println(" | |_| |.-,_| |_| |.-,_| |_| |U| |_| |\\      | |_) | U_|'|_u | |___   ");
                System.out.println("  \\____| \\_)-\\___/  \\_)-\\___/  |____/ u      |____/    |_|   |_____|  ");
                System.out.println("  _)(|_       \\\\         \\     |||_        _|| \\\\_.-,//|(_  <<   >>  ");
                System.out.println(" (__)__)     (__)       (__)   (__)_)      (__) (__)\\_) (__)(__) (__) ");
                return;
            } else {
                System.out.println("Menu option not valid, choose again...");
            }


        } while (true);
    }

    /**
     * The menu for creating an account
     */
    private static void createAccountMenu() {
        Scanner keyboard = new Scanner(System.in);

        clearScreen();
        // TODO Error check inputs???
        System.out.println("************ Account Registration ************\n");
        System.out.println("Please enter the following information: ");

        System.out.print("First name: ");
        String firstname = keyboard.nextLine();

        System.out.print("Last name: ");
        String lastname = keyboard.nextLine();

        System.out.print("Email: ");
        String emailInput = keyboard.nextLine();
        while (!campSystem.isEmailValid(emailInput)) {
            System.out.println("Invalid Email, please try again");
            emailInput = keyboard.nextLine();

        }

        System.out.print("Phone number (###-###-####): ");
        String phoneNumber = keyboard.nextLine();
        while (!campSystem.isPhoneValid(phoneNumber)) {
            System.out.println("Invalid Phone Number, please try again");
            phoneNumber = keyboard.nextLine();
        }

//        System.out.print("Password reqs: \n+ contains at least 8 characters and at most 20 characters ");
//        System.out.println("+ contains one digit, one upperCase alphabet, one special character (!@#$%&*()-+=^.)");
        System.out.print("Password: ");
        String password = keyboard.nextLine();
//        while (!campSystem.isValidPassword(password)) {
//            System.out.println("Invalid Email, please try again");
//            password = keyboard.nextLine();
//        }

        campSystem.createAccount(firstname, lastname, phoneNumber, emailInput, password);
        clearScreen();
        System.out.println("****** Account Creation Success ******");
        System.out.println("Hit enter to continue...");
        keyboard.nextLine();

    }

    /**
     * The portal for deciding what to login to
     */
    private static void loginPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);


        int option;
        String emailInput;
        String passwordInput;
        do {
            clearScreen();
            System.out.println("****** Login Portal ******");
            System.out.println("1. Counselor login");
            System.out.println("2. Director login");
            System.out.println("3. Camper login");
            System.out.println("4. Go back to previous page");

            option = getValidInput(4);

            if (option == 1) {
                clearScreen();
                System.out.println("***** Counselor Login Portal *****");
                System.out.print("Email: ");
                emailInput = keyboard.nextLine();
                System.out.print("Password: ");
                passwordInput = keyboard.nextLine();

                if (!campSystem.loginCounselor(emailInput, passwordInput)) {
                    clearScreen();
                    System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
                    sleep(2000);
                } else {
                    clearScreen();
                    counselorPortal();
                }

            } else if (option == 2) {
                clearScreen();
                System.out.println("***** Director Login Portal *****");
                System.out.print("Email: ");
                emailInput = keyboard.nextLine();
                System.out.print("Password: ");
                passwordInput = keyboard.nextLine();

                if (!campSystem.loginDirector(emailInput, passwordInput)) {
                    clearScreen();
                    System.out.println("Invalid Email, Password, or Usertype\nReturning to login portal...");
                    sleep(2000);
                } else {
                    clearScreen();
                    directorPortal();
                }

            } else if (option == 3) {
                clearScreen();
                System.out.println("***** Camper Login Portal *****");
                System.out.print("Email: ");
                emailInput = keyboard.nextLine();
                System.out.print("Password: ");
                passwordInput = keyboard.nextLine();

                if (!campSystem.loginRegisteredUser(emailInput, passwordInput)) {
                    clearScreen();
                    System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
                    sleep(2000);
                } else {
                    clearScreen();
                    userPortal();
                }
            } else if (option == 4) {
                return;
            }
        } while (true);

    }

    /**
     * Portal for displaying the camp info
     */
    private static void campInfo() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("***** Information on Our Camp *****");
        System.out.println(campSystem.viewCampInfo());
        System.out.println("Enter 1 to go back to main menu");

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
    }

    /**
     * Displays FAQs for the camp
     */
    private static void displayFAQ() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("***** Frequently Asked Questions *****");
        System.out.println(campSystem.getFAQ());

        System.out.println("Enter 1 to go back to main menu");

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
    }

    /**
     * Clears the screen
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * The program will pause for the amount "num"
     *
     * @param num   The amount MS the program will sleep
     */
    private static void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("timer error");
        }
    }

    /**
     * Displays the portal for a counselor
     */
    private static void counselorPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        int option;

        do {
            clearScreen();
            System.out.println("***** Welcome to Counselor Portal ******");
            System.out.println("1. View Group");
            System.out.println("2. Edit Medical Info");
            System.out.println("3. Get Group Medical Info");
            System.out.println("4. View Schedule");
            System.out.println("5. Edit User Information");
            System.out.println("6. Log out");

            option = getValidInput(6);

            if (option == 1) {
                clearScreen();
                ArrayList<Camp> camps = campSystem.getCounselorCamps();
                System.out.println("****** View Groups ******");
                System.out.println("Which camp do you want to view the group for?");
                for(int i = 1; i <= camps.size(); i++){
                    System.out.println(i + " - " + camps.get(i-1));
                }
                int input = getValidInput(camps.size());
                Camp camp = camps.get(input - 1);
                clearScreen();
                System.out.println("****** Group " + input + " ******");
                String groupString = campSystem.viewGroup(camp);
                System.out.println(groupString);
                printToTxt(groupString);
            } else if (option == 2) {
                MedicalInfo medicalInfo = getMedicalInfo();
                campSystem.changeCounselorMedInfo(medicalInfo);

            } else if(option == 3){
                clearScreen();
                ArrayList<Camp> camps = campSystem.getCounselorCamps();
                System.out.println("****** View Group Medical Info ******");
                System.out.println("Which camp do you want to view the group for?");
                for(int i = 1; i <= camps.size(); i++){
                    System.out.println(i + " - " + camps.get(i-1));
                }
                int input = getValidInput(camps.size());
                Camp camp = camps.get(input - 1);
                String medInfo = campSystem.viewCamperMedInfo(camp);
                System.out.println(medInfo);
                printToTxt(medInfo);
            } else if (option == 4) {
                clearScreen();
                System.out.println("****** View Schedule ******");
                System.out.println("Which camp do you want to view the schedule for?");
                // view schedule
                ArrayList<Camp> camps = campSystem.getCounselorCamps();
                for(int i = 1; i <= camps.size(); i++){
                    System.out.println(i + " - " + camps.get(i-1));
                }
                int input = getValidInput(camps.size());
                String scheduleString = campSystem.getCounselorSchedule(camps.get(input - 1));
                clearScreen();
                System.out.println("****** Schedule ******");
                System.out.println(scheduleString);
//                String scheduleString = "";
//                for(Schedule s : schedule){
//                    scheduleString += s.toString() + "\n";
//                }
//                System.out.println(scheduleString);

                printToTxt(scheduleString);

            } else if (option == 5) {
                changeInfoUser();
            } else if (option == 6) {
                campSystem.logOff();
                return;
            }

        } while (true);
    }

    /**
     * Asks the user if they want to print out a string
     * to a text file. Then prompts them for the name of
     * the text file if yes
     *
     * @param string    The String to be printed
     */
    private static void printToTxt(String string){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to print this out?");
        System.out.println("1. Yes \n2. No");
        int choice = getValidInput(2);
        if (choice == 1) {
            String dir = "./TxtPrints/";
            System.out.println("What would you like to name the .txt file?");
            dir += keyboard.nextLine();
            try{
                FileWriter fileWriter = new FileWriter(dir);
                fileWriter.write(string);
                fileWriter.close();
                System.out.println("Schedule written to file");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
                return;
            } catch(Exception e){

            }
        }
        System.out.println("Schedule not written to file");
        System.out.println("Hit enter to continue...");
        keyboard.nextLine();
    }

    /**
     * The portal for the director
     */
    private static void directorPortal() {
        Scanner keyboard = new Scanner(System.in);

        int option;

        do {
            clearScreen();

            System.out.println("****** Welcome to Director Portal ******");
            System.out.println("1. Add new Activity");
            System.out.println("2. Add new FAQ");
            System.out.println("3. Edit User Information");
            System.out.println("4. Create new Camp");
            System.out.println("5. View Group Schedule");
            System.out.println("6. Log out");

            option = getValidInput(6);

            if (option == 1) {
                clearScreen();
                System.out.println("****** Adding New Activity ******");
                System.out.println("Please enter the following information: ");
                System.out.print("Title: ");
                String Title = keyboard.nextLine();
                System.out.print("Duration(hours): ");
                int Duration = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Description: ");
                String Description = keyboard.nextLine();
                System.out.print("Location: ");
                String Location = keyboard.nextLine();
                campSystem.addActivity(Title, Duration, Description, Location);

                System.out.println("You have succesfully added an activity");
                clearScreen();
                System.out.println("****** Activity Added ******");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
            } else if (option == 2) {
                clearScreen();
                System.out.println("****** Adding new FAQ ******");

                System.out.print("Enter question:");
                String FAQquestion = keyboard.nextLine();
                System.out.print("Enter answer:");
                String FAQanswer = keyboard.nextLine();
                campSystem.addToFAQ(FAQquestion, FAQanswer);
                clearScreen();
                System.out.println("****** FAQ Added ******");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();

            } else if (option == 3) {
                changeInfoUser();
            }

            else if (option == 4) {
                clearScreen();
                System.out.println("****** Create-a-camp ******");

                System.out.print("Date(mm/dd/yyyy): ");
                String strDate = keyboard.nextLine();
                String pattern = "MM/dd/yyyy";
                Date date = new Date();
                try {
                    date = new SimpleDateFormat(pattern).parse(strDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.print("Price: ");
                double price = keyboard.nextDouble();
                keyboard.nextLine();

                System.out.print("Theme: ");
                String theme = keyboard.nextLine();
                campSystem.createCamp(date, price, theme);
                clearScreen();
                System.out.println("****** Camp Created ******");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
            } else if(option == 5){
                clearScreen();
                System.out.println("****** View Group Schedule ******");
                ArrayList<Camp> camps =campSystem.viewAllCamps();
                for(int i = 0; i < camps.size(); i++) {
                    System.out.println(i+1 + " - " + camps.get(i));
                }                
                System.out.println("What camp would you like to view a schedule for? ");
                int campNum = getValidInput(camps.size());
                Camp camp = camps.get(campNum-1);
                ArrayList<Group> groups = camp.getGroups();
                
                // needs to be fixed --------------------------------------------------------------------------------------
                for(int i = 0; i < groups.size(); i++) {
                    System.out.println(i+1 + " - " + groups.get(i));
                    
                } 

                int groupNum = getValidInput(groups.size());
                Group group = groups.get(groupNum - 1);
                clearScreen();
                System.out.println("****** View Schedule ******");
                System.out.println(group.scheduleToString());
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
            } else if (option == 6) {
                campSystem.logOff();
                return;
            }

        }while(true);
    }

    /**
     * The portal for the User
     */
    private static void userPortal() {
        Scanner keyboard = new Scanner(System.in);

        int option;

        do {
            clearScreen();
            System.out.println("****** User Portal ******");
            System.out.println("1. View Camper Registration Info");
            System.out.println("2. View Camper Medical Info");
            System.out.println("3. Register Camper");
            System.out.println("4. Remove Camper");
            System.out.println("5. Change User Information");
            System.out.println("6. Change Child Information");
            System.out.println("7. Log Out");

            option = getValidInput(7);

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
                ArrayList<Camp> camp = getCampPreference(child);
                if (camp.size() == 0) {
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
                if (input == numChildren + 1) {
                    continue;
                }
                campSystem.removeChild(input);
            } else if (option == 5) {
                changeInfoUser();
            } else if (option == 6) {
                changeChildInfo();
            } else if (option == 7) {
                campSystem.logOff();
                break;
            }
        } while (true);

    }

    /**
     * Change the info for the users
     */
    private static void changeInfoUser() {
        clearScreen();
        System.out.println("****** Change Information ******");
        Scanner in = new Scanner(System.in);

        boolean next = true;
        while (next) {
            System.out.println("What information would you like to change?" +
                    "\n" + "\t" + "1 - First Name" +
                    "\n" + "\t" + "2 - Last Name" +
                    "\n" + "\t" + "3 - Email" +
                    "\n" + "\t" + "4 - Phone Number" +
                    "\n" + "\t" + "5 - Password");

            int userChoice = getValidInput(5);
            if (userChoice == 1) {
                System.out.println("Enter new first name:");
                String newFirstName = in.nextLine();
                campSystem.changeUserInfo(newFirstName, null, null, null, null);
            } else if (userChoice == 2) {
                System.out.println("Enter new last name:");
                String newLastName = in.nextLine();
                campSystem.changeUserInfo(null, newLastName, null, null, null);
            } else if (userChoice == 3) {
                System.out.println("Enter new email:");
                String newEmail = in.nextLine();
                campSystem.changeUserInfo(null, null, null, newEmail, null);
            } else if (userChoice == 4) {
                System.out.println("Enter new Phone Number:");
                String newPhoneNumber = in.nextLine();
                campSystem.changeUserInfo(null, null, newPhoneNumber, null, null);
            } else if (userChoice == 5) {
                System.out.println("Enter new password:");
                String newPassword = in.nextLine();
                campSystem.changeUserInfo(null, null, null, null, newPassword);
            }
            System.out.println("Would you like to change any other information? (y/n)");
            String answer = in.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                next = false;
            }
        }
    }

    /**
     * Change the info for a child
     */
    private static void changeChildInfo() {
        Scanner keyboard = new Scanner(System.in);
        clearScreen();
        System.out.println("****** Change Child Information ******");
        System.out.println("For what child would you like to change information?");
        System.out.println(campSystem.viewCamperRegistration());
        int childInput = getValidInput(campSystem.getNumChildren());
        System.out.println();
        System.out.println("What would you like to change?");
        clearScreen();
        System.out.println("****** Change Child Information ******");
        System.out.println("What information would you like to change?" +
                "\n" + "\t" + "1 - First Name" +
                "\n" + "\t" + "2 - Last Name" +
                "\n" + "\t" + "3 - Medical Info" +
                "\n" + "\t" + "4 - Camps Registration" +
                "\n" + "\t" + "5 - No Change");

        int changeInput = getValidInput(5);
        if (changeInput == 1) {
            System.out.println("Input First Name: ");
            String firstName = keyboard.nextLine();
            campSystem.changeChildInfo(childInput - 1, firstName, null, null);
        } else if (changeInput == 2) {
            System.out.println("Input Second Name: ");
            String lastName = keyboard.nextLine();
            campSystem.changeChildInfo(childInput - 1, null, lastName, null);
        } else if (changeInput == 3) {
            MedicalInfo mInfo = getMedicalInfo();
            campSystem.changeChildInfo(childInput - 1, null, null, mInfo);
        } else if (changeInput == 4) {
            changeCampRegistration(campSystem.getChild(childInput - 1));
            return;
        } else if (changeInput == 5) {
            clearScreen();
            System.out.println("****** Child Data Not Changed ******");
            System.out.println("Hit enter to continue");
            keyboard.nextLine();
            return;
        }
        clearScreen();
        System.out.println("******* Child Data Changed ******");
        System.out.println("Hit enter to continue...");
        keyboard.nextLine();
    }

    /**
     * Asks the user for inputs to get a MedicalInfo
     *
     * @return  The inputted medical info
     */
    private static MedicalInfo getMedicalInfo() {
        Scanner in = new Scanner(System.in);

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
            } else {
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

        return mInfo;
    }

    /**
     * Allows the user to change the camp registration for their child
     *
     * @param child     The inputted child
     */
    private static void changeCampRegistration(Child child) {
        Scanner keyboard = new Scanner(System.in);
        clearScreen();
        System.out.println("****** Change Child Registration ******");
        System.out.println("What would you like to do?" +
                "\n\t1 - Register for another camp" +
                "\n\t2 - Unregister from camp");
        int input = getValidInput(2);
        if (input == 1) {
            ArrayList<Camp> camps = getCampPreference(child);
            if (camps == null) {
                System.out.println("****** Child Not Added to a Camp ******");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
                return;
            }
            for (Camp c : camps) {
                c.addChild(child);
            }
            clearScreen();
            System.out.println("****** Child Added to Camp(s) ******");
            System.out.println("Hit enter to continue...");
            keyboard.nextLine();
        } else if (input == 2) {
            clearScreen();
            ArrayList<Camp> camps = campSystem.getCampsByChild(child);
            System.out.println("****** Removing a Child From Camp ******");
            for (int i = 1; i <= camps.size(); i++) {
                System.out.println(i + " - " + camps.get(i - 1));
                System.out.println();
            }
            System.out.println((camps.size() + 1) + " - Remove child from no camps");
            int option = getValidInput(camps.size() + 1);
            if (option == camps.size() + 1) {
                clearScreen();
                System.out.println("****** Child not Removed From any Camps ******");
                System.out.println("Hit enter to continue...");
                keyboard.nextLine();
                return;
            }
            camps.get(option - 1).removeChild(child);
            clearScreen();
            System.out.println("****** Child Removed From Camp ******");
            System.out.println("Hit enter to continue...");
            keyboard.nextLine();
        }
    }

    /**
     * Gets the inputs from a user for a child
     *
     * @return  the inputted child
     */
    private static Child getChildInput() {
        clearScreen();
        System.out.println("****** Child Information ******");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter child's first name:");
        String fName = in.nextLine();
        System.out.println("Enter child's last name:");
        String lName = in.nextLine();

        Date bday = null;
        boolean next = true;
        while (next) {
            System.out.println("Enter child's birthday (MM/DD/YYYY):");
            try {
                bday = new SimpleDateFormat("MM/dd/yyyy").parse(in.nextLine());
                next = false;
            } catch (Exception e) {
                next = true;
                System.out.println("Incorrect format or date");
            }
        }
        MedicalInfo mInfo = getMedicalInfo();

        return new Child(fName, lName, mInfo, bday);
    }

    /**
     * Goes through and gets a list of camps that the user wants to sign
     * their child up for
     *
     * @param child     The child being signed up for camp
     * @return          Camps to sign the child up for
     */
    private static ArrayList<Camp> getCampPreference(Child child) {
        clearScreen();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Camp Preference ******");
        ArrayList<Camp> camps = campSystem.getCamps();
        ArrayList<Camp> validCamps = new ArrayList<>();
        int count = 1;
        for (Camp c : camps) {
            if (c.hasOpening(child)) {
                System.out.println(count + " - " + c);
                validCamps.add(c);
                count++;
            }
        }
        System.out.println((count) + " - None of these options work for you/No options available");
        boolean moreCamps = false;
        ArrayList<Camp> campPreferences = new ArrayList<>();
        do {
            moreCamps = false;
            int input = getValidInput(validCamps.size() + 1);
            System.out.println();
            if (input == count) {
                break;
            }
            if (campPreferences.contains(validCamps.get(input - 1))) {
                System.out.println("Child already registered for this camp...\n");
            } else {
                campPreferences.add(validCamps.get(input - 1));
            }
            System.out.print("Would you like to add another camp?(y/n): ");
            String choice = keyboard.nextLine();
            System.out.println();
            if (choice.equalsIgnoreCase("y")) {
                moreCamps = true;
            }

        } while (moreCamps);

        return campPreferences;
    }

    /**
     * Make sure inputs from the user are valid
     *
     * @param num   The upper bound for the input
     * @return      The inputted number
     */
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