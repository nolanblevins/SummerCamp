import java.util.ArrayList;
import java.util.Date;
import java.util.regex.*;


// TODO Have director input a list of themes for a camp, instantiate camp based on that
public class CampSystemFacade {
    private String campName;
    private User user;
    private String campInfo;
    private CampList campList;
    private UserList userList;
    private ActivityList activityList;
    private ChildList childList;
    private GroupList groupList;
    private FAQList faqList;

    /**
     * Parameterized Constructor for Camp Facade
     *
     * @param campName is the name of the camp
     * @param user     is the current user
     * @param campInfo is the information of the camp
     */
    public CampSystemFacade(String campName, User user, String campInfo) {
        this.campName = campName;
        this.user = user;
        this.campInfo = campInfo;
        this.campList = CampList.getInstance();
        this.userList = UserList.getInstance();
        this.activityList = ActivityList.getInstance();
        this.childList = ChildList.getInstance();
        this.groupList = GroupList.getInstance();
        this.faqList = FAQList.getInstance();
    }

    /**
     * Method to access all camps
     *
     * @return will return all camps in campList from JSON
     */
    public ArrayList<Camp> viewAllCamps() {
        ArrayList<Camp> camps = campList.getAllCamps();
        return camps;
    }

    /**
     * Method to create a new users account
     *
     * @param firstName   is the Users First Name
     * @param lastName    is the Users Last Name
     * @param phoneNumber is the Users Phone Number
     * @param email       is the Users Email
     * @param password    is the Users Password
     */
    public void createAccount(String firstName, String lastName, String phoneNumber, String email, String password) {
        RegisteredUser ru = new RegisteredUser(firstName, lastName, email, phoneNumber, password);
        userList.addUser(ru);
    }

    public void createCamp(Date date, double price, String theme){
        Camp camp = new Camp(date, price, theme);
        campList.addCamp(camp);
        ArrayList<Group> groups = camp.getGroups();
        for(Group g : groups){
            groupList.addGroup(g);
        }
    }

    /**
     * Method will change the User to a usertype of director and allow access to the
     * director portal
     *
     * @param email    is the directors Email
     * @param password is the directors password
     * @return will return true if the user entered information that allows for a
     *         director login
     */
    public boolean loginDirector(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.DIRECTOR) {
            user = null;
            return false;
        }
        return true;
    }

    /**
     * Method will change the User to a usertype of counselor and allow access to
     * the counselor portal
     *
     * @param email    is the counselors email
     * @param password is the counselors password
     * @return will return true if the user entered information that allows for a
     *         counselor login
     */
    public boolean loginCounselor(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.COUNSELOR) {
            user = null;
            return false;
        }
        return true;
    }

    /**
     * Method will change the User to a usertype of registered user and allow access
     * to the registered user portal
     *
     * @param email    is the registered users email
     * @param password is the registered users password
     * @return will return true if the user entered information that allows for a
     *         registered user login
     */
    public boolean loginRegisteredUser(String email, String password) {
        user = userList.getUser(email, password);
        if (user == null || user.getUserType() != UserType.REGISTERED_USER) {
            user = null;
            return false;
        }
        return true;
    }

    /**
     * Method will logoff the user
     */
    public void logOff() {
        user = null;
    }

    /**
     * Method allows for the user to change any desired information
     *
     * @param firstName   is the users first name
     * @param lastName    is the users last name
     * @param phoneNumber is the users phone number
     * @param email       is the users email
     * @param password    is the users password
     */
    public void changeUserInfo(String firstName, String lastName, String phoneNumber, String email, String password) {
        user.changeInfo(firstName, lastName, phoneNumber, email, password);
    }

    /**
     * Method will allow for the user to change a child information
     *
     * @param childInput  is the index of childs position in the array list
     * @param firstName   is the childs first name
     * @param lastName    is the childs last name
     * @param medicalInfo is the childs medical information
     */
    public void changeChildInfo(int childInput, String firstName, String lastName, MedicalInfo medicalInfo) {
        Child child = ((RegisteredUser) user).getChildren().get(childInput);
        child.changeInfo(firstName, lastName, medicalInfo);
    }

    public void changeCounselorMedInfo(MedicalInfo medicalInfo){
        ((Counselor)user).setMedicalInfo(medicalInfo);
    }

    /**
     * Method allows for access of camps schedules for each group
     *
     * @param camp is the camp that the user would like to acccess the scheules of
     * @return will return the schedule of every group in the camp
     */
    public String getSchedules(Camp camp) {
        ArrayList<Group> groups = camp.getGroups();
        String ret = "";
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
            ret += groups.get(i).getGroupName() + "\n" + "\t" + groups.get(i).getSchedule().toString();
        }
        return ret;
    }

    /**
     * Method to get all camps in string format
     *
     * @return will return a concatenated string of camps including their
     *         information
     */
    public String getCampsToString() {
        CampList campList = CampList.getInstance();
        ArrayList<Camp> camps = campList.getAllCamps();
        String ret = "";
        for(int i = 0; i < camps.size(); i++) {
            ret += camps.get(i).toString() + "\n";
        }
        return ret;
    }

    /**
     * Method to view all groups in passed through camp
     *
     * @param camp is the camp that the user would like to get the groups of
     * @return will return the groups in the @param camp
     */
    public ArrayList<Group> viewGroups(Camp camp) {
        ArrayList<Group> groups = new ArrayList<>();
        groups = camp.getGroups();
        return groups;
    }

    /**
     * Method will callow the user to get a camp based upon passed through date
     *
     * @param date is the start date of the camp that the user would like to view
     * @return will return the camp with the same start date as the @param date
     */
    public Camp getCampByDate(Date date) {
        CampList campList = CampList.getInstance();
        ArrayList<Camp> camps = campList.getAllCamps();
        Camp c = new Camp(null, 0, null);
        for (int i = 0; i < camps.size(); i++) {
            if (camps.get(i).getDate() == date) {
                c = camps.get(i);
            }
        }
        return c;
    }

    /**
     * Method to retrieve a camp based upon the passed through camp
     *
     * @param child is the child to retieve the camps by
     * @return will return a camp based upon @param child
     */
    public ArrayList<Camp> getCampsByChild(Child child){
        return campList.getCamp(child);
    }

    /**
     * Method to get a child based upon index
     *
     * @param childInput is the index of the child in the list
     * @return will return the child based upon @param childInput
     */
    public Child getChild(int childInput){
        return ((RegisteredUser)user).getChildren().get(childInput);
    }

    /**
     * Method returns all counselors in passed through camp
     *
     * @param camp is the camp of the desired counselors to retrieve
     * @return the counselors in @param camp
     */
    public String getCounselors(Camp camp) {
        ArrayList<Group> groups = camp.getGroups();
        String ret = "";
        for (int i = 0; i < groups.size(); i++) {
            Group g = groups.get(i);
            Counselor c = g.getCounselor();
            ret += c + "\n";
        }
        return ret;
    }

    /**
     * Method will create an activity and add it to the activity list
     *
     * @param title       is the activities title
     * @param duration    is the activities duration in hours
     * @param description is the activities description
     * @param location    is the activities location
     */
    public void addActivity(String title, int duration, String description, String location) {
        Activity activity = new Activity(title, duration, description, location);
        ActivityList activityList = ActivityList.getInstance();
        activityList.addActivity(activity);
    }

    /**
     * Method adds a passed through child to the passed through camp
     *
     * @param child is the child to be registered
     * @param camp  is the camp to register the @param child to
     */
    public void registerChild(Child child, ArrayList<Camp> camp) {
        childList.addChild(child);
        ((RegisteredUser) user).registerChild(child);
        for (Camp c : camp) {
            c.addChild(child);
        }
    }

    /**
     * Method to remove the child from the child list
     *
     * @param input is the index of the child to remove
     */
    public void removeChild(int input) {
        Child child = ((RegisteredUser) user).removeChild(input);
        ArrayList<Camp> camps = campList.getCamp(child);
        for (Camp c : camps) {
            c.removeChild(child);
        }
        childList.removeChild(child);
    }

    /**
     * Method to add a note to a child
     *
     * @param note  is the note to be added to the @param child
     * @param child is the child to have the @param note added to
     */
    public void addNotes(String note, Child child) {
        child.addNote(note);
    }

    /**
     * Method will add a FAQ entry to the FAQ list
     *
     * @param question is the question of the FAQ
     * @param answer   is the answer to the passed through @param question of the
     *                 FAQ
     */
    public void addToFAQ(String question, String answer) {
        FAQ faq = new FAQ(question, answer);
        faqList.addFAQ(faq);
    }

    /**
     * Accesor method for the faq
     *
     * @return will return the FAQ of the camp in String format
     */
    public String getFAQ() {
        String ret = "";
        ArrayList<FAQ> FAQ = faqList.getFaqs();
        for (int i = 0; i < FAQ.size(); i++) {
            FAQ temp = FAQ.get(i);
            ret += temp.toString() + "\n\n";
        }
        ret += "\n\n";
        return ret;
    }

    /**
     * Method to get the desired childs medical info
     *
     * @param child is the child that the user would like to access the medical info
     *              of
     * @return will return the @param child 's medical info
     */
    public String getChildMedicalInfo(Child child) {
        return child.getMedInfo().toString();
    }

    /**
     * Method to get the desired counselors medical info
     *
     * @param counselor is the counslor that the user would like to access the
     *                  medical info of
     * @return will return the @param counselor 's medical info
     */
    public String getCounselorMedInfo(Counselor counselor) {
        return counselor.getMedInfo().toString();
    }

    /**
     * Method to get a counselors group from a certain camp
     *
     * @return will return the group as a String
     */
    public String viewGroup(Camp camp) {
        return camp.viewGroup((Counselor)user);
    }

    /**
     * Method will retrieve campers and the camp they are registered to
     *
     * @return will return the camp and campers
     */
    public String viewCamperRegistration() {
        String ret = "";
        int count = 1;
        for (Child c : ((RegisteredUser) user).getChildren()) {
            ret += count + " - " + c.toString() + "\n";
            ArrayList<Camp> camps = campList.getCamp(c);
            for (Camp camp : camps) {
                ret += camp.toString() + "\n";
            }
            ret += "\n\n";
            count++;
        }

        return ret;
    }

    /**
     * Method to access all child medical information
     *
     * @return will return all of the campers medical info
     */
    public String viewCamperMedInfo() {
        String ret = "";

        for (Child c : ((RegisteredUser) user).getChildren()) {
            ret += c.toString() + "\n";
            ret += c.getMedInfo().toString();
            ret += "\n\n";
        }

        return ret;
    }

    public String viewCamperMedInfo(Camp camp){
        String ret = "";

        Group group = camp.getGroup((Counselor)user);

        for (Child c : group.getCampers()) {
            ret += c.toString() + "\n";
            ret += c.getMedInfo().toString();
            ret += "\n\n";
        }

        return ret;
    }

    /**
     * Method to view all of the camps information
     *
     * @return will return all of the camps information
     */
    public String viewCampInfo() {
        String ret = "";
        for (int i = 0; i < campList.getAllCamps().size(); i++) {
            ArrayList<Camp> camp = campList.getAllCamps();
            Camp c = camp.get(i);
            ret += (i + 1) + " - " + c.toString() + "\n";
        }
        ret += "\n\n";
        return ret;
    }

    public ArrayList<Camp> getCounselorCamps(){
        return campList.getCamp(((Counselor)user));
    }

    /**
     * Method to check for valid formatting of phone number
     *
     * @param phoneNumber is the phone number to be checked for validity
     * @return will return true if the @param phoneNumber is valid
     */
    public boolean isPhoneValid(String phoneNumber) {

        if (phoneNumber.length() != 12) {
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

    /**
     * Method to check if password is formatted correctly
     *
     * @param password is the password to be checked for validity
     * @return will return true if @param password is valid
     */
    public boolean isValidPassword(String password) {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {

            System.out.println("Invalid Password, please try again");
            String[] passwordRequire = { "8 characters and at most 20 character",
                    "one digit", "one upper case alphabet", "one lower case alphabet",
                    "one special character which includes !@#$%&*()-+=^." };

            for (int i = 0; i < passwordRequire.length; i++) {
                System.out.println((i + 1) + "It contains at least " + passwordRequire[i]);
            }
            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }

    /**
     * Method to check if a email is formatted correctly
     *
     * @param emailInput is the email to be checked for validity
     * @return will return true if @param email is valid
     */
    public boolean isEmailValid(String emailInput) {

        if (emailInput.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}")) {
            return true;
        }
        System.out.println("Invalid Email, please try again");
        return false;
    }

    /**
     * Method to get all of the camps in camp list
     *
     * @return will return all of the camps in the camp list
     */
    public ArrayList<Camp> getCamps() {
        return campList.getAllCamps();
    }

    /**
     * Method to return an integer of number of children for a single registered
     * user
     *
     * @return will return the number of children for a registered user
     */
    public int getNumChildren() {
        return ((RegisteredUser) user).getChildren().size();
    }

    public String getCounselorSchedule(Camp camp) {
        return camp.getCounselorSchedule(((Counselor)user));
    }

    /**
     * Method will call the save method, to make sure that the data
     * is saved at the end of the program
     */
    public void saveInformation(){
        DataWriter.saveChildren();
        DataWriter.saveFAQs();
        DataWriter.saveUsers();
        DataWriter.saveCamps();
        DataWriter.saveGroups();
        DataWriter.saveActivies();
    }
}


