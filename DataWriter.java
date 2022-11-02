import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;

public class DataWriter extends DataConstants{
    public static final String pattern = "MM:dd:yyyy";
    public static void main(String[] args){
        saveGroups();
    }
    public static void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(User u : users){
            jsonUsers.add(getUserJSON(u));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test.JSON");
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveChildren(){
        ChildList childList = ChildList.getInstance();
        ArrayList<Child> children = childList.getChildren();
        JSONArray jsonChildren = new JSONArray();

        for(Child c : children){
            jsonChildren.add(getChildJSON(c));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test.JSON");
            file.write(jsonChildren.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveCamps(){
        CampList campList = CampList.getInstance();
        ArrayList<Camp> camps = campList.getAllCamps();
        JSONArray jsonChildren = new JSONArray();

        for(Camp c : camps){
            jsonChildren.add(getCampJSON(c));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test.JSON");
            file.write(jsonChildren.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveGroups(){
        GroupList groupList = GroupList.getInstance();
        ArrayList<Group> groups = groupList.getAllGroups();
        JSONArray jsonGroups = new JSONArray();

        for(Group g : groups){
            jsonGroups.add(getGroupJSON(g));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test2.JSON");
            file.write(jsonGroups.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveActivies(){
        ActivityList activityList = ActivityList.getInstance();
        ArrayList<Activity> activities = activityList.getAllActivities();
        JSONArray jsonActivity = new JSONArray();

        for(Activity a : activities){
            jsonActivity.add(getActivityJSON(a));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test.JSON");
            file.write(jsonActivity.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveFAQs(){
        FAQList faqList = FAQList.getInstance();
        ArrayList<FAQ> faqs = faqList.getFaqs();
        JSONArray jsonFAQs = new JSONArray();

        for(FAQ f : faqs){
            jsonFAQs.add(getFAQJSON(f));
        }

        try{
            FileWriter file = new FileWriter("./JSON/Test.JSON");
            file.write(jsonFAQs.toJSONString());
            file.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static JSONObject getFAQJSON(FAQ faq){
        JSONObject faqDetails = new JSONObject();
        faqDetails.put(FAQ_QUESTION, faq.getQuestion());
        faqDetails.put(FAQ_ANSWER, faq.getAnswer());

        return faqDetails;
    }

    private static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(FIRST_NAME, user.getFirstName());
        userDetails.put(LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(PHONE_NUMBER, user.getPhoneNumber());
        userDetails.put(USER_PASSWORD, user.getPassword());
        if(user.getUserType() == UserType.REGISTERED_USER){
            RegisteredUser ru = ((RegisteredUser)user);
            userDetails.put(USER_TYPE, "RegisteredUser");
            userDetails.put(CHILDREN, getChildrenIDS(ru.getChildren()));
            userDetails.put(LIST_UUID, ru.getID().toString());
        }
        else if(user.getUserType() == UserType.COUNSELOR){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Counselor counselor = ((Counselor)user);
            userDetails.put(LIST_UUID, counselor.getID().toString());
            userDetails.put(USER_TYPE, "Counselor");
            userDetails.put(BIRTHDAY, simpleDateFormat.format(
                    counselor.getBirthday()));
            userDetails.put(ALLERGIES, stringsToArray(
                    counselor.getMedInfo().getAllergies()));
            userDetails.put(ADDRESS, counselor.getMedInfo().getAddress());
            userDetails.put(CONDITIONS, stringsToArray(
                    counselor.getMedInfo().getMedNotes()));
            userDetails.put(EMERGENCY_CONTACT, getContactObject(
                    counselor.getMedInfo().getEmergencyContact()));
            userDetails.put(PEDIATRICIAN, getPediatricianObject(
                    counselor.getMedInfo().getPediatrician()));
        }
        else{
            Director director = ((Director)user);
            userDetails.put(USER_TYPE, "Director");
            userDetails.put(LIST_UUID, director.getID().toString());
        }
        return userDetails;
    }

    private static JSONObject getChildJSON(Child child){
        JSONObject childDetails = new JSONObject();

        childDetails.put(LIST_UUID, child.getUUID().toString());
        childDetails.put(FIRST_NAME, child.getFirstName());
        childDetails.put(LAST_NAME, child.getLastName());
        childDetails.put(BIRTHDAY, new SimpleDateFormat(pattern).format(
                child.getBirthday()));
        childDetails.put(ADDRESS, child.getMedInfo().getAddress());
        childDetails.put(NOTES, stringsToArray(child.getNotes()));
        childDetails.put(ALLERGIES, stringsToArray(
                child.getMedInfo().getAllergies()));
        childDetails.put(EMERGENCY_CONTACT, getContactObject(
                child.getMedInfo().getEmergencyContact()));
        childDetails.put(CONDITIONS, child.getMedInfo().getMedNotes());
        childDetails.put(PEDIATRICIAN, getPediatricianObject(
                child.getMedInfo().getPediatrician()));
        return childDetails;
    }

    private static JSONObject getActivityJSON(Activity activity){
        JSONObject activityJSON = new JSONObject();
        activityJSON.put(LIST_UUID, activity.getUuid().toString());
        activityJSON.put(ACTIVITY_TITLE, activity.getTitle());
        activityJSON.put(ACTIVITY_DURATION, activity.getDuration());
        activityJSON.put(ACTIVITY_DESCRIPTION, activity.getDescription());
        activityJSON.put(ACTIVITY_LOCATION, activity.getLocation());

        return activityJSON;
    }

    private static JSONObject getCampJSON(Camp camp){
        JSONObject campJSON = new JSONObject();
        campJSON.put(LIST_UUID, camp.getUuid().toString());
        campJSON.put(CAMP_DATE, new SimpleDateFormat(pattern).format(
                camp.getDate()));
        campJSON.put(CAMP_THEME, camp.getTheme());
        campJSON.put(CAMP_PRICE, camp.getPrice());
        campJSON.put(CAMP_GROUP_ID, getGroupIDS(camp.getGroups()));

        return campJSON;
    }

    private static JSONObject getGroupJSON(Group group){
        JSONObject groupJSON = new JSONObject();
        groupJSON.put(LIST_UUID, group.getUUID().toString());
        groupJSON.put(GROUP_NAME, group.getGroupName());
        groupJSON.put(GROUP_CABIN, group.getCabin());
        groupJSON.put(GROUP_SIZE, group.getGroupSize());
        groupJSON.put(GROUP_COUNSELOR, group.getCounselor().getID().toString());
        groupJSON.put(CHILDREN, getChildrenIDS(group.getCampers()));
        groupJSON.put(GROUP_SCHEDULE, getSchedule(group.getSchedule()));
        groupJSON.put(GROUP_MAX, group.getMax());
        groupJSON.put(GROUP_MIN, group.getMin());

        return groupJSON;
    }
    private static JSONArray getChildrenIDS(ArrayList<Child> children){
        JSONArray uuids = new JSONArray();
        for(Child c : children){
            uuids.add(c.getUUID().toString());
        }
        return uuids;
    }

    private static JSONArray getGroupIDS(ArrayList<Group> groups){
        JSONArray uuids = new JSONArray();
        for(Group g : groups){
            uuids.add(g.getUUID().toString());
        }
        return uuids;
    }

    private static JSONObject getSchedule(ArrayList<Schedule> schedules){
        JSONObject scheduleJSON = new JSONObject();

        for(Schedule s : schedules){
            JSONArray dayJSON = new JSONArray();
            for(Activity a : s.getSchedule()){
                dayJSON.add(a.getUuid().toString());
            }
            scheduleJSON.put(s.getDay().toString(), dayJSON);
        }

        return scheduleJSON;
    }


    private static JSONArray stringsToArray(ArrayList<String> strings){
        JSONArray jsonStrings = new JSONArray();

        for(String s : strings){
            jsonStrings.add(s);
        }

        return jsonStrings;
    }

    private static JSONArray getContactObject(ArrayList<Contact> contacts){
        JSONArray contactArray = new JSONArray();
        for(Contact c : contacts){
            JSONObject jsonContact = new JSONObject();
            jsonContact.put(FIRST_NAME, c.getFirstName());
            jsonContact.put(LAST_NAME, c.getLastName());
            jsonContact.put(PHONE_NUMBER, c.getPhoneNumber());
            jsonContact.put(EC_RELATIONSHIP, c.getRelationship());
            contactArray.add(jsonContact);
        }
        return contactArray;
    }

    private static JSONObject getPediatricianObject(Pediatrician pediatrician){
        JSONObject pJSON = new JSONObject();
        pJSON.put(FIRST_NAME, pediatrician.getFirstName());
        pJSON.put(LAST_NAME, pediatrician.getLastName());
        pJSON.put(PHONE_NUMBER, pediatrician.getPhoneNumber());
        pJSON.put(PEDIATRICIAN_BUSINESS, pediatrician.getBusiness());
        return pJSON;
    }
}
