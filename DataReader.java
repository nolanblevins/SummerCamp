import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
import java.util.Date;

public class DataReader extends DataConstants{
    public static void main(String[] args){
        ArrayList<Child> children = loadChild();
        for(Child c : children){
            System.out.println(c);
        }
    }
    // TODO Add medical info functionality
    // TODO Add Children functionality
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
                    users.add(new Director(firstName, lastName, email, phoneNumber, password));
                } else if (userType.equals("Counselor")) {
                    Date birthday = objectToBirthday(userJSON.get(BIRTHDAY));
                    users.add(new Counselor(uuid, firstName, lastName, email,
                            phoneNumber, password, birthday));
                } else if (userType.equals("RegisteredUser")) {
                    // ArrayList<Child> ruChildren = getRUChildren(userJSON);
                    users.add(new RegisteredUser(firstName, lastName, email, phoneNumber,
                            password));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Camp> loadCamps(){
        return null;
    }

    public static ArrayList<Group> loadGroups(){
        return null;
    }

    public static ArrayList<Activity> loadActivities(){
        return null;
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
                Date birthday = objectToBirthday(childJSON.get(BIRTHDAY));
                ArrayList<String> allergies = parseStringList(childJSON, ALLERGIES);
                Contact contact = getContact(childJSON);
                String address = (String)childJSON.get(ADDRESS);
                ArrayList<String> conditions = parseStringList(childJSON, CONDITIONS);

                MedicalInfo medicalInfo = new MedicalInfo(contact, address,
                        allergies, conditions);

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
     * Gets an instance of the ChildList, then uses UUIDs from the userJSON
     * object to find those children and add them to an array to be returned
     *
     * @param userJSON  The current User that is being looked at
     * @return          An ArrayList of the User's children
     */
    private static ArrayList<Child> getRUChildren(JSONObject userJSON){
        ChildList childList = ChildList.getInstance();
        ArrayList<Child> ruChildren = new ArrayList<>();
        JSONArray uuids = (JSONArray)userJSON.get(USER_CHILDREN);

        for(Object uuidObject : uuids){
            UUID uuid = UUID.fromString((String)uuidObject);
            ruChildren.add(childList.getChild(uuid));
        }
        return ruChildren;
    }

    /**
     * Takes in a JSONObject then gets the emergency contact object from that. Parses
     * through the emergency contact information, creates a contact object, and returns
     * the Contact
     *
     * @param jsonObject    The jsonObject that contains the emergency contact
     * @return              Returns a completed contact object
     */
    private static Contact getContact(JSONObject jsonObject){
        JSONObject ecJSON = (JSONObject)jsonObject.get(EMERGENCY_CONTACT);
        String firstName = (String)ecJSON.get(FIRST_NAME);
        String lastName = (String)ecJSON.get(LAST_NAME);
        String phoneNumber = (String)ecJSON.get(PHONE_NUMBER);
        String relationship = (String)ecJSON.get(EC_RELATIONSHIP);

        return new Contact(firstName, lastName, phoneNumber, relationship);
    }

    /**
     * Takes in the input of a jsonObject representing a bday, and
     * returns that object as a Date object
     *
     * @param bdayObject    Beginning format of the birthday
     * @return              The birthday as a Date object
     */
    private static Date objectToBirthday(Object bdayObject){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(
                    (String) bdayObject);
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
}
