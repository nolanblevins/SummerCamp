import java.util.Scanner;
import java.io.Console;


public class CampUI {

	static CampSystemFacade campSystem = new CampSystemFacade(null, null, null, null, null, null, null);

	public static void main(String[] args) {

		//DataReader dataReader = new DataReader();
        
        menuSelect();
    
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
    	String email = keyboard.nextLine();
    	System.out.print("Phone number (###-###-####) : ");
    	String phoneNumber = keyboard.nextLine();
    	System.out.print("Password: ");
    	String password = keyboard.nextLine();
    	
    	badPhoneNum = false;
    	
    	if(phoneNumber.length() != 12) {
    		badPhoneNum = true;
    	}
    	else {
    		for(int i=0;i<phoneNumber.length();i++) {
    			if(phoneNumber.charAt(i) != '0' && phoneNumber.charAt(i) != '1' 
    					&& phoneNumber.charAt(i) != '2' && phoneNumber.charAt(i) != '3' 
    					&& phoneNumber.charAt(i) != '4' && phoneNumber.charAt(i) != '5'
    					&& phoneNumber.charAt(i) != '6' && phoneNumber.charAt(i) != '7'
    					&& phoneNumber.charAt(i) != '8' && phoneNumber.charAt(i) != '9'
    					&& phoneNumber.charAt(i) != '-')  {
    				badPhoneNum = true;
    			}
    		}
    		
    		if(phoneNumber.charAt(3) != '-' && phoneNumber.charAt(7) != '-') {
    			badPhoneNum = true;
    		}
    		
    	}
    	
		if(!badPhoneNum) {
			campSystem.createAccount(firstname, lastname, phoneNumber, email, password);
			System.out.println("You have successfully created an account.");

        	menuSelect();

		}

    	errorMessage = true;
    	
    	} while(badPhoneNum);
    	
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

		String emailInput;
		String passwordInput;

		if(loginChoice == 1) {
			System.out.println("***** Counselor Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.println("Password: ");
			passwordInput = keyboard.nextLine();

			campSystem.loginCounselor(emailInput, passwordInput);

			conselorPortal();

		}
		else if(loginChoice == 2) {
			System.out.println("***** Director Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.println("Password: ");
			passwordInput = keyboard.nextLine();

			campSystem.loginDirector(emailInput, passwordInput);

			directorPortal();
			
		}
		else if(loginChoice == 3) {
			System.out.println("***** Camper Login Portal *****");
			System.out.print("Email: ");
			emailInput = keyboard.nextLine();
			System.out.println("Password: ");
			passwordInput = keyboard.nextLine();

			campSystem.loginRegisteredUser(emailInput, passwordInput); // DO WE NEED loginCamper method in facade?

			camperPortal();
			
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

	private static void conselorPortal() {
		clearScreen();
		
	}

	private static void directorPortal() {
		clearScreen();

	}

	private static void camperPortal() {
		clearScreen();

	}



}


