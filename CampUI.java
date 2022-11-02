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

        DataWriter.saveGroups();
    }

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
            System.out.println("Invalid Email, please try again");
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
                    conselorPortal();
                }

            } else if (option == 2) {
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

    private static void displayFAQ() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("***** Frequently Asked Questions *****");
        // show camp FAQs from JSON

        System.out.println("Enter 1 to go back to main menu");

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
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

        do {
            System.out.println("***** Welcome to Conselor Portal ******");
            System.out.println("1. View Group");
            System.out.println("2. Edit Medical Info");
            System.out.println("3. View Schedule");
            System.out.println("4. Edit User Information");
            System.out.println("5. Log out");

            option = getValidInput(5);

            if (option == 1) {
                // view group
                System.out.println(campSystem.viewGroup());

            } else if (option == 2) {
                // edit med info

            } else if (option == 3) {
                // view schedule

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
                campSystem.changeUserInfo(null, null, null, null, null);
            }
            campSystem.logOff();
        } while (true);
    }

    private static void directorPortal() {
        clearScreen();

        Scanner keyboard = new Scanner(System.in);

        int option;

        do {
            System.out.println("****** Welcome to Director Portal ******");
            System.out.println("1. Add new Activity");
            System.out.println("2. View Camp Schedule");
            System.out.println("3. Add new FAQ");
            System.out.println("4. Edit User Information");
            System.out.println("5. Create new Camp");
            System.out.println("6. Log out");
            option = keyboard.nextInt();
            keyboard.nextLine();

            option = getValidInput(6);

            if (option == 1) {

                // todo error checking
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
                // System.out.println("Enter the date of the camp would you like to generate the schedules for: ");
                // String date = keyboard.nextLine();
                // String pattern = "MM/dd/yyyy";
                // new SimpleDateFormat(pattern).format(date);
                // campSystem.getCampByDate(date);
                
                

                
                // add schedule return
                

            } else if (option == 3) {

                System.out.println("****** Adding new FAQ ******");

                System.out.print("Enter question:");
                String FAQquestion = keyboard.nextLine();
                System.out.print("Enter answer:");
                String FAQanswer = keyboard.nextLine();
                campSystem.addToFAQ(FAQquestion, FAQanswer);;
            } else if (option == 4) {
                campSystem.changeUserInfo(null, null, null, null, null);
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

        } while (true);
    }

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
            System.out.println("6. Log Out");

            option = getValidInput(6);

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
                campSystem.logOff();
                break;
            }
        } while (true);

    }

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

    private static Child getChildInput() {
        clearScreen();
        System.out.println("****** Child Information ******");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter child's first name:");
        String fName = in.nextLine();
        System.out.println("Enter child's last name:");
        String lName = in.nextLine();
        System.out.println("Enter child's birthday (MM/DD/YYYY):");
        Date bday = null;
        boolean next = true;
        while (next) {
            try {
                bday = new SimpleDateFormat("MM/dd/yyyy").parse(in.nextLine());
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

        return new Child(fName, lName, mInfo, bday);
    }

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
            if(campPreferences.contains(validCamps.get(input - 1))){
                System.out.println("Child already registered for this camp...\n");
            }
            else {
                campPreferences.add(validCamps.get(input - 1));
            }
            System.out.print("Would you like to add another camp?(y/n): ");
            String choice = keyboard.nextLine();
            System.out.println();
            if(choice.equalsIgnoreCase("y")){
                moreCamps = true;
            }

        } while(moreCamps);

        return campPreferences;
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