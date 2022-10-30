import java.util.ArrayList;
import java.util.Date;

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
        this.campList = CampList.getInstance();
        this.userList = UserList.getInstance();
        this.activityList = ActivityList.getInstance();
        this.childList = ChildList.getInstance();
    }

    public void createAccount(String firstName, String lastName, String phoneNumber, String email, String password) {
        user = new User(firstName, lastName, email, phoneNumber, password);
        userList.addUser(user);
    }

    public boolean loginDirector(String email, String password) {
        user = userList.getUser(email, password);
        if(user == null){
            return false;
        }
        return true;
    }

    public boolean loginCounselor(String email, String password) {
        user = userList.getUser(email, password);
        if(user == null){
            return false;
        }
        return true;
    }

    public boolean loginRegisteredUser(String email, String password) {
        user = userList.getUser(email, password);
        if(user == null){
            return false;
        }
        return true;
    }

    public void logOff() {
        user = null;
    }

    public void changeInfo() {
        // huh???
        user = new User(campInfo, campInfo, campInfo, campName, campInfo);
        userList.editUser(user);
        

    }

    public void generateSchedules(Camp camp) {
        ArrayList<Group> groups = camp.getGroups();
        for(int i = 0; i < groups.size(); i++) {
            groups.get(i).getSchedule();
        }
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

    public void addActivity(String title, int duration, String description, String location) {
        Activity activity = new Activity(title, duration, description, location);
        ActivityList activityList = ActivityList.getInstance();
        activityList.addActivity(activity);
    }

    public void registerChild(String fName, String lName, MedicalInfo mInfo, Date bDay) {
        Child child = new Child(fName, lName, mInfo, bDay);
        ChildList childList = ChildList.getInstance();
        childList.addChild(child);
        
        

    }

    public void addNotes(String note) {
        Child child = new Child(campName, campInfo, null, null);
        child.addNote(note);


    }

    public void addToFAQ(String question) {
        FAQ.add(question);
    }

    public String getChildMedicalInfo() {
        Child child = new Child(campName, campInfo, null, null);
        return child.getMedInfo().toString();
    }
    public String getCounselorMedInfo() {
        Counselor counselor = new Counselor(campInfo, campInfo, campInfo, campName, campInfo, null, null);
        return counselor.getMedInfo().toString();
    }

}