import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public static void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(User u : users){
            jsonUsers.add(getUserJSON(u));
        }

        try{

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveChildren(){

    }

    public static void saveCamps(){

    }

    public static void saveGroups(){

    }

    public static void saveActivies(){

    }

    private static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(FIRST_NAME, user.getFirstName());
        userDetails.put(LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(PHONE_NUMBER, user.getPhoneNumber());
        userDetails.put(USER_PASSWORD, user.getPassword());
        if(user.getUserType() == UserType.REGISTERED_USER){
            userDetails.put(USER_TYPE, "RegisteredUser");
            userDetails.put(CHILDREN, getChildrenIDS(
                    ((RegisteredUser)user).getChildren()));
        }
        else if(user.getUserType() == UserType.COUNSELOR){

        }
        else{

        }
        return userDetails;
    }

    private static JSONArray getChildrenIDS(ArrayList<Child> children){
        JSONArray uuids = new JSONArray();
        for(Child c : children){
            uuids.add(c.getUUID().toString());
        }
        return uuids;
    }
}
