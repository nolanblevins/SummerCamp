import java.util.ArrayList;

public class CampSystemFacade {
    private String campName;
    private User user;
    private ArrayList<String> FAQ;
    private String campInfo;
    private CampList campList;
    private UserList userList;
    private ActivityList activityList;
    private ChildList childList;

    
    public CampSystemFacade(String campName, User user, String campInfo) {
        this.campName = campName;
        this.user = user;
        this.campInfo = campInfo;
        this.campList = campList;
        this.userList = userList;
        this.activityList = activityList;
        this.childList = childList;
    }

    public void createAccount(String name, String phoneNumber, String email, String password) {
        
    }

    public Director loginDirector(String email, String password) {
        Director director;
        return director;
    }

    public Counselor loginCounselor(String email, String password) {
        Counselor counselor;
        return counselor;
    }

    public RegisteredUser loginRegisteredUser(String email, String password) {
        RegisteredUser registeredUser;
        return registeredUser;
    }

    public User logOff() {
        User user;
        return user;
    }

    public void changeInfo() {

    }

    public void generateSchedules(Camp camp, ArrayList<Activity> activityList) {

    }

    public String viewSchedule() {
        return null;
    }

    public String viewGroup() {
        return null;
    } 

    public String viewCounselors() {
        return null;
    }

    public void addActivity(String title, int time, String description) {
     
    }

    public void registerChild() {

    }

    public void addNotes() {

    }

    public void addQtoFAQ(String question) {

    }

    public String getMedicalInfo() {
        return null;
    }








    


    

}