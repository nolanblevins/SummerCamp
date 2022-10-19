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
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String phoneNumber = (String)userJSON.get(USER_PHONE_NUMBER);
                String password = (String)userJSON.get(USER_PASSWORD);
                if(userType.equals("Director")){
                    users.add(new Director(firstName, lastName, email, phoneNumber, password));
                }
                else if(userType.equals("Counselor")){
                    Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(
                            (String)userJSON.get(USER_BIRTHDAY));
                    users.add(new Counselor(uuid, firstName, lastName, email,
                            phoneNumber, password, birthday));
                }else if(userType.equals("RegisteredUser")){

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

    private static ArrayList<Child> getRUChildren(JSONObject userJSON, String[] uuids){


        return null;
    }
}
