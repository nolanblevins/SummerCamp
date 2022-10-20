import java.util.Scanner;

public class CampUI {

    private static final int menuLength = 5;

	public static void main(String[] args) {

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
        		
        	}
        	else if(menuSelection == 3) {
        		
        	}
        	else if(menuSelection == 4) {
        		
        	}
        	else if(menuSelection == 5) {
        		
        	}
        	else {
        		invalidInput = true;
        	}
        	
        	
        } while(menuSelection > (menuLength) || menuSelection < 1);
    
    }
    
    private static void createAccountMenu() {
    	
    	clearScreen();
    	System.out.println("************ Account Registration ************");
    	
    }
    
    private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
    
}
