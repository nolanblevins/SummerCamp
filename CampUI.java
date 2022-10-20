public class CampUI {

    public static void main(String[] args) {

        headerIntro();
    
    
    
    }
    
    private static void headerIntro() {
    
        System.out.println("Welcome to GoofyGobbler Summercamp!\n\n************ Main Menu ************");
        String[] menuOptions = {"Create an account", "Login", "Information on our camp", "FAQ", "Exit"};
        for(int i=0;i<menuOptions.length;i++) {
            System.out.println((i+1)+menuOptions[i]);
        }
    
    }
    
}
