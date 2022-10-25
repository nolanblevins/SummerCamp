import java.util.Scanner;
import java.io.Console;


public class CampUI {

    private static final int menuLength = 5;

	static CampSystemFacade campSystem = new CampSystemFacade(null, null, null, null, null, null, null);

	public static void main(String[] args) {

		//DataReader dataReader = new DataReader();

        headerIntro();
        
        menuSelect();
    
    
    }
    
    private static void headerIntro() {
    
        System.out.println("Welcome to GoofyGobbler Summercamp!\n\n************ Main Menu ************");
        String[] menuOptions = {"Create an account", "Login", "Information on our camp", "FAQ", "Exit"};
        for(int i=0;i<menuOptions.length;i++) {
            System.out.println((i+1)+". "+menuOptions[i]);
        }
    
    }
    
    private static void menuSelect() {
    	
    	Scanner keyboard = new Scanner(System.in);
        
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
        	
        	
        } while(menuSelection > (menuLength) || menuSelection < 1);
    
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
    	System.out.print("Username: ");
    	String username = keyboard.nextLine();
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
		}

    	errorMessage = true;
    	
    	} while(badPhoneNum);
    	
    }

	private static void loginPortal(){
		clearScreen();
		return;
	}

	private static void campInfo() {
		clearScreen();
		return;
	}

	private static void displayFAQ() {
		clearScreen();
		return;
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}



}


