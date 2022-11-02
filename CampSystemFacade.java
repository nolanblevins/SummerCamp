import java.util.ArrayList;
import java.util.Date;
import java.util.regex.*;


// TODO Have director input a list of themes for a camp, instantiate camp based on that
public class CampSystemFacade {
    private String campName;
    private User user;
    private ArrayList<FAQ> FAQ;
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

    // public Camp intializeCamp(Date date, int price, String campInfo, String theme) {
    //     Camp camp = new Camp(date, price, campInfo);
    //     camp.generateGroupSchedules();
    //     camp.setTheme(theme);    
    //     /**
    //      * TODO:
    //      * create groups/organize by age
    //      * 
    //      * 
    //      */
          
    //     return camp;
    // }

    public void createAccount(String firstName, String lastName, String phoneNumber, String email, String password) {
        RegisteredUser ru = new RegisteredUser(firstName, lastName, email, phoneNumber, password);
        userList.addUser(ru);
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

    public void changeUserInfo(String firstName, String lastName, String phoneNumber, String email, String password) {
        user.changeInfo(firstName, lastName, phoneNumber, email, password);
    }

    public String getSchedules(Camp camp) {
        ArrayList<Group> groups = camp.getGroups();
        String ret = "";
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
            ret += groups.get(i).getGroupName() + "\n"+ "\t" +groups.get(i).getSchedule().toString();
        }
        return ret;
    }
    public String getCampsToString() {
        CampList campList = CampList.getInstance();
        ArrayList<Camp> camps = campList.getAllCamps();
        String ret = "";
        for(int i = 0; i < camps.size(); i++) {
            ret += camps.get(i).toString() + "\n";
        }
        return ret;
    }

    public ArrayList<Group> viewGroups(Camp camp) {
        ArrayList<Group> groups = new ArrayList<>();
        groups = camp.getGroups();
        return groups;
    }
    public Camp getCampByDate(Date date) {
        CampList campList = CampList.getInstance();
        ArrayList<Camp> camps = campList.getAllCamps();
        Camp c = new Camp(null, 0, null);
        for(int i = 0; i < camps.size(); i++) {
            if(camps.get(i).getDate()==date) {
                c = camps.get(i);
            }
        }
        return c;
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

    public void registerChild(Child child, ArrayList<Camp> camp) {
        childList.addChild(child);
        ((RegisteredUser)user).registerChild(child);
        for(Camp c : camp){
            c.addChild(child);
        }
    }

    public void removeChild(int input){
        Child child = ((RegisteredUser)user).removeChild(input);
        ArrayList<Camp> camps = campList.getCamp(child);
        for(Camp c : camps){
            c.removeChild(child);
        }
        childList.removeChild(child);
    }

    public void addNotes(String note) {
        Child child = new Child(campName, campInfo, null, null);
        child.addNote(note);

    }

    public void addToFAQ(String question, String answer) {
        FAQ faq = new FAQ(question, answer);
        FAQ.add(faq);
    }
    public String getFAQ() {
        String ret = "";
        for(int i = 0; i < FAQ.size(); i++) {
            FAQ temp = FAQ.get(i);
            ret += i + " - " + temp.toString();
        }
        ret += "\n\n";
        return ret; 
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
        GroupList groupList = GroupList.getInstance();
        ArrayList<Group> groups = groupList.getAllGroups();
        String ret = "";
        for(int i = 0; i < groups.size(); i++) {
            Group g = groups.get(i);
            ret += (i + 1) + " - " + g.toString() + "\n";
        }
        ret += "\n\n";
        return ret;

    }

    public String viewCamperRegistration(){
        String ret = "";
        int count = 1;
        for(Child c : ((RegisteredUser) user).getChildren()){
            ret += count + " - " + c.toString() + "\n";
            ArrayList<Camp> camps = campList.getCamp(c);
            for(Camp camp : camps){
                ret += camp.toString() + "\n";
            }
            ret += "\n\n";
            count ++;
        }

        return ret;
    }

    public String viewCamperMedInfo(){
        String ret = "";

        for(Child c : ((RegisteredUser) user).getChildren()){
            ret += c.toString() + "\n";
            ret += c.getMedInfo().toString();
            ret += "\n\n";
        }

        return ret;
    }

    public String viewCampInfo(){
        String ret = "";
        for(int i = 0; i < campList.getAllCamps().size(); i++) {
            ArrayList<Camp> camp = campList.getAllCamps();
            Camp c = camp.get(i);
            ret += (i + 1) + " - " + c.toString() + "\n";
        }
        ret += "\n\n";
        return ret;
    }

    public boolean isPhoneValid(String phoneNumber) {

        if (phoneNumber.length() != 12) {
            System.out.println("Invalid Phone Number, please try again");
            return false;
        } else {
            for (int i = 0; i < phoneNumber.length(); i++) {

                if (phoneNumber.charAt(i) != '0' && phoneNumber.charAt(i) != '1'
                        && phoneNumber.charAt(i) != '2' && phoneNumber.charAt(i) != '3'
                        && phoneNumber.charAt(i) != '4' && phoneNumber.charAt(i) != '5'
                        && phoneNumber.charAt(i) != '6' && phoneNumber.charAt(i) != '7'
                        && phoneNumber.charAt(i) != '8' && phoneNumber.charAt(i) != '9'
                        && phoneNumber.charAt(i) != '-') {
                    return false;
                }
            }

            if (phoneNumber.charAt(3) != '-' && phoneNumber.charAt(7) != '-') {
                return true;
            }

        }
        return true;

    }

    public boolean isValidPassword(String password) {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            
            System.out.println("Invalid Password, please try again");
                String[] passwordRequire = {"8 characters and at most 20 character",
                        "one digit", "one upper case alphabet", "one lower case alphabet",
                        "one special character which includes !@#$%&*()-+=^."};
                
                        for (int i = 0; i < passwordRequire.length; i++) {
                    System.out.println((i + 1) + "It contains at least " + passwordRequire[i]); }
                    return false;    
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }

    public boolean isEmailValid(String emailInput) {

            if(emailInput.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}")){
                return true;
            }
            System.out.println("Invalid Email, please try again");
            return false;
        }

    public ArrayList<Camp> getCamps(){
        return campList.getAllCamps();
    }

    public int getNumChildren(){
        return ((RegisteredUser)user).getChildren().size();
    }
}


