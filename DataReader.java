import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
import java.util.Date;

public class DataReader extends DataConstants{
    public static void main(String[] args){
        ArrayList<User> users = loadUsers();
        for(User u : users){
            System.out.println(u);
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
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < usersJSON.size(); i++){
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID uuid = UUID.fromString((String)userJSON.get(LIST_UUID));
                String userType = (String)userJSON.get(USER_TYPE);
                String firstName = (String)userJSON.get(FIRST_NAME);
                String lastName = (String)userJSON.get(LAST_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String phoneNumber = (String)userJSON.get(USER_PHONE_NUMBER);
                String password = (String)userJSON.get(USER_PASSWORD);
                if(userType.equals("Director")){
                    users.add(new Director(firstName, lastName, email, phoneNumber, password));
                }
                else if(userType.equals("Counselor")){
                    Date birthday = objectToBirthday(userJSON.get(BIRTHDAY));
                    users.add(new Counselor(uuid, firstName, lastName, email,
                            phoneNumber, password, birthday));
                }else if(userType.equals("RegisteredUser")){
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
        return null;
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
}
