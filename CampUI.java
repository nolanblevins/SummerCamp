import java.util.Scanner;
import java.lang.Thread;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;


public class CampUI {

	static CampSystemFacade campSystem = new CampSystemFacade(null, null, null);

	public static void main(String[] args) {

		//DataReader dataReader = new DataReader();

		loadingScreen();

        menuSelect();

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
		for(int i=0;i<100;i++) {
			System.out.print((i+1)+"%");
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
        for(int i=0;i<menuOptions.length;i++) {
            System.out.println((i+1)+". "+menuOptions[i]);
        }

        int menuSelection;

        boolean invalidInput = false;

        do {

        	if(invalidInput) {
        		System.out.println("Menu option not valid, choose again...");
        	}

        	menuSelection = keyboard.nextInt();
        	keyboard.nextLine();

        	if(menuSelection == 1) {
        		createAccountMenu();
        	}
        	else if(menuSelection == 2) {
				loginPortal();

        	}
        	else if(menuSelection == 3) {
        		campInfo();
        	}
        	else if(menuSelection == 4) {
        		displayFAQ();
        	}
        	else if(menuSelection == 5) {
				break;
        	}
        	else {

        	}


        } while(menuSelection > (menuOptions.length) || menuSelection < 1);

    }

    private static void createAccountMenu() {

    	Scanner keyboard = new Scanner(System.in);

    	boolean badPhoneNum;
    	boolean errorMessage = false;
    	boolean emailValid = false;
		boolean passwordValid = false;
    	do {

    	clearScreen();

    	if(errorMessage) {
    		System.out.println("Invalid phone number. Please try again...\n ");
    	}

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


    	if(!isEmailValid(emailInput)){
			emailValid = false;
			System.out.println("Invalid Email Address, please try again");
		}
			emailValid = true;

		if(!isPhoneValid(phoneNumber)){
			badPhoneNum = true;
			System.out.println("Invalid Phone Number, please try again");
		}
			badPhoneNum = false;

		if(!isValidPassword(password)){
			passwordValid = false;
			System.out.println("Invalid Password, please try again");
			String[] passwordRequire = {"8 characters and at most 20 character",
										"one digit", "one upper case alphabet", "one lower case alphabet",
										"one special character which includes !@#$%&*()-+=^."};
			for(int i=0;i<passwordRequire.length; i++ ){
				System.out.println((i+1)+"It contains at least "+passwordRequire[i]);
			}
		}
			passwordValid = true;

		if(badPhoneNum && emailValid){
			errorMessage = false;
			campSystem.createAccount(firstname, lastname, phoneNumber, emailInput, password);
			System.out.println("You have succesfully created an account");
		}

    	errorMessage = true;

	 } while(errorMessage);

	}


	public static boolean isPhoneValid(String phoneNumber)	{


		if(phoneNumber.length() != 12) {
    			return false;
    	}

    	else {
    		for(int i=0;i<phoneNumber.length();i++) {

					if(phoneNumber.charAt(i) != '0' && phoneNumber.charAt(i) != '1'
    					&& phoneNumber.charAt(i) != '2' && phoneNumber.charAt(i) != '3'
    					&& phoneNumber.charAt(i) != '4' && phoneNumber.charAt(i) != '5'
    					&& phoneNumber.charAt(i) != '6' && phoneNumber.charAt(i) != '7'
    					&& phoneNumber.charAt(i) != '8' && phoneNumber.charAt(i) != '9'
    					&& phoneNumber.charAt(i) != '-')  {
    				return false;
    			}
    		}

    		if(phoneNumber.charAt(3) != '-' && phoneNumber.charAt(7) != '-') {
    			return true;
    		}

    	}
			return true;

	}

	public static boolean isEmailValid(String emailInput) {

		return emailInput.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");

	}

	public static boolean isValidPassword(String password)
    {

        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }


	private static void loginPortal(){
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

			if(loginChoice > 4 || loginChoice < 1) {
				validLoginOption = false;
			}
			else {
				validLoginOption = true;
			}

		}while(!validLoginOption);

		clearScreen();
		String emailInput;
		String passwordInput;

		if(loginChoice == 1) {
			System.out.println("***** Counselor Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.print("Password: ");
			passwordInput = keyboard.nextLine();

			if(!campSystem.loginCounselor(emailInput, passwordInput)){
				clearScreen();
				System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
				sleep(2000);
				loginPortal();
			}
			else{
				clearScreen();
				conselorPortal();
			}
		}
		else if(loginChoice == 2) {
			System.out.println("***** Director Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.print("Password: ");
			passwordInput = keyboard.nextLine();

			if(!campSystem.loginDirector(emailInput, passwordInput)){
				clearScreen();
				System.out.println("Invalid Email, Password, or Usertype\nReturning to login portal...");
				sleep(2000);
				loginPortal();
			}
			else{
				clearScreen();
				directorPortal();
			}
		}
		else if(loginChoice == 3) {
			System.out.println("***** Camper Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.print("Password: ");
			passwordInput = keyboard.nextLine();

			if(!campSystem.loginRegisteredUser(emailInput, passwordInput)){
				clearScreen();
				System.out.println("Invalid Email, Password, or usertype\nReturning to login portal...");
				sleep(2000);
				loginPortal();
			}
			else{
				clearScreen();
				camperPortal();
			}
		}
		else if(loginChoice == 4) {
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
		while(true){
			input = keyboard.nextLine();
			if(input.equals("1")) {
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
		while(true){
			input = keyboard.nextLine();
			if(input.equals("1")) {
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

			if(option > 5 || option < 1) {
				validOption = false;
			}
			else {
				validOption = true;
			}

		}while(!validOption);

		if(option == 1){
		// view group
			System.out.println(campSystem.viewGroup());
	}
		else if(option ==2){
			// edit med info
		}

		else if(option ==3){
			//view schedule
			campSystem.viewSchedule();
		}

		else if (option ==4){
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

			if(option > 6 || option < 1) {
				validOption = false;
			}
			else {
				validOption = true;
			}

		}while(!validOption);

		if(option == 1){

			//todo error checking
			System.out.println("****** Adding New Activity ******");
			System.out.println("Please enter the following information: ");
			System.out.print("Title: ");
			String Title = keyboard.nextLine();
			System.out.print("Duration (minutes): " );
			int Duration = keyboard.nextInt();
			System.out.print("Description ");
			String Description = keyboard.nextLine();
			System.out.print("Location : ");
			String Location = keyboard.nextLine();
			campSystem.addActivity(Title, Duration, Description, Location);


			System.out.println("You have succesfully added an activity");
		}

		else if(option ==2){
			// generate schedule

			}

		else if(option ==3){

			System.out.println("****** Adding new FAQ ******");

			System.out.print("Enter question:");
			String FAQquestion = keyboard.nextLine();
			System.out.print("Enter answer:");
			String FAQanswer = keyboard.nextLine();

			// campSystem.addToFAQ(FAQquestion, FAQanswer);
		}


		else if(option ==4){
			campSystem.changeInfo(null, null, null, null, null);
		}


		// create new theme scenerio
		else if(option ==5){

		}

		else if(option ==6){
			campSystem.logOff();
		}

	}

	private static void camperPortal() {
		clearScreen();

		Scanner keyboard = new Scanner(System.in);

		int option;
		boolean validOption = false;

		do {
		System.out.println();

		System.out.println("****** User Portal ******");
		System.out.println("1. View Camper Registration Info");
		System.out.println("2. View Camper Medical Info");
		System.out.println("3. Register Camper");
		System.out.println("3. Unregister Camper");
		System.out.println("5. Remove Camper");
		System.out.println("6. Log Out");

		System.out.print("Please enter your option: ");

		option = keyboard.nextInt();
		keyboard.nextLine();

		if(option > 6 || option < 1) {
			validOption = false;
		}
		else {
			validOption = true;
		}

		}while(!validOption);


		if(option == 1) {
			clearScreen();
			System.out.println("****** Camper Registration Info ******");
			System.out.println(campSystem.viewCamperRegistration());
			keyboard.nextLine();
			camperPortal();
		}
        else if(option == 2){
            // med info
        }
		else if(option == 3) {
			// register


		}
		else if(option == 4) {
			// unregister camper
		}


		else if(option == 5) {
			// remove camper
		}


		else if(option == 6) {
				// go back to login portal
			loginPortal();
		}
    }


}







