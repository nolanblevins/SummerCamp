import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public static void main(String[] args){
        saveUsers();
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
            RegisteredUser ru = ((RegisteredUser)user);
            userDetails.put(USER_TYPE, "RegisteredUser");
            userDetails.put(CHILDREN, getChildrenIDS(ru.getChildren()));
            userDetails.put(LIST_UUID, ru.getID().toString());
        }
        else if(user.getUserType() == UserType.COUNSELOR){
            Counselor counselor = ((Counselor)user);
            userDetails.put(LIST_UUID, counselor.getId().toString());
            userDetails.put(USER_TYPE, "Counselor");
            userDetails.put(BIRTHDAY, counselor.getBirthday().toString());
            userDetails.put(ALLERGIES, stringsToArray(
                    counselor.getMedInfo().getAllergies()));
            userDetails.put(ADDRESS, counselor.getMedInfo().getAddress());
            userDetails.put(CONDITIONS, stringsToArray(
                    counselor.getMedInfo().getConditions()));
            userDetails.put(EMERGENCY_CONTACT, getContactObject(
                    counselor.getMedInfo().getEmergencyContact()));
        }
        else{
            Director director = ((Director)user);
            userDetails.put(USER_TYPE, "Director");
            userDetails.put(LIST_UUID, director.getID().toString());
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

    private static JSONArray stringsToArray(ArrayList<String> strings){
        JSONArray jsonStrings = new JSONArray();

        for(String s : strings){
            jsonStrings.add(s);
        }

        return jsonStrings;
    }

    private static JSONObject getContactObject(Contact contact){
        JSONObject jsonContact = new JSONObject();
        jsonContact.put(FIRST_NAME, contact.getFirstName());
        jsonContact.put(LAST_NAME, contact.getLastName());
        jsonContact.put(PHONE_NUMBER, contact.getPhoneNumber());
        jsonContact.put(EC_RELATIONSHIP, contact.getRelationship());
        return jsonContact;
    }
}
