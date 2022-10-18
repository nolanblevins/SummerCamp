import java.util.ArrayList;

public class CampSystemFacade {
    private String campName;
    private User user;
    private ArrayList<String> FAQ;
    private String campInfo;
    
    public CampSystemFacade(String campName, User user, String campInfo) {
        this.campName = campName;
        this.user = user;
        this.campInfo = campInfo;
    }

    public addToFAQ(String question, String answer) {
        FAQ.add(answer);
    }
    


    

}