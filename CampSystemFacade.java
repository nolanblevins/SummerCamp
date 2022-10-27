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

    public CampSystemFacade(String campName, User user, String campInfo, CampList campList,
            UserList userList, ActivityList activityList, ChildList childList) {
        this.campName = campName;
        this.user = user;
        this.campInfo = campInfo;
        this.campList = campList;
        this.userList = userList;
        this.activityList = activityList;
        this.childList = childList;
    }

    public void createAccount(String firstName, String lastName, String phoneNumber, String email, String password) {

    }

    public void loginDirector(String email, String password) {
        user = new Director(user.firstName, user.lastName, email, user.phoneNumber, password);
        
    }

    public void loginCounselor(String email, String password) {
        user = new Counselor(user.firstName, user.lastName, email, user.phoneNumber, password, null, null);
    }

    public void loginRegisteredUser(String email, String password) {
        user = new RegisteredUser(user.firstName, user.lastName, email, user.phoneNumber, password);
    }

    public void logOff() {
        user = null;
    }

    public void changeInfo() {

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
        ActivityList activityList = new ActivityList();
        activityList.getInstance();
        activityList.addActivity(activity);
    }

    public void registerChild() {

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