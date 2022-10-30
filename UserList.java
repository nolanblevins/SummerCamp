import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList(){
        this.users = DataReader.loadUsers();
    }

    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(User user){

    }

    public ArrayList<User> getUsers(){
        return this.users;
    }
    public User getUser(String email){
        User ret = null;
        for(User u : users) {
            if(u instanceof User && u.getEmail().compareTo(email)== 0) {
                ret = u;
                break;
            }

        }
        return ret;
    }

    public User getCounselor(UUID uuid){
        User ret = null;
        for(User u : users){
            if(u instanceof Counselor && ((Counselor) u).getUUID().compareTo(uuid) == 0){
                ret = u;
                break;
            }
        }
        return ret;
    }

    public void editUser(User user){

    }

    public void saveUsers(){

    }

    
}
