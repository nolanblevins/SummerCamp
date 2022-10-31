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
    private GroupList groupList;

    public CampSystemFacade(String campName, User user, String campInfo) {
        this.campName = campName;
        this.user = user;
        this.campInfo = campInfo;
        this.campList = CampList.getInstance();
        this.userList = UserList.getInstance();
        this.activityList = ActivityList.getInstance();
        this.childList = ChildList.getInstance();
        this.groupList = GroupList.getInstance();
    }

    public ArrayList<Camp> viewAllCamps() {
        ArrayList<Camp> camps = campList.getAllCamps();
        return camps;
    }

    public Camp intializeCamp(Date date, int price, String campInfo, String theme) {
        Camp camp = new Camp(date, price, campInfo);
        camp.generateGroupSchedules();
        camp.setTheme(theme);    
        /**
         * TODO:
         * create groups/organize by age
         * 
         * 
         */
          
        return camp;
    }

    public void createAccount(String firstName, String lastName, String phoneNumber, String email, String password) {
        user = new User(firstName, lastName, email, phoneNumber, password);
        userList.addUser(user);
    }

    public boolean loginDirector(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.DIRECTOR) {
            user = null;
            return false;
        }
        return true;
    }

    public boolean loginCounselor(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.COUNSELOR) {
            user = null;
            return false;
        }
        return true;
    }

    public boolean loginRegisteredUser(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.REGISTERED_USER) {
            user = null;
            return false;
        }
        return true;
    }

    public void logOff() {
        user = null;
    }

    public void changeInfo(String firstName, String lastName, String phoneNumber, String email, String password) {
        user = new User(firstName, lastName, phoneNumber, email, password);
        userList.editUser(user);

    }

    public void generateSchedules(Camp camp) {
        ArrayList<Group> groups = camp.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).getSchedule();
        }
    }

    public ArrayList<Schedule> viewSchedule() {
        Group group = new Group(campName, 0, 0);

        return group.getSchedule();
    }

    public ArrayList<Group> viewGroups(Camp camp) {
        ArrayList<Group> groups = new ArrayList<>();
        groups = camp.getGroups();
        return groups;
    }

    public String viewCounselors() {
        ArrayList<User> users = userList.getUsers();
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

    public String viewGroup() {
        return "";
    }

    public String viewCamper(){
        String ret = "";

        for(Child c : ((RegisteredUser) user).getChildren()){
            ret += c.toString() + "\n";
            ret += campList.getCamp(c).toString() + "\n";
            ret += "\n";
        }

        return ret;
    }
}