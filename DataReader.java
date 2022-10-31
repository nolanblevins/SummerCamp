import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
import java.util.Date;

public class DataReader extends DataConstants{
    /**
     * Iterates through the file User.JSON, determines the type of the user,
     * then based on the type of the user, will construct that user and add it
     * to the ArrayList of users which is returned at the end
     *
     * @return  An ArrayList containing all the users
     */
    public static ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<>();

        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (Object userObject : usersJSON) {
                JSONObject userJSON = (JSONObject)userObject;
                UUID uuid = UUID.fromString((String) userJSON.get(LIST_UUID));
                String userType = (String) userJSON.get(USER_TYPE);
                String firstName = (String) userJSON.get(FIRST_NAME);
                String lastName = (String) userJSON.get(LAST_NAME);
                String email = (String) userJSON.get(USER_EMAIL);
                String phoneNumber = (String) userJSON.get(PHONE_NUMBER);
                String password = (String) userJSON.get(USER_PASSWORD);
                if (userType.equals("Director")) {
                    users.add(new Director(uuid, firstName, lastName, email, phoneNumber, password));
                } else if (userType.equals("Counselor")) {
                    Date birthday = objectToDate(userJSON.get(BIRTHDAY));
                    MedicalInfo medicalInfo = getMedInfo(userJSON);
                    users.add(new Counselor(uuid, firstName, lastName, email,
                            phoneNumber, password, birthday, medicalInfo));
                } else if (userType.equals("RegisteredUser")) {
                    ArrayList<Child> ruChildren = getChildren(userJSON);
                    users.add(new RegisteredUser(uuid, firstName, lastName, email, phoneNumber,
                            password, ruChildren));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Camp> loadCamps(){
        ArrayList<Camp> camps = new ArrayList<>();

        try{
            FileReader reader = new FileReader(CAMP_FILE_NAME);
            JSONArray campsJSON = (JSONArray)new JSONParser().parse(reader);

            for(Object campObject : campsJSON){
                JSONObject campJSON = (JSONObject)campObject;
                UUID uuid = UUID.fromString((String)campJSON.get(LIST_UUID));
                Date date = objectToDate(campJSON.get(CAMP_DATE));
                String theme = (String)campJSON.get(CAMP_THEME);
                double price = (double)campJSON.get(CAMP_PRICE);
                ArrayList<Group> groups = getGroups(campJSON);

                camps.add(new Camp(uuid, date, theme, price, groups));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return camps;
    }

    public static ArrayList<Group> loadGroups(){
        ArrayList<Group> groups = new ArrayList<>();

        try{
            FileReader reader = new FileReader(GROUP_FILE_NAME);
            JSONArray groupsJSON = (JSONArray)new JSONParser().parse(reader);

            for(Object groupObject : groupsJSON){
                JSONObject groupJSON = (JSONObject)groupObject;
                UUID uuid = UUID.fromString((String) groupJSON.get(LIST_UUID));
                String groupName = (String)groupJSON.get(GROUP_NAME);
                long cabinL = (long)groupJSON.get(GROUP_CABIN);
                int cabin = (int)cabinL;
                long groupSizeL = (long)groupJSON.get(GROUP_SIZE);
                int groupSize = (int)groupSizeL;
                User counselor = getCounselor(groupJSON);
                ArrayList<Child> campers = getChildren(groupJSON);
                ArrayList<Schedule> schedule = getSchedules(groupJSON);

                groups.add(new Group(uuid, groupName, cabin, groupSize, counselor, campers, schedule));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return groups;
    }

    public static ArrayList<Activity> loadActivities(){
        ArrayList<Activity> activities = new ArrayList<>();
        try{
            FileReader reader = new FileReader(ACTIVITY_FILE_NAME);
            JSONArray activitiesJSON = (JSONArray)new JSONParser().parse(reader);

            for(Object activityObject : activitiesJSON){
                JSONObject activityJSON = (JSONObject)activityObject;
                UUID uuid = UUID.fromString((String) activityJSON.get(LIST_UUID));
                String title = (String)activityJSON.get(ACTIVITY_TITLE);
                int duration = (int)(long)activityJSON.get(ACTIVITY_DURATION);
                String description = (String)activityJSON.get(ACTIVITY_DESCRIPTION);
                String location = (String)activityJSON.get(ACTIVITY_LOCATION);

                activities.add(new Activity(uuid, title, duration, description,
                        location));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return activities;
    }

    public static ArrayList<Child> loadChild(){
        ArrayList<Child> children = new ArrayList<>();

        try{
            FileReader reader = new FileReader(CHILD_FILE_NAME);
            JSONArray childrenJSON = (JSONArray)new JSONParser().parse(reader);

            for(Object childObject : childrenJSON){
                JSONObject childJSON = (JSONObject)childObject;
                UUID uuid = UUID.fromString((String)childJSON.get(LIST_UUID));
                String firstName = (String)childJSON.get(FIRST_NAME);
                String lastName = (String)childJSON.get(LAST_NAME);
                ArrayList<String> notes = parseStringList(childJSON, NOTES);
                Date birthday = objectToDate(childJSON.get(BIRTHDAY));
                MedicalInfo medicalInfo = getMedInfo(childJSON);

                Child child = new Child(uuid, firstName, lastName, medicalInfo,
                        birthday, notes);

                children.add(child);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return children;
    }

    /**
     * Gets an instance of the ChildList, then uses UUIDs from the jsonObject
     * object to find those children and add them to an array to be returned
     *
     * @param jsonObject  The current User that is being looked at
     * @return          An ArrayList of the User's children
     */
    private static ArrayList<Child> getChildren(JSONObject jsonObject){
        ChildList childList = ChildList.getInstance();
        ArrayList<Child> children = new ArrayList<>();
        JSONArray uuids = (JSONArray)jsonObject.get(CHILDREN);

        for(Object uuidObject : uuids){
            UUID uuid = UUID.fromString((String)uuidObject);
            children.add(childList.getChild(uuid));
        }
        return children;
    }

    private static ArrayList<Group> getGroups(JSONObject jsonObject){
        GroupList groupList = GroupList.getInstance();
        ArrayList<Group> groups = new ArrayList<>();
        JSONArray uuids = (JSONArray)jsonObject.get(CAMP_GROUP_ID);

        for(Object uuidObject : uuids){
            UUID uuid = UUID.fromString((String)uuidObject);
            groups.add(groupList.getGroup(uuid));
        }

        return groups;
    }

    /**
     * Takes in a JSONObject then gets the emergency contact object from that. Parses
     * through the emergency contact information, creates a contact object, and returns
     * the Contact
     *
     * @param jsonObject    The jsonObject that contains the emergency contact
     * @return              Returns a completed contact object
     */
    private static ArrayList<Contact> getContacts(JSONObject jsonObject){
        ArrayList<Contact> contacts = new ArrayList<>();
        JSONArray ecArray = (JSONArray)jsonObject.get(EMERGENCY_CONTACT);

        for(Object o : ecArray) {
            JSONObject ecJSON = (JSONObject)o;
            String firstName = (String) ecJSON.get(FIRST_NAME);
            String lastName = (String) ecJSON.get(LAST_NAME);
            String phoneNumber = (String) ecJSON.get(PHONE_NUMBER);
            String relationship = (String) ecJSON.get(EC_RELATIONSHIP);
            contacts.add(new Contact(firstName, lastName, phoneNumber, relationship));
        }
        return contacts;
    }

    private static ArrayList<Schedule> getSchedules(JSONObject groupJSON){
        ActivityList activitylist = ActivityList.getInstance();
        ArrayList<Schedule> schedules = new ArrayList<>();
        JSONObject scheduleJSON = (JSONObject)groupJSON.get(GROUP_SCHEDULE);

        for(String day : SCHEDULE_DAYS){
            ArrayList<Activity> activities = new ArrayList<>();
            JSONArray scheduleJA = (JSONArray)scheduleJSON.get(day);
            for(Object o : scheduleJA){
                activities.add(activitylist.getActivity(
                        UUID.fromString((String)o)));
            }
            schedules.add(new Schedule(activities, WeekDay.valueOf(day)));
        }

        return schedules;
    }

    private static MedicalInfo getMedInfo(JSONObject jsonObject){
        ArrayList<String> allergies = parseStringList(jsonObject, ALLERGIES);
        ArrayList<Contact> contacts = getContacts(jsonObject);
        String address = (String)jsonObject.get(ADDRESS);
        ArrayList<String> medNotes = parseStringList(jsonObject, CONDITIONS);
        Pediatrician pediatrician = getPediatrician((JSONObject)jsonObject.get(PEDIATRICIAN));
        MedicalInfo medicalInfo = new MedicalInfo(contacts, address,
                allergies, medNotes, pediatrician);

        return medicalInfo;
    }

    /**
     * Takes in the input of a jsonObject representing a date, and
     * returns that object as a Date object
     *
     * @param dateObject    Beginning format of the birthday
     * @return              The birthday as a Date object
     */
    private static Date objectToDate(Object dateObject){
        try {
            return new SimpleDateFormat("MM:dd:yyyy").parse(
                    (String) dateObject);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This object takes in a jsonObject, then accesses a jsonArray based on a dataConstant
     * label that is inputted. Then it iterates through the array of objects, casts
     * them to a string, and adds it to the return ArrayList
     *
     * @param jsonObject    The object that is currently being looked at
     * @param dataConstant  Which part of the object will be accessed
     * @return              Returns an ArrayList containing the parts of the array
     */
    private static ArrayList<String> parseStringList(JSONObject jsonObject, String dataConstant){
        ArrayList<String> ret = new ArrayList<>();
        JSONArray strings = (JSONArray)jsonObject.get(dataConstant);
        for(Object string : strings){
            ret.add((String)string);
        }
        return ret;
    }

    private static User getCounselor(JSONObject groupJSON) {
        UUID uuid = UUID.fromString((String)groupJSON.get(GROUP_COUNSELOR));
        UserList userList = UserList.getInstance();
        return userList.getUser(uuid);
    }

    private static Pediatrician getPediatrician(JSONObject pJSON){
        String firstName = (String)pJSON.get(FIRST_NAME);
        String lastName = (String)pJSON.get(LAST_NAME);
        String phoneNumber = (String)pJSON.get(PHONE_NUMBER);
        String business = (String)pJSON.get(PEDIATRICIAN_BUSINESS);
        return new Pediatrician(firstName, lastName, phoneNumber, business);
    }
}
