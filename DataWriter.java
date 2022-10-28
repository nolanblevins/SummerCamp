import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;

public class DataWriter extends DataConstants{
    public static final String pattern = "dd:MM:yyyy";
    public static void main(String[] args){
        saveActivies();
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

    }

    public static void saveGroups(){

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
            userDetails.put(LIST_UUID, counselor.getId().toString());
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        childDetails.put(LIST_UUID, child.getUUID().toString());
        childDetails.put(FIRST_NAME, child.getFirstName());
        childDetails.put(LAST_NAME, child.getLastName());
        childDetails.put(BIRTHDAY, simpleDateFormat.format(
                child.getBirthday()));
        childDetails.put(ADDRESS, child.getMedInfo().getAddress());
        childDetails.put(NOTES, arrayToStrings(child.getNotes()));
        childDetails.put(ALLERGIES, arrayToStrings(
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

    private static JSONArray getChildrenIDS(ArrayList<Child> children){
        JSONArray uuids = new JSONArray();
        for(Child c : children){
            uuids.add(c.getUUID().toString());
        }
        return uuids;
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

    private static JSONArray arrayToStrings(ArrayList<String> strings){
        JSONArray jsonArray = new JSONArray();
        for(String s : strings){
            jsonArray.add(s);
        }

        return jsonArray;
    }
}
